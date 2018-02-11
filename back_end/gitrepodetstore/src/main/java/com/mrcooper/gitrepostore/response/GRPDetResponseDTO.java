package com.mrcooper.gitrepostore.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mrcooper.gitrepostore.model.GRPUserRepoDetail;

/**
 * This class is used to send back the response of store repository details
 * request
 * 
 * @author mani
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GRPDetResponseDTO {

	private int statusCode;
	private String statusMsg;
	private List<GRPUserRepoDetail> grpUsrRepoDetList;

	public GRPDetResponseDTO(int statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}

	public GRPDetResponseDTO(int statusCode, String statusMsg, List<GRPUserRepoDetail> grpUsrRepoDetList) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
		this.grpUsrRepoDetList = grpUsrRepoDetList;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusMsg
	 */
	public String getStatusMsg() {
		return statusMsg;
	}

	/**
	 * @param statusMsg
	 *            the statusMsg to set
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	/**
	 * @return the grpUsrRepoDetList
	 */
	public List<GRPUserRepoDetail> getGrpUsrRepoDetList() {
		return grpUsrRepoDetList;
	}

	/**
	 * @param grpUsrRepoDetList the grpUsrRepoDetList to set
	 */
	public void setGrpUsrRepoDetList(List<GRPUserRepoDetail> grpUsrRepoDetList) {
		this.grpUsrRepoDetList = grpUsrRepoDetList;
	}
	
	
}
