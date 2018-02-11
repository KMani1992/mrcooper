package com.mrcooper.gitrepostore.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mrcooper.gitrepostore.model.GRPKey;
import com.mrcooper.gitrepostore.model.GRPUserDetail;
import com.mrcooper.gitrepostore.model.GRPUserRepoDetail;
import com.mrcooper.gitrepostore.response.GRPDetFetchResponseDTO;

@Component
public class GRPReponseAssembler {

	public List<GRPUserRepoDetail> assembleUserRpoDet(GRPUserDetail grpUserDet, List<GRPDetFetchResponseDTO> grpResDetList) {

		List<GRPUserRepoDetail> userRpoDetList = new ArrayList<>();

		GRPUserRepoDetail grpUserRepoDet;
		GRPKey grpKey;

		for (GRPDetFetchResponseDTO grpResDet : grpResDetList) {
			grpUserRepoDet = new GRPUserRepoDetail();

			grpKey = new GRPKey();
			grpKey.setGitUserName(grpUserDet.getGitUserName());
			grpKey.setGitRepoId(grpResDet.getId());

			grpUserRepoDet.setGrpKey(grpKey);
			grpUserRepoDet.setGrpUserDetail(grpUserDet);
			grpUserRepoDet.setRepoName(grpResDet.getName());
			grpUserRepoDet.setFull_name(grpResDet.getFull_name());
			grpUserRepoDet.setGit_url(grpResDet.getGit_url());
			grpUserRepoDet.setCreated_at(grpResDet.getCreated_at());
			grpUserRepoDet.setPushed_at(grpResDet.getPushed_at());
			grpUserRepoDet.setUpdated_at(grpResDet.getUpdated_at());

			userRpoDetList.add(grpUserRepoDet);
		}

		return userRpoDetList;

	}
}
