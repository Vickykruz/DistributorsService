package com.stackroute.distributors.service;

import com.stackroute.distributors.exceptions.DistributorsAlreadyExistsException;
import com.stackroute.distributors.exceptions.DistributorsNotFoundException;
import com.stackroute.distributors.model.Distributors;

public interface DistributorsService {

			Distributors registerDistributors(Distributors distributors)throws DistributorsAlreadyExistsException ;

		   boolean deleteDistributors(String distributorsId) throws DistributorsNotFoundException;

		   Distributors updateDistributors(String distributorsId, Distributors distributors) throws DistributorsNotFoundException; 
			
		

		   Distributors getDistributorsByDistributorsId(String distributorsId) throws DistributorsNotFoundException;

	}


