package com.baibao.web.p2p.service;

import com.baibao.web.p2p.generator.bean.P2p_cust_logon;

public interface CustLogonService {

	public int saveLogon(P2p_cust_logon cusLogon) throws RuntimeException;
	
	public P2p_cust_logon getCustLogonByCustNo(String custNo) throws RuntimeException;
	
	public int updateLogonByCustNo(P2p_cust_logon cusLogon) throws RuntimeException;
	
}
