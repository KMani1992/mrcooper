package com.mrcooper.gitrepostore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GRPUserDetail {

	@Id
	private String gitUserName;

	public GRPUserDetail(){
		
	}
	
	public GRPUserDetail(String gitUserName) {
		super();
		this.gitUserName = gitUserName;
	}

	/**
	 * @return the gitUserName
	 */
	public String getGitUserName() {
		return gitUserName;
	}

	/**
	 * @param gitUserName
	 *            the gitUserName to set
	 */
	public void setGitUserName(String gitUserName) {
		this.gitUserName = gitUserName;
	}

}
