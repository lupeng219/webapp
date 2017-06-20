package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.ActiveConst;
import com.baibao.web.p2p.comm.ActiveId;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.comm.UtilTools;
import com.baibao.web.p2p.controller.eventBus.events.FriendsInvestmentEvent;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentActivationEvent;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentEvent;
import com.baibao.web.p2p.controller.eventBus.events.InvitatRegistEvent;
import com.baibao.web.p2p.controller.eventBus.events.RegisterEvent;
import com.baibao.web.p2p.controller.eventBus.events.SendRedEnvelopeEvent;
import com.baibao.web.p2p.generator.bean.P2p_activity_elements;
import com.baibao.web.p2p.generator.bean.P2p_activity_param;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.P2p_users_lotteryDraw;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;
import com.baibao.web.p2p.generator.bean.p2p_sysMsg;
import com.baibao.web.p2p.generator.dataDIC.BigTurntablePrizesType;
import com.baibao.web.p2p.generator.dataDIC.BooleanType;
import com.baibao.web.p2p.generator.dataDIC.MsgType;
import com.baibao.web.p2p.generator.dataDIC.PrizeType;
import com.baibao.web.p2p.generator.dataDIC.RedEnvelopeType;
import com.baibao.web.p2p.repository.ActiveRepository;
import com.baibao.web.p2p.repository.MsgRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.UsersLotteryDrawRepository;
import com.baibao.web.p2p.repository.UsersPracticalityRepository;
import com.baibao.web.p2p.repository.UsersRedenvelopeRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.repository.UsersTestimonialRepository;
import com.baibao.web.p2p.repository.WarehouseRepository;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.utils.luckydraw.LotteryUtil;

@Service("activeService")
public class ActiveServiceImpl implements ActiveService {
	private static Logger logger = LoggerFactory.getLogger(ActiveServiceImpl.class);

	@Autowired
	private ActiveRepository activeRepository;
	@Autowired
	private WarehouseRepository warehouseRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private MsgRepository msgrepository;
	@Autowired
	private UsersRedenvelopeRepository usersRedenvelopeRepository;
	@Autowired
	private UsersLotteryDrawRepository usersLotteryDrawRepository;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private UsersPracticalityRepository usersPracticalityRepository;
	@Autowired
	private UsersTestimonialRepository usersTestimonialRepository;
	
	@Override
	public P2p_activity_elements getActiveById(Long activeId) {

		return activeRepository.getActiveById(activeId);
	}

	@Override
	public String getUserByInvitatId(Map<String, Object> map) {
		return activeRepository.getUserByInvitatId(map);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void excutInvitatRegis(InvitatRegistEvent event) throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();
		P2p_user user = usersRepository.findUserByMobile(event
				.getRegistMobile());
		if (user == null)
			throw new BusinessException("根据注册手机号未查询到注册人信息");

		String goodsId = UUID.randomUUID().toString().replaceAll("-", "");
		// 查询邀请人客户号
		String invitatId = event.getInvitatId();
		params.put("invitatId", invitatId);
		invitatId = activeRepository.getUserByInvitatId(params);
		// 插入好友注册赠送表
		params.clear();
		params.put("puwa_whNo", goodsId);
		params.put("puwa_friendCustNo", invitatId);
		activeRepository.addFriendsRegistInvitation(params);
		//baseLog.writer(params.toString(), RegistType.PC.getIndex(), "admin");

		// 查询活动参数配置
		List<P2p_activity_param> paraList = activeRepository
				.getActiveParamById(Long.parseLong(event.getActiveId()));
		// 邀请注册活动参数只有一条数据
		if (paraList == null || paraList.size() == 0)
			throw new BusinessException("未查询到活动的参数配置");

		params.clear();
		params.put("puw_whNo", goodsId);// 商品编号
		params.put("puw_custNo", invitatId);// 邀请人客户号
		params.put("puw_code", event.getPae_goodsType());// 商品种类
		params.put("puw_parvalue", paraList.get(0).getExcitationValue());// 参数值
		params.put("puw_getTime", DateUtils.getDateToString(new Date()));// 获得奖励时间
		params.put("puw_effectTime", event.getEffectTime());// 奖品到期日期
		params.put("puw_activeId", event.getActiveId());// 活动编码
		params.put("puw_state", BooleanType.no.getIndex());// 使用状态
		// 插入仓库表
		warehouseRepository.addPrize(params);
		//baseLog.writer(params.toString(), RegistType.PC.getIndex(), "admin");

		// 发送站内信告知
		params.clear();
		params.put("custNo", invitatId);
		params.put("sysMsgType", MsgType.activereward_msg.getIndex());
		params.put("sysMsgPubTime", DateUtils.getDateToString(new Date()));
		params.put("sysMsgContent", "尊敬的用户，您邀请" + event.getRegistMobile()
				+ "成功注册，获得一张" + paraList.get(0).getExcitationValue() + "元的"
				+ PrizeType.getPrizeType(event.getPae_goodsType()).getDesc()
				+ "，您可以在 <a href=" + "${basePath}/service/active/toMyActive"
				+ ">我的活动</a> 内进行查询。");// 邀请注册活动站内信息提示
		msgrepository.addInnerSiteMsg(params);
	}

