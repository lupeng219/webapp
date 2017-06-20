package com.baibao.web.p2p.ebaoquan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.mapu.themis.api.request.cer.CertificateLinkGetRequest;
import org.mapu.themis.api.request.contract.ContractFileDownloadUrlRequest;
import org.mapu.themis.api.request.contract.ContractFilePreservationCreateRequest;
import org.mapu.themis.api.request.contract.ContractFileViewUrlRequest;
import org.mapu.themis.api.request.contract.ContractStatusGetRequest;
import org.mapu.themis.api.request.preservation.PreservationGetRequest;
import org.mapu.themis.api.response.cer.CertificateLinkGetResponse;
import org.mapu.themis.api.response.contract.ContractFileDownloadUrlResponse;
import org.mapu.themis.api.response.contract.ContractFileViewUrlResponse;
import org.mapu.themis.api.response.contract.ContractStatusGetResponse;
import org.mapu.themis.api.response.preservation.PreservationCreateResponse;
import org.mapu.themis.api.response.preservation.PreservationGetResponse;
import org.springframework.stereotype.Component;

import rop.thirdparty.com.alibaba.fastjson.JSON;

import com.baibao.web.p2p.comm.Const;

@Component
public class EbaoquanUtils extends ThemisClientInit {
	
	/**
	 * 上传文件的合同保全
	 * @param builder
	 * @return
	 */
	public Map<String, Object> ContractFilePreservationSample(ContractFilePreservationCreateRequest.Builder builder){
		Map<String, Object> result = new HashMap<String, Object>();
		PreservationCreateResponse response = getClient().createPreservation(builder.build());
		if(response.isSuccess()){
			result.put(Const.retCode, true);
			result.put("preservationId", response.getPreservationId());
			result.put("docHash", response.getDocHash());
			result.put("preservationTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(response.getPreservationTime())));
		}else{
			result.put(Const.retCode, false);
		}
		return result;
	}
	
	/**
	 * 获取合同保全文件下载地址
	 * @param preservationId
	 * @return
	 */
	public Map<String, Object> ContractFileDownloadUrlSample(Long preservationId){
		Map<String, Object> result = new HashMap<String, Object>();
		ContractFileDownloadUrlRequest request = new ContractFileDownloadUrlRequest();
		request.setPreservationId(preservationId);
		ContractFileDownloadUrlResponse response = getClient().getContactFileDownloadUrl(request);
		if(response.isSuccess()){
			result.put(Const.retCode, true);
			result.put("downUrl", response.getDownUrl());
		}else{
			result.put(Const.retCode, false);
		}
		return result;
	}
	
	/**
	 *　查询保全
	 * @param preservationId
	 * @return
	 */
	public Map<String, Object> PreservationGetSample(Long preservationId){
		Map<String, Object> result = new HashMap<String, Object>();
		PreservationGetRequest request = new PreservationGetRequest();
		request.setPreservationId(preservationId);
		PreservationGetResponse response = getClient().getPreservation(request);
		if(response.isSuccess()){
			result.put(Const.retCode, true);
			result.put("preservationId", response.getPreservationId());
			result.put("docHash", response.getDocHash());
			result.put("preservationTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(response.getPreservationTime())));
		}else{
			result.put(Const.retCode, false);
		}
		return result;
	}
	
	/**
	 * 保全证书
	 * @param preservationId
	 * @return
	 */
	public Map<String, Object> CertificateLinkGetSample(Long preservationId){
		Map<String, Object> result = new HashMap<String, Object>();
		CertificateLinkGetRequest request = new CertificateLinkGetRequest();
		request.setPreservationId(preservationId);
		CertificateLinkGetResponse response = getClient().getCertificateLink(request);
		if(response.isSuccess()){
			result.put(Const.retCode, true);
			result.put("link", response.getLink());
			result.put("linkExpireTime", response.getLinkExpireTime());
		}else{
			result.put(Const.retCode, false);
		}
		return result;
	}
	
	/**
	 * 获取合同查询页URL
	 * @param preservationId
	 * @return
	 */
	public Map<String, Object> ContractFileViewUrlSample(Long preservationId){
		Map<String, Object> result = new HashMap<String, Object>();
		ContractFileViewUrlRequest request = new ContractFileViewUrlRequest();
		request.setPreservationId(preservationId);
		ContractFileViewUrlResponse response = getClient().getContactFileViewUrl(request);
		if(response.isSuccess()){
			result.put(Const.retCode, true);
			result.put("viewUrl", response.getViewUrl());
		}else{
			result.put(Const.retCode, false);
		}
		return result;
	}
	
	/**
	 * 用户确认状态
	 * @param preservationId
	 * @return
	 */
	public Map<String, Object> ContractStatusGetSample(Long preservationId){
		Map<String, Object> result = new HashMap<String, Object>();
		ContractStatusGetRequest request = new ContractStatusGetRequest();
		request.setPreservationId(20507L);
		ContractStatusGetResponse response = getClient().getContactStatus(request);
		if(response.isSuccess()){
			result.put(Const.retCode, true);
			System.out.println(JSON.toJSONString(response));
		}else{
			result.put(Const.retCode, false);
		}
		return result;
	}
	
	public static void main(String[] args) {
		/*ContractFileDownloadUrlSample(38599L);*/
		/*PreservationGetSample(38599L);*/
		/*CertificateLinkGetSample(38599L);*/
		/*ContractFileViewUrlSample(38599L);*/
		/*ContractStatusGetSample(38599L);*/
	}
	
}
