package com.baibao.web.p2p.repository;

import com.baibao.web.p2p.generator.bean.P2p_cust_logon;

public interface CustLogonRepository {

	public int saveLogon(P2p_cust_logon cusLogon) throws RuntimeException;
	
	public P2p_cust_logon getCustLogonByCustNo(String custNo) throws Exception;
	
	public int updateLogonByCustNo(P2p_cust_logon cusLogon) throws RuntimeException;
}
