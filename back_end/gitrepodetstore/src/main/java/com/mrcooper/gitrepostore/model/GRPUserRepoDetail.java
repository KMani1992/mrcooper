package com.mrcooper.gitrepostore.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GRPUserRepoDetail {

	/**
	 * This is because difference users can have same repository names
	 */
	@EmbeddedId
	private GRPKey grpKey;

	@ManyToOne
	private GRPUserDetail grpUserDetail;

	// repo name
	private String repoName;

	// repo full anme (ex: user name/repo name)
	private String full_name;

	private Date created_at;
	private Date updated_at;
	private Date pushed_at;

	// git clone url
	private String git_url;

	public GRPUserRepoDetail(){
		
	}
	
	/**
	 * @return the grpKey
	 */
	public GRPKey getGrpKey() {
		return grpKey;
	}

	/**
	 * @param grpKey
	 *            the grpKey to set
	 */
	public void setGrpKey(GRPKey grpKey) {
		this.grpKey = grpKey;
	}

	/**
	 * @return the repoName
	 */
	public String getRepoName() {
		return repoName;
	}

	/**
	 * @param repoName
	 *            the repoName to set
	 */
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}

	/**
	 * @param full_name
	 *            the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at
	 *            the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the updated_at
	 */
	public Date getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at
	 *            the updated_at to set
	 */
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	/**
	 * @return the pushed_at
	 */
	public Date getPushed_at() {
		return pushed_at;
	}

	/**
	 * @param pushed_at
	 *            the pushed_at to set
	 */
	public void setPushed_at(Date pushed_at) {
		this.pushed_at = pushed_at;
	}

	/**
	 * @return the git_url
	 */
	public String getGit_url() {
		return git_url;
	}

	/**
	 * @param git_url
	 *            the git_url to set
	 */
	public void setGit_url(String git_url) {
		this.git_url = git_url;
	}

	/**
	 * @return the grpUserDetail
	 */
	public GRPUserDetail getGrpUserDetail() {
		return grpUserDetail;
	}

	/**
	 * @param grpUserDetail
	 *            the grpUserDetail to set
	 */
	public void setGrpUserDetail(GRPUserDetail grpUserDetail) {
		this.grpUserDetail = grpUserDetail;
	}

}
