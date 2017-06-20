package com.baibao.web.p2p.service;

import org.springframework.ui.Model;

import freemarker.cache.TemplateLoader;

public interface ContractService
	extends TemplateLoader
{
	/**
	 * 根据模板code和数据生成结果
	 * 
	 * @param code 模板code
	 * @param model 数据模型
	 * 
	 * @return 生成结果
	 */
	public String apply(String code, Model model);

	/**
	 * 根据产品no和出借人no生成合同文本
	 * 
	 * @param productNo 产品no
	 * @param custNo 出借人no
	 * 
	 * @return 合同文本
	 */
	public String applyProductContract(
		String productNo, String tenderFlowNo,
		String custNo, String code);

	/**
	 * 将html文本转换成pdf文档
	 * 
	 * @param html 文本
	 * @return pdf文档
	 */
	public byte[] convertPdf(String html);
}
