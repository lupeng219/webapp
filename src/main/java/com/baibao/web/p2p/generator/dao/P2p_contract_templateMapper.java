package com.baibao.web.p2p.generator.dao;

public interface P2p_contract_templateMapper
{
	public String getTemplate(String code);
	
	public long countTemplate(String code);

	public String getContent(String tenderflowNo);
	
	public void saveContent(
		String productNo, String tenderFlowNo, String custNo);
}
