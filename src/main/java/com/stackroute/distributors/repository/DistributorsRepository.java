package com.stackroute.distributors.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.distributors.model.Distributors;



@Repository
public interface DistributorsRepository extends MongoRepository<Distributors, String>  {

}