	/*@Override
	public List<P2p_user_warehouse> queryWarehouseBycustNo(String custNo,
			String status) {
		
		return warehouseRepository.queryWarehouseBycustNo(custNo, status);
	}*/

	@Override
	public Paging<Map<String, Object>> queryFriendRecordBycustNo(String custNo,int pageNo,int pageSize,String startTime,String endTime,String userMobile) {
		
		Paging<Map<String, Object>> pag = new Paging<Map<String, Object>>(
				pageNo, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		params.put("custNo", custNo);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("userMobile", userMobile);
		pag.setPageList(warehouseRepository.queryFriendRecordBycustNo(params));
		pag.setCountTotal(warehouseRepository
				.getFriendRecordTotalBycustNo(params));
		return pag;
	}

	@Override
	public P2p_activity_elements getActiveByType(String type) {

		return activeRepository.getActiveByType(type);
	}

	@Override
	public Paging<Map<String, Object>> getFriendTenderRecordBycustNo(String custNo,int pageNo,int pageSize,String startTime,String endTime,String userMobile) {
		Paging<Map<String, Object>> pag = new Paging<Map<String, Object>>(
				pageNo, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		params.put("custNo", custNo);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("userMobile", userMobile);
		pag.setPageList(warehouseRepository.getFriendTenderRecordBycustNo(params));
		pag.setCountTotal(warehouseRepository.getFriendTenderRecordTotalBycustNo(params));
		return pag;
	}

	@Override
	public Paging<Map<String, Object>> goodsReward(String custNo, int pageNo,
			int pageSize) {
		Paging<Map<String, Object>> pag = new Paging<Map<String, Object>>(
				pageNo, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		params.put("custNo", custNo);
		pag.setPageList(usersPracticalityRepository.goodsReward(params));
		pag.setCountTotal(usersPracticalityRepository.goodsRewardCount(params));
		return pag;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void publicPortal(RegisterEvent event) throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();
		P2p_activity_elements activity = event.getP2pActivityElements();
		P2p_user user = usersRepository.findUserByMobile(event
				.getRegistMobile());
		if (user == null)
			throw new BusinessException("根据注册手机号未查询到注册人信息");

		String goodsId = UUID.randomUUID().toString().replaceAll("-", "");

		// 查询活动参数配置
		List<P2p_activity_param> paraList = activeRepository
				.getActiveParamById(Long.parseLong(event.getActiveId()));
		// 邀请注册活动参数只有一条数据
		if (paraList == null || paraList.size() == 0)
			throw new BusinessException("未查询到活动的参数配置");

		params.clear();
		params.put("puw_whNo", goodsId);// 商品编号
		params.put("puw_custNo", user.getPuCustNo());// 邀请人客户号
		params.put("puw_code", activity.getPae_goodsType());// 商品种类
		params.put("puw_parvalue", paraList.get(0).getExcitationValue());// 参数值
		params.put("puw_getTime", DateUtils.getDateToString(new Date()));// 获得奖励时间
		params.put("puw_effectTime", event.getEffectTime());// 奖品到期日期
		params.put("puw_activeId", event.getActiveId());// 活动编码
		params.put("puw_state", "0");// 使用状态
		// 插入仓库表
		warehouseRepository.addPrize(params);
		//baseLog.writer(params.toString(), RegistType.PC.getIndex(), "admin");

		// 发送站内信告知
		params.clear();
		params.put("sysMsgID", UUID.randomUUID().toString().replaceAll("-", ""));
		params.put("custNo", user.getPuCustNo());
		params.put("sysMsgType", MsgType.activereward_msg.getIndex());
		params.put("sysMsgPubTime", DateUtils.getDateToString(new Date()));
		params.put("sysMsgContent", "尊敬的用户，您成功注册，获得一张" + paraList.get(0).getExcitationValue() + "元的"
				+ PrizeType.getPrizeType(event.getP2pActivityElements().getPae_goodsType()).getDesc()
				+ "，您可以在 <a href=" + "${basePath}/service/active/toMyActive"
				+ ">我的活动</a> 内进行查询。");
		msgrepository.addInnerSiteMsg(params);
	}

	@Override
	public void excutInvestment(InvestmentEvent event) throws Exception {
		List<P2p_activity_param> paraList = activeRepository
				.getActiveParamById(Long.parseLong(event.getActiveId()));
		String goodsId = UUID.randomUUID().toString().replaceAll("-", "");
		String _tendstatic = "",_amount = "",_tendreward="";
		if (paraList == null || paraList.size() == 0)
			throw new BusinessException("未查询到活动的参数配置");
		for (P2p_activity_param param : paraList) {
			String fromParamValue = param.getFromParamValue();
			String toParamValue = param.getToParamValue();
			if ("0".equals(param.getParamType())) {// 单笔
				_tendstatic = "单笔";
				String tendAmunt = event.getAmount();
				_amount = tendAmunt;
				if (UtilTools.isBetweenDecimal(new BigDecimal(fromParamValue),
						new BigDecimal(toParamValue),
						new BigDecimal(tendAmunt), true)) {
					// 插入仓库表
					_tendreward = param.getExcitationValue();
					this.insertWarehouse(goodsId, event.getCustNo(),
							event.getGoodsType(), param.getExcitationValue(),
							event.getEffectTime(), event.getActiveId());
					break;
				}
			} else if ("1".equals(param.getParamType())) {// 累计
				_tendstatic = "单笔";
				// 查询活动时间内用户的累计投资额
				Map<String, Object> p = new HashMap<String, Object>();
				p.put("custNo", event.getCustNo());
				p.put("starTime", event.getActiveStarTime());
				p.put("endTime", event.getActiveEndTime());
				Map<String, Object> map = activeRepository
						.statisticalTendAmountPeriodOfTime(p);
				BigDecimal amount = (BigDecimal) map.get("amount");
				_amount = amount.toString();
				if (UtilTools.isBetweenDecimal(new BigDecimal(fromParamValue),
						new BigDecimal(toParamValue), amount, true)) {
					// 插入仓库表
					_tendreward = param.getExcitationValue();
					this.insertWarehouse(goodsId, event.getCustNo(),
							event.getGoodsType(), param.getExcitationValue(),
							event.getEffectTime(), event.getActiveId());
					break;
				}
			}

		}
		// 站内信
		String msgId = UUID.randomUUID().toString().replaceAll("-", "");
		this.sendInnerSiteMsg(msgId, event.getCustNo(), "尊敬的用户，您成功"+_tendstatic+"投资"+_amount+"元，"+"获得投资奖励："+_tendreward);
		//baseLog.writer(params.toString(), RegistType.PC.getIndex(), "admin");

	}

	/**
	 * 插入仓库表
	 * 
	 * @param id
	 *            商品编号
	 * @param custNo
	 *            客户号
	 * @param goodsType
	 *            商品类型
	 * @param excitationValue
	 *            参数值
	 * @param effectTime
	 *            过期时间
	 * @param activeId
	 *            活动编码
	 * @throws Exception
	 */
	public synchronized void insertWarehouse(String id, String custNo,
			String goodsType, String excitationValue, String effectTime,
			String activeId) throws Exception {
		P2p_user_warehouse warehouse = warehouseRepository.inspectWarehouse(custNo, activeId, goodsType);
		if (warehouse != null)
			return;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("puw_whNo", id);// 商品编号
		params.put("puw_custNo", custNo);// 投资人客户号
		params.put("puw_code", goodsType);// 商品种类
		params.put("puw_parvalue", excitationValue);// 参数值
		params.put("puw_getTime", DateUtils.getDateToString(new Date()));// 获得奖励时间
		params.put("puw_effectTime", effectTime);// 奖品到期日期
		params.put("puw_activeId", activeId);// 活动编码
		params.put("puw_state", BooleanType.no.getIndex());// 使用状态
		warehouseRepository.addPrize(params);
	}

	/**
	 * 发送站内信
	 * 
	 * @param custNo
	 *            客户号
	 * @param context
	 *            站内信内容
	 * @throws Exception
	 */
	public synchronized void sendInnerSiteMsg(String msgId, String custNo,
			String context) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		p2p_sysMsg msg = msgrepository.selectById(msgId);
		if (msg != null)
			return;
		params.put("sysMsgID", msgId);
		params.put("custNo", custNo);
		params.put("sysMsgType", MsgType.activereward_msg.getIndex());
		params.put("sysMsgPubTime", DateUtils.getDateToString(new Date()));
		params.put("sysMsgContent", context);
		msgrepository.addInnerSiteMsg(params);

	}
	
	@Override
	public void excutFriendsInvestment(FriendsInvestmentEvent event) throws Exception{
		String tendAmunt = event.getInvestAmount();//投资金额
		if(StringUtil.isEmpty(tendAmunt)){
			throw new BusinessException("投资金额为空!");	
		}
		
		String puCustNo = event.getPuCustNo();//投资人客户号
		if(StringUtil.isEmpty(puCustNo)){
			throw new BusinessException("投资人客户号为空!");	
		}
		
		String recCustNo = activeRepository.getUserFriends(puCustNo);
		if(StringUtil.isEmpty(recCustNo)){
			throw new BusinessException("推荐人客户号为空!");	
		};
		
		String tenderFlowNo = event.getTenderFlowNo();
		if(StringUtil.isEmpty(tenderFlowNo)){
			throw new BusinessException("投资流水号为空!");	
		}else{
			Map<String, Object> map = null;
			map = activeRepository.getProductByTenderFlowNo(tenderFlowNo);
			//map.get("pp_loanRepayment");还款方式
			event.setProjectNo(map.get("ptr_productNo").toString());
			event.setProjectTerm(map.get("pp_loanTerm").toString());
		};
		
		//查询活动参数
		List<P2p_activity_param> paraList = activeRepository.getActiveParamById(Long.parseLong(event.getActiveId()));
		//生成活动编号
		String goodsId = UUID.randomUUID().toString().replaceAll("-","");
		if(paraList == null || paraList.size()==0)
			throw new BusinessException("未查询到活动的参数配置");	
		for (P2p_activity_param param : paraList) {
			String fromParamValue = param.getFromParamValue();
			String toParamValue = param.getToParamValue();
			if("0".equals(param.getParamType())){//单笔
				if(UtilTools.isBetweenDecimal(new BigDecimal(fromParamValue), new BigDecimal(toParamValue), new BigDecimal(tendAmunt), true)){
					//插入仓库表,客户号是好友的客户号
					//表示好友应得的收益
					this.insertWarehouse(goodsId, recCustNo, event.getActivity().getPae_goodsType(), param.getExcitationValue(), event.getActivity().getPae_effectTime(), event.getActiveId());
					//投资人客户号
					this.addFriendTender(event.getPuCustNo(), event.getTenderFlowNo(), event.getProjectNo(), goodsId, event.getProjectTerm());
					break;
				}
			}else if("1".equals(param.getParamType())){//累计
				//查询活动时间内用户的累计投资额
				//查询投资用户活动时间内的累计投资，表示的是投资用户客户号
				Map<String, Object> p = new HashMap<String, Object>();
				p.put("custNo", event.getPuCustNo());
				p.put("starTime", event.getActivity().getPae_starTime());
				p.put("endTime", event.getActivity().getPae_endTime());
				//查询投资用户活动时间内的累计投资，表示的是投资用户客户号
				Map<String, Object> map = activeRepository.statisticalTendAmountPeriodOfTime(p);
				BigDecimal amount = (BigDecimal) map.get("amount");
				if(UtilTools.isBetweenDecimal(new BigDecimal(fromParamValue), new BigDecimal(toParamValue), amount, true)){
					//插入仓库表,客户号是邀请的好友的
					//表示好友应得的收益
					this.insertWarehouse(goodsId, recCustNo, event.getActivity().getPae_goodsType(), param.getExcitationValue(), event.getActivity().getPae_effectTime(), event.getActiveId());
					//投资人客户号
					this.addFriendTender(event.getPuCustNo(), event.getTenderFlowNo(), event.getProjectNo(), goodsId, event.getProjectTerm());
					break;
				}
			}
			
		}
		//站内信,好友的站内信，好友的客户号
		String msgId = UUID.randomUUID().toString().replaceAll("-", "");
		this.sendInnerSiteMsg(msgId, recCustNo, "尊敬的用户，您的好友成功投资");
		//baseLog.writer(params.toString(), RegistType.PC.getIndex(), "admin");
	}
		
	/**
	 * 好友投资活动仓库记录
	 * @param custNo
	 * @param tenderFlowNo
	 * @param projectNo
	 * @param whNo
	 * @param projectTerm
	 * @return
	 */
	public int addFriendTender(String custNo,String tenderFlowNo,String projectNo,
			String whNo,String projectTerm){
		int result = warehouseRepository.inspectFriendTender(custNo,tenderFlowNo,projectNo);
		if(result != 1)
			return result;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("puwa_whNo", whNo);//商品编号
		params.put("puwa_friendCustNo", custNo);//投资人客户号
		params.put("puwa_projectNo", projectNo);//商品种类
		params.put("puwa_tenderFlowNo", tenderFlowNo);//参数值
		params.put("puwa_project_term", projectTerm);//获得奖励时间
		result = warehouseRepository.addFriendTender(params); 
		return result;
	}

	@Override
	public List<Map<String, Object>> showActiveList(Integer count) {
		return activeRepository.showActiveList(count);
	}

	@Override
	public BigDecimal getSumReward(String custNo) {
		
		return activeRepository.getSumReward(custNo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void sendRedEnvelope_520(SendRedEnvelopeEvent event) throws Exception {
		Date date = new Date();
		
		boolean flag = warehouseRepository.queryRedEnvelope_520(event.getActiveId(),event.getCustNo());
		if(flag)
			return;
		
		//1元红包 1个
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		params.put("pur_custNo", event.getCustNo());//用户客户号
		params.put("pur_money", "1");//金额
		params.put("pur_getTime", DateUtils.getDateToString(date));//红包获得时间
		params.put("pur_effectTime", DateUtils.FatalismOperation(date, 30));//红包有效期限
		params.put("pur_activeId", event.getActiveId());//活动编号
		params.put("pur_status", "0");//红包状态
		params.put("pur_rule", new BigDecimal(100));//红包使用规则
		warehouseRepository.sendRedEnvelope_520(params);
		
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		params.put("pur_money", "10");
		params.put("pur_rule", new BigDecimal(1000));//红包使用规则
		warehouseRepository.sendRedEnvelope_520(params);
		
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		params.put("pur_money", "20");
		params.put("pur_rule", new BigDecimal(5000));//红包使用规则
		warehouseRepository.sendRedEnvelope_520(params);
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		warehouseRepository.sendRedEnvelope_520(params);
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		warehouseRepository.sendRedEnvelope_520(params);
		
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		params.put("pur_money", "30");
		params.put("pur_rule", new BigDecimal(10000));//红包使用规则
		warehouseRepository.sendRedEnvelope_520(params);
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		warehouseRepository.sendRedEnvelope_520(params);
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		warehouseRepository.sendRedEnvelope_520(params);
		
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		params.put("pur_money", "60");
		params.put("pur_rule", new BigDecimal(50000));//红包使用规则
		warehouseRepository.sendRedEnvelope_520(params);
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		warehouseRepository.sendRedEnvelope_520(params);
		
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		params.put("pur_money", "120");
		params.put("pur_rule", new BigDecimal(100000));//红包使用规则
		warehouseRepository.sendRedEnvelope_520(params);
		params.put("pur_redenvelopeNo", UtilTools.getUUId());
		warehouseRepository.sendRedEnvelope_520(params);
		
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void redEnvelopeActivation_520(InvestmentActivationEvent event) throws Exception {
		BigDecimal amount = event.getAmount();
		P2p_users_redenvelope redenvelope =  warehouseRepository.queryRedEnvelopeActivation_520(event.getActiveId(),event.getCustNo(),amount);
		if(redenvelope != null){
			redenvelope.setPurStatus(RedEnvelopeType.usedStatus.getIndex());
			warehouseRepository.updateRedenvelopeUsed(redenvelope);
			warehouseRepository.insertRedenvelope_friendTender(redenvelope.getPurRedenvelopeno(),event.getCustNo(),event.getProjectNo(),event.getTenderFlowNo());
		}
	}

	@Override
	public List<Map<String, Object>> queryRedenvelopeBycustNo(String custNo,
			String status) throws BusinessException {
		return usersRedenvelopeRepository.queryRedenvelopeBycustNo(custNo, status);
	}

	@Override
	public int queryLotteryDrawCount(String custNo) throws BusinessException {
		return usersLotteryDrawRepository.queryLotteryDrawCount(custNo);
	}

	@Override
	public List<Map<String, Object>> querySpoilList() throws BusinessException {
		return usersLotteryDrawRepository.queryPracticalityAndRedenvelopeList(ActiveId.ACTIVEID_DZP);
	}

	@Override
	public Map<String, Object> lotteryDraw(String custNo) throws BusinessException {
		Map<String, Object> result = new HashMap<String, Object>();
		//查询用户次数list
		List<P2p_users_lotteryDraw> lotteryDrawList = usersLotteryDrawRepository.queryLotteryDrawList(custNo);
		if(lotteryDrawList!=null && lotteryDrawList.size()>0){
			//用户抽奖机会
			P2p_users_lotteryDraw usersLotteryDraw = lotteryDrawList.get(0);
			//查询用户投资成功总sum
			BigDecimal bidAmount = tenderRepository.queryTenderSum(custNo);
			bidAmount = bidAmount ==null ?new BigDecimal(0):bidAmount;
			int intervalType = 0;
			//根据投资sum进入不同的奖品区间
			if(bidAmount.compareTo(new BigDecimal(5000)) <0){
			    intervalType = ActiveConst.oneInterval;
			}else if(bidAmount.compareTo(new BigDecimal(5000))>=0 && bidAmount.compareTo(new BigDecimal(30000)) <0){
				intervalType = ActiveConst.twoInterval;
			}else if(bidAmount.compareTo(new BigDecimal(30000))>=0 && bidAmount.compareTo(new BigDecimal(100000)) <0){
				intervalType = ActiveConst.threeInterval;
			}else if(bidAmount.compareTo(new BigDecimal(100000))>=0 && bidAmount.compareTo(new BigDecimal(500000)) <0){
				intervalType = ActiveConst.fourInterval;
			}else if(bidAmount.compareTo(new BigDecimal(500000))>=0){
				intervalType = ActiveConst.fiveInterval;
			}
			List<BigTurntablePrizesType> bigTurntablePrizesTypeList = BigTurntablePrizesType.getBigTurntablePrizesTypeList(intervalType);
			if(bigTurntablePrizesTypeList!=null && bigTurntablePrizesTypeList.size()>0){
				int prizeCount =lotteryDraw(bigTurntablePrizesTypeList);
				BigTurntablePrizesType bigTurntablePrizesType = bigTurntablePrizesTypeList.get(prizeCount);
				if(bigTurntablePrizesType.getPrizesType() == ActiveConst.thankYouForParticipating){//0：谢谢参与
					//修改用户抽奖机会状态
					int lotteryDrawCount = usersLotteryDrawRepository.updateLotteryDraw(usersLotteryDraw.getPulLotterydrawno());
					if(lotteryDrawCount>0){
						result.put("prizeNo", bigTurntablePrizesType.getPrizesNo());
						result.put("prizeName",  bigTurntablePrizesType.getPrizesName());
						return result;
					}
				}else if(bigTurntablePrizesType.getPrizesType() == ActiveConst.imaHitotabiNo ){//3：再来一次
					result.put("prizeNo", bigTurntablePrizesType.getPrizesNo());
					result.put("prizeName", bigTurntablePrizesType.getPrizesName());
					return result;
				}else if(bigTurntablePrizesType.getPrizesType() == ActiveConst.redPrize ){//2：红包奖品
					//更新用户抽奖机会状态,红包进行存储
					int redenvelopeCount = saveRedenvelope(bigTurntablePrizesType, usersLotteryDraw);
					if(redenvelopeCount>0){
						result.put("prizeNo", bigTurntablePrizesType.getPrizesNo());
						result.put("prizeName", bigTurntablePrizesType.getPrizesName());
						return result;
					}
				}else if(bigTurntablePrizesType.getPrizesType() == ActiveConst.theRealPrize ){//1:实物奖品
					if(intervalType == ActiveConst.oneInterval){
						int testimonial = getTestimonial(bigTurntablePrizesType);
						if(testimonial >0){
							int practicalityCount =savePracticality(bigTurntablePrizesType, usersLotteryDraw);
							if(practicalityCount>0){
								result.put("prizeNo", bigTurntablePrizesType.getPrizesNo());
								result.put("prizeName", bigTurntablePrizesType.getPrizesName());
								return result;
							}
						}else{
							//修改用户抽奖机会状态
							usersLotteryDrawRepository.updateLotteryDraw(usersLotteryDraw.getPulLotterydrawno());
							
						}
					}else{
						//更新用户抽奖机会状态,实物进行存储
						int practicalityCount = savePracticality(bigTurntablePrizesType, usersLotteryDraw);
						if(practicalityCount>0){
							result.put("prizeNo", bigTurntablePrizesType.getPrizesNo());
							result.put("prizeName", bigTurntablePrizesType.getPrizesName());
							return result;
						}
					}
				}
			}
		}else{
			result.put("prizeNo", 12);
			result.put("prizeName", "您今天的抽奖次数已用完");
			return result;
		}
		result.put("prizeNo", 8);
		result.put("prizeName", "谢谢参与");
		return result;
	}

	@Override
	public int queryBycustNoAndSourceType(String custNo, String sourceType) throws BusinessException {
		return usersLotteryDrawRepository.queryBycustNoAndSourceType(custNo, sourceType);
	}

	@Override
	public int insertLotteryDraw(Map<String, Object> params) throws BusinessException {
		return usersLotteryDrawRepository.insertLotteryDraw(params);
	}
	
	/**
	 * 返回奖品ID
	 * @param BigTurntablePrizesTypeList
	 * @return
	 */
	public int lotteryDraw(List<BigTurntablePrizesType> BigTurntablePrizesTypeList){
		int orignalIndex = 0;
		List<Double> orignalRates = new ArrayList<Double>(BigTurntablePrizesTypeList.size());
		for (BigTurntablePrizesType bigTurntablePrizesType : BigTurntablePrizesTypeList) {
            double probability = bigTurntablePrizesType.getProbability();
            if (probability < 0) {
                probability = 0;
            }
            orignalRates.add(probability);
        }
		orignalIndex = LotteryUtil.lottery(orignalRates);
		return orignalIndex;
	}
	
	/**
	 * 给用户插入红包
	 * @param bigTurntablePrizesType
	 * @param custNo
	 * @param usersLotteryDraw
	 * @return
	 */
	public synchronized int saveRedenvelope(BigTurntablePrizesType bigTurntablePrizesType,P2p_users_lotteryDraw usersLotteryDraw){
		try {
			//修改用户抽奖机会状态
			int lotteryDrawCount = usersLotteryDrawRepository.updateLotteryDraw(usersLotteryDraw.getPulLotterydrawno());
			if(lotteryDrawCount>0){
				//查询是否已经使用抽奖机会得到红包
				int lotterydrawCount = usersRedenvelopeRepository.getRedenvelopeLotteryDrawNo( usersLotteryDraw.getPulLotterydrawno());
				if(lotterydrawCount==0){
					//插入红包
					Map<String, Object> params = new HashMap<String, Object>();
					Date date = new Date();
					params.put("pur_redenvelopeNo", UtilTools.getUUId());
					params.put("pur_custNo", usersLotteryDraw.getPulCustno());//用户客户号
					params.put("pur_money", bigTurntablePrizesType.getPrizesMoney());//金额
					params.put("pur_getTime", DateUtils.getDateToString(date));//红包获得时间
					params.put("pur_effectTime", DateUtils.FatalismOperation(date, 30));//红包有效期限
					params.put("pur_lotteryDrawNo", usersLotteryDraw.getPulLotterydrawno());
					params.put("pur_activeId", ActiveId.ACTIVEID_DZP);//活动编号
					params.put("pur_status", ActiveConst.notUsed);//红包状态
					params.put("pur_rule", bigTurntablePrizesType.getServiceRegulations());//红包使用规则
					return usersRedenvelopeRepository.saveRedenvelope(params);
				}
			}
		} catch (Exception e) {
			logger.error("saveRedenvelope",e);
		}
		return 0;
	}
	
	public synchronized int savePracticality(BigTurntablePrizesType bigTurntablePrizesType,P2p_users_lotteryDraw usersLotteryDraw){
		try {
			//修改用户抽奖机会状态
			int lotteryDrawCount = usersLotteryDrawRepository.updateLotteryDraw(usersLotteryDraw.getPulLotterydrawno());
			if(lotteryDrawCount>0){
				//查询是否已经使用抽奖机会得到实物
				int practicalityCount = usersPracticalityRepository.getPracticalityLotteryDrawNo( usersLotteryDraw.getPulLotterydrawno());
				int practicality = usersPracticalityRepository.getPracticalityByCustNo(usersLotteryDraw.getPulCustno(), String.valueOf(bigTurntablePrizesType.getPrizesNo()));
				if(practicalityCount==0&&practicality==0){
					//插入实物
					Map<String, Object> params = new HashMap<String, Object>();
					Date date = new Date();
					params.put("pup_practicalityNo", UtilTools.getUUId());//用户实物编号
					params.put("pup_custNo", usersLotteryDraw.getPulCustno());//用户客户号
					params.put("pup_testimonialNo", bigTurntablePrizesType.getPrizesNo());//奖品编号
					params.put("pup_getTime", DateUtils.getDateToString(date));//获得时间
					params.put("pup_lotteryDrawNo",usersLotteryDraw.getPulLotterydrawno());//用户抽奖编号
					params.put("pup_activeId",  ActiveId.ACTIVEID_DZP);//活动编号
					params.put("pup_status",ActiveConst.notUsed);//状态(0：未发放1：已发放)
					return usersPracticalityRepository.savePracticality(params);
				}
			}
		} catch (Exception e) {
			logger.error("savePracticality",e);
		}
		return 0;
	}
	
	/**
	 * 查询奖品数量 
	 * @param bigTurntablePrizesType
	 * @return
	 */
	public synchronized int getTestimonial(BigTurntablePrizesType bigTurntablePrizesType){
		//查询商品数量
		int testimonialCount = usersTestimonialRepository.searchTestimonial(bigTurntablePrizesType.getIntervalType(),bigTurntablePrizesType.getPrizesNo());
		if(testimonialCount>0){
			return usersTestimonialRepository.updateByTestimonialNo(bigTurntablePrizesType.getIntervalType(),bigTurntablePrizesType.getPrizesNo(), testimonialCount-1);
		}
		return 0;
	}
	
}
