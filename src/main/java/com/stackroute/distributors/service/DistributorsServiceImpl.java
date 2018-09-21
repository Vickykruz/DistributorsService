package com.stackroute.distributors.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.distributors.exceptions.DistributorsAlreadyExistsException;
import com.stackroute.distributors.exceptions.DistributorsNotFoundException;
import com.stackroute.distributors.model.Distributors;
import com.stackroute.distributors.repository.DistributorsRepository;

@Service
public class DistributorsServiceImpl implements DistributorsService{
	private DistributorsRepository distributorsRepository;
	   /*
     * Autowiring should be implemented for the TheatreRepository. (Use
     * Constructor-based autowiring) Please note that we should not create any
     * object using the new keyword.
     */
    @Autowired
    public DistributorsServiceImpl(DistributorsRepository distributorsRepository) {
        this.distributorsRepository = distributorsRepository;
    }
    /*
     * This method should be used to register a new theatre.Call the corresponding
     * method of Repository interface.
     */
  
    public Distributors registerDistributors(Distributors distributors) throws DistributorsAlreadyExistsException {
        Distributors dis1 = distributorsRepository.insert(distributors);
        if (dis1 == null) {
            throw new DistributorsAlreadyExistsException("Unable to create new Distributors");
        }
        return dis1;
    }
    /*
     * This method should be used to delete an existing theatre.Call the
     * corresponding method of Repository interface.
     */
    public boolean deleteDistributors(String distributorsId) throws DistributorsNotFoundException {
        boolean status = false;
        Distributors fetchedTheatre = distributorsRepository.findById(distributorsId).get();
        if (fetchedTheatre == null) {
            throw new DistributorsNotFoundException("Theatre with given name does not exists");

        } else {
            distributorsRepository.delete(fetchedTheatre);
            status = true;
        }
        return status;
    }
    /*
     * This method should be used to update a existing theatre.Call the
     * corresponding method of Repository interface.
     */
    public Distributors updateDistributors(String distributorsId, Distributors distributors) throws DistributorsNotFoundException {

        try {
            Distributors fetchedDistributors = distributorsRepository.findById(distributorsId).get();
            fetchedDistributors.setDistributorsName(distributors.getDistributorsName());
            fetchedDistributors.setDistributorsId(distributors.getDistributorsId());
            fetchedDistributors.setDistributorsLocation(distributors.getDistributorsLocation());
          
            distributorsRepository.save(fetchedDistributors);
            return fetchedDistributors;

        } catch (NoSuchElementException exception) {

            throw new DistributorsNotFoundException("distributors does not exists");
        }
    }
    /*
     * This method should be used to get a theatre by Id.Call the
     * corresponding method of Respository interface.
     */
  public Distributors getDistributorsByDistributorsId(String distributorsId) throws DistributorsNotFoundException {

        
            Distributors fetchedDistributor = distributorsRepository.findById(distributorsId).get();
            if(fetchedDistributor!=null)
                return fetchedDistributor;
            else
            throw new DistributorsNotFoundException("Distributors does not exists");
        }
	
	
	
}
