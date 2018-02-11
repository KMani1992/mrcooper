package com.mrcooper.gitrepostore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrcooper.gitrepostore.assembler.GRPReponseAssembler;
import com.mrcooper.gitrepostore.builder.GRPResponseBuilder;
import com.mrcooper.gitrepostore.model.GRPUserDetail;
import com.mrcooper.gitrepostore.model.GRPUserRepoDetail;
import com.mrcooper.gitrepostore.repositry.GRPUserDAOInterface;
import com.mrcooper.gitrepostore.repositry.GRPUserRepoDAOInterface;
import com.mrcooper.gitrepostore.response.GRPDetFetchResponseDTO;
import com.mrcooper.gitrepostore.response.GRPDetResponseDTO;

@Service
public class GRPService {

	@Value("${sts.code.success}")
	private int STS_CODE_SUCCESS;

	@Value("${sts.msg.success}")
	private String STS_MSG_SUCCESS;

	@Value("${sts.code.fail}")
	private int STS_CODE_FAIL;

	@Value("${sts.msg.fail}")
	private String STS_MSG_FAIL;
	
	@Value("${sts.msg.notfound}")
	private String STS_MSG_NOT_FOUND;

	private static final String REPO_NOT_FOUND_MSG="404 Not Found"; 
	
	@Autowired
	private GRPUserDAOInterface grpUserDaoInterface;

	@Autowired
	private GRPUserRepoDAOInterface grpUserRepoDaoInterface;

	@Autowired
	private GRPResponseBuilder grpRespBuilder;

	@Autowired
	private GRPReponseAssembler grpRespAssembler;

	@Transactional
	private void saveGrpDet(List<GRPUserRepoDetail> grpUserRepoDetList) {

		for (GRPUserRepoDetail grpUserRepoDet : grpUserRepoDetList) {
			grpUserRepoDaoInterface.save(grpUserRepoDet);
		}
	}

	private GRPUserDetail findAndsaveUserDet(String userName) {

		GRPUserDetail grpUserDet;
		if (grpUserDaoInterface.exists(userName)) {
			grpUserDet = grpUserDaoInterface.findOne(userName);
		} else {
			grpUserDet = new GRPUserDetail(userName);
			grpUserDaoInterface.save(grpUserDet);
		}

		return grpUserDet;
	}

	@Transactional
	public GRPDetResponseDTO getAndStoreGitRepoDet(String userName) {

		List<GRPUserRepoDetail> grpUsrRepoDetList=null;
		
		try {
			List<GRPDetFetchResponseDTO> grpResDetList = grpRespBuilder.getGitrepoDet(userName);

			GRPUserDetail grpUserDet = findAndsaveUserDet(userName);

			grpUsrRepoDetList = grpRespAssembler.assembleUserRpoDet(grpUserDet, grpResDetList);

			saveGrpDet(grpUsrRepoDetList);

		} catch (Exception ex) {

			
			Logger.getLogger(GRPService.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage());
			
			
			return new GRPDetResponseDTO(STS_CODE_FAIL, 
					REPO_NOT_FOUND_MSG.equals(ex.getMessage()) 
					? STS_MSG_NOT_FOUND:STS_MSG_FAIL);
		}

		return new GRPDetResponseDTO(STS_CODE_SUCCESS, STS_MSG_SUCCESS,grpUsrRepoDetList);

	}
	
	
	public GRPDetResponseDTO getAllRepoDet() {
		
		GRPDetResponseDTO grpDetRsp=new GRPDetResponseDTO(STS_CODE_SUCCESS,"All User Repo Details");		
		List<GRPUserRepoDetail> grpUsrRepoDetList=new ArrayList<>();
		grpDetRsp.setGrpUsrRepoDetList(grpUsrRepoDetList);		
		grpUserRepoDaoInterface.findAll().forEach(grpUsrRepoDetList::add);
		
		return grpDetRsp;
	}
}
