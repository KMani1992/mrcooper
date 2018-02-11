package com.mrcooper.gitrepostore.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrcooper.gitrepostore.model.GRPUserRepoDetail;

@Repository
public interface GRPUserRepoDAOInterface extends CrudRepository<GRPUserRepoDetail, String> {

}
