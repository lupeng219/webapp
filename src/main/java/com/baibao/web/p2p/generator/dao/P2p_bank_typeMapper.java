package com.baibao.web.p2p.generator.dao;

import java.util.List;

import com.baibao.web.p2p.generator.bean.P2p_bank_type;

public interface P2p_bank_typeMapper
{
	public List<P2p_bank_type> getAll();

	public P2p_bank_type getBankType(String bankCode);

	public List<P2p_bank_type> getPersonalHhortcut();
	public List<P2p_bank_type> getPersonalEbank();
	public List<P2p_bank_type> getEnterpriseNetSilver();
}
