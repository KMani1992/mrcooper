package com.mrcooper.gitrepostore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GRPKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "gitUserName", nullable = false)
	private String gitUserName;

	@Column(name = "gitRepoId", nullable = false)
	private String gitRepoId;

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

	/**
	 * @return the gitRepoId
	 */
	public String getGitRepoId() {
		return gitRepoId;
	}

	/**
	 * @param gitRepoId
	 *            the gitRepoId to set
	 */
	public void setGitRepoId(String gitRepoId) {
		this.gitRepoId = gitRepoId;
	}

}
