package com.baibao.web.p2p.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.web.ftl.lib.TextMask;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_contract_templateMapper;
import com.baibao.web.p2p.generator.dao.P2p_creditor_packMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_applyMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_product_aidMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_profitMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_recordMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_infoMapper;
import com.baibao.web.p2p.service.ContractService;
import com.baibao.common.util.HtmlToPdfUtil;
import com.baibao.utils.MapBuilder;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service("contractService")
public class ContractServiceImpl
	implements ContractService, InitializingBean
{
	private static final Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	@Autowired
	private P2p_contract_templateMapper p2p_contract_templateMapper;

	@Autowired
	private P2p_loan_applyMapper p2p_loan_applyMapper;
	
	@Autowired
	private P2p_loan_product_aidMapper p2p_loan_product_aidMapper;

	@Autowired
	private P2p_user_infoMapper p2p_user_infoMapper;

	@Autowired
	private P2p_tender_recordMapper p2p_tender_recordMapper;

	@Autowired
	private P2p_creditor_packMapper p2p_creditor_packMapper;
	
	@Autowired
	private P2p_tender_profitMapper p2p_tender_profitMapper;
	
	@Autowired
	private JedisUtil jedisUtil;
	
	
	private Configuration configuration = new Configuration(
		Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

	@Override
	public void afterPropertiesSet()
		throws Exception
	{
		configuration.setTemplateLoader(this);
	}

	@Override
	public Object findTemplateSource(String name)
		throws IOException
	{
		if (p2p_contract_templateMapper.countTemplate(name) == 0l)
		{
			return null;
		}
		
		return name;
	}

	@Override
	public long getLastModified(Object templateSource)
	{
		String code = String.valueOf(templateSource);
		String key = String.format("ctempalte-%s-time", code);

		String time = jedisUtil.getValue(key);
		if (time != null)
			return Long.parseLong(time);

		return System.currentTimeMillis();
	}

	@Override
	public Reader getReader(Object templateSource, String encoding)
		throws IOException
	{
		int expiredTime = 3600;

		String code = String.valueOf(templateSource);
		String key = String.format("ctempalte-%s", code);

		String content = jedisUtil.getValue(key);
		if (content == null)
		{
			content = p2p_contract_templateMapper.getTemplate(code);

			/*jedisUtil.setValue(key, content, expiredTime);
			jedisUtil.setValue(
				key + "-time", String.valueOf(System.currentTimeMillis()),
				expiredTime);*/
		}

		if (content == null)
			content = "";

		return new StringReader(content);
	}

	@Override
	public void closeTemplateSource(Object templateSource)
		throws IOException
	{ }

	@Override
	public String apply(String code, Model model)
	{
		StringWriter writer = new StringWriter();

		try
		{
			Template template = configuration.getTemplate(code);

			TextMask.install(model);

			template.process(model.asMap(), writer);
		} catch(Exception e)
		{
			logger.error("apply", e);
		}

		return writer.toString();
	}

	@Override
	public String applyProductContract(
		String productNo, String tenderFlowNo, String custNo, String code)
	{
		BindingAwareModelMap model = new BindingAwareModelMap();

		// = "normal-product";

		P2p_loan_apply apply = null;
		P2p_loan_product_aid product = null;
		P2p_loan_product_aid tran_product = null;
		P2p_tender_record tender = null;

		List<P2p_creditor_pack> packs = null;
		List<Map<String, Object>> profits = null;

		if (StringUtils.isNotBlank(tenderFlowNo))
		{
			if (StringUtils.isBlank(code))
			{
				String content =
					p2p_contract_templateMapper.getContent(tenderFlowNo);
				if (content != null)
					return content;
			}

			tender = p2p_tender_recordMapper.selectByPrimaryKey(tenderFlowNo);

			custNo = tender.getPtrCustno();
			profits = p2p_tender_profitMapper
				.paymentPlanByTenderFlowNo(tenderFlowNo);
		}

		P2p_user_info userInfo =
			custNo == null?
				null: p2p_user_infoMapper.getUserInfo(custNo);

		if (tender != null)
		{//投资的项目与提供的项目不匹配
			if (!tender.getPtrProductno().equals(productNo))
				productNo = tender.getPtrProductno();
		}

		if (StringUtils.isBlank(productNo) && tender != null)
			productNo = tender.getPtrProductno();
			
		if (StringUtils.isNotBlank(productNo))
		{
			product = 
				p2p_loan_product_aidMapper.queryByProductNo(productNo);

			apply = p2p_loan_applyMapper.searchByPorductNo(productNo);

			packs = p2p_creditor_packMapper.selectByProductNo(
				new MapBuilder<String, Object>()
					.append("productNo", productNo)
					.toMap()
			);
		}

		if (product != null &&
			StringUtils.isNoneBlank(product.getPlpAssignProductNo()))
		{
			if (StringUtils.isBlank(code))
			{
				tran_product = 
					p2p_loan_product_aidMapper.queryByProductNo(
						product.getPlpAssignProductNo());
			}

			List<P2p_creditor_pack> tran_packs = 
				p2p_creditor_packMapper.selectByProductNo(
						new MapBuilder<String, Object>()
							.append("productNo", product.getPlpAssignProductNo())
							.toMap());

			model.addAttribute("tran_packs", tran_packs);
		}

		if (product.getPpInvestmentType() == Const.IFTHESTANDARD &&
			CollectionUtils.isEmpty(profits))
		{
			profits = 
				p2p_tender_profitMapper.paymentPlanByTenderFlowNo2(
					new MapBuilder<String, Object>()
						.append("tenderFlowNo", product.getPlpAssignTenderNo())
						.append("profitStatus", RepaymentBillStatus.TRANS.getIndex())
						.toMap());
		}

		model.addAttribute("apply", apply);
		model.addAttribute("product", product);
		model.addAttribute("tran_product", tran_product);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("tender", tender);
		model.addAttribute("packs", packs);
		model.addAttribute("profits", profits);

		if (code != null)
		{
			
		} else
		if (product.getPpInvestmentType().intValue() == Const.DIRECTBIDDING ||
			product.getPpInvestmentType().intValue() == Const.LIMITEDDAYS)
		{
			code = "direct-product";
		} else
		if (product.getPpInvestmentType().intValue() == Const.IFTHESTANDARD)
		{
			code = "ifthestandard-product";
		} else
		if (product.getPpInvestmentType().intValue() == Const.ASSETSPACK)
		{
			code = "creditorpack-product";
		} else
		{
			code = "normal-product";
		}

		model.addAttribute("code", code);

		String content = apply(code, model);

		return content;
	}

	@Override
	public byte[] convertPdf(String html)
	{
		try
		{
			return HtmlToPdfUtil.createPdf(html);
		} catch(Exception e)
		{
			logger.error("convertPdf", e);
		}
		
		return new byte[] { };
	}


}
