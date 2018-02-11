package com.mrcooper.gitrepostore.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrcooper.gitrepostore.model.GRPUserDetail;

@Repository
public interface GRPUserDAOInterface extends CrudRepository<GRPUserDetail, String> {

}
