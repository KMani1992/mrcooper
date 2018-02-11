package com.mrcooper.gitrepostore.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mrcooper.gitrepostore.response.GRPDetFetchResponseDTO;

@Component
public class GRPResponseBuilder {

	private final RestTemplate restRespParser;

	@Value("${grp.det.fetch.url.template}")
	private String GIT_REPO_DET_FETCH_END_POINT_TEMPLATE;

	private String gitRepoFetchEndPoint;

	public GRPResponseBuilder() {
		restRespParser = new RestTemplate();
	}

	public List<GRPDetFetchResponseDTO> getGitrepoDet(String userName) {

		setGitRepoFetchEndPoint(String.format(GIT_REPO_DET_FETCH_END_POINT_TEMPLATE, userName));

		return fetchRepoDet(userName);
	}

	private List<GRPDetFetchResponseDTO> fetchRepoDet(String userName) {

		ResponseEntity<List<GRPDetFetchResponseDTO>> grpResponse = restRespParser.exchange(getGitRepoFetchEndPoint(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<GRPDetFetchResponseDTO>>() {
				});

		return grpResponse.getBody();
	}

	/**
	 * @return the gitRepoFetchEndPoint
	 */
	public String getGitRepoFetchEndPoint() {
		return gitRepoFetchEndPoint;
	}

	/**
	 * @param gitRepoFetchEndPoint
	 *            the gitRepoFetchEndPoint to set
	 */
	public void setGitRepoFetchEndPoint(String gitRepoFetchEndPoint) {
		this.gitRepoFetchEndPoint = gitRepoFetchEndPoint;
	}

}
