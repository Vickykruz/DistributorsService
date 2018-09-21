package com.stackroute.distributors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.distributors.exceptions.DistributorsAlreadyExistsException;
import com.stackroute.distributors.exceptions.DistributorsNotFoundException;
import com.stackroute.distributors.model.Distributors;
import com.stackroute.distributors.service.DistributorsService;

@CrossOrigin("*")
@RestController
public class DistributorsController {

	    private DistributorsService distributorsService;

	    
	    /*
		 * Autowiring should be implemented for the TheatreService. (Use Constructor-based
		 * autowiring) Please note that we should not create an object using the new
		 * keyword
		 */
	    @Autowired
	    public DistributorsController(DistributorsService distributorsService) {

	        this.distributorsService = distributorsService;
	    }

	    /*
		 * Define a handler method which will register a specific theatre by reading the
		 * Serialized object from request body and save the user details in the
		 * database. This handler method should return any one of the status messages
		 * basis on different situations:
		 * 1. 201(CREATED) - If the theatre created successfully. 
		 * 2. 409(CONFLICT) - If the Id conflicts with any existing theatre
		 * 
		 * This handler method should map to the URL "/api/v1/theatre" using HTTP POST method
		 */
	 

	    @PostMapping("/api/v1/distributors")
	    public ResponseEntity<?> register(@RequestBody Distributors distributors){
	    	ResponseEntity<?>responseEntity=null;
	        try{
	            System.out.println(distributors);
	           Distributors d = distributorsService.registerDistributors(distributors);
	            responseEntity = new ResponseEntity<Distributors>(d,HttpStatus.CREATED);
	            
	        }catch(DistributorsAlreadyExistsException e)
	        {
	        	responseEntity=new ResponseEntity<String>("already",HttpStatus.CONFLICT);	        }
	        return responseEntity;
	        }
	   
	    /*
		 * Define a handler method which will delete a user from a database.
		 * This handler method should return any one of the status messages basis on
		 * different situations: 
		 * 1. 200(OK) - If the theatre deleted successfully from database. 
		 * 2. 404(NOT FOUND) - If the theatre with specified Id is not found.
		 *
		 * This handler method should map to the URL "/api/v1/user/{id}" using HTTP Delete
		 * method" where "id" should be replaced by a valid Id without {}
		 */
	     @DeleteMapping("/api/v1/distributors/{distributorsId}")
	     public ResponseEntity<?> deleteDistributors(@PathVariable() String distributorsId) {
	     ResponseEntity<?>responseEntity = null;

	     try {
	        distributorsService.deleteDistributors(distributorsId);
	        responseEntity = new ResponseEntity<>("Successfully Deleted Theatre with id: " + distributorsId, HttpStatus.OK);

	     } catch (DistributorsNotFoundException exception) {
	        responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	     }
	     return responseEntity;
	   }

	     /*
	 	 * Define a handler method which will update a specific user by reading the
	 	 * Serialized object from request body and save the updated user details in a
	 	 * database. This handler method should return any one of the status messages
	 	 * basis on different situations: 
	 	 * 1. 200(OK) - If the theatre updated successfully.
	 	 * 2. 404(NOT FOUND) - If the user with specified Id is not found.
	 	 * 
	 	 * This handler method should map to the URL "/api/v1/user/{id}" using HTTP PUT method.
	 	 */
	     @PutMapping("/api/v1/distributors/{distributorsId}")
	     public ResponseEntity<?>updateDistributors(@PathVariable() String distributorsId, @RequestBody Distributors distributors) {


	     ResponseEntity<?>responseEntity = null;

	     try {
	        Distributors fetchedDistributors = distributorsService.updateDistributors(distributorsId, distributors);
	        responseEntity = new ResponseEntity<>(fetchedDistributors, HttpStatus.OK);
	     } catch (DistributorsNotFoundException exception) {

	        responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

	     }

	    return responseEntity;
	}

	 	/*
	 	 * Define a handler method which will get us the theatre by a Id.
	 	 * 
	 	 * This handler method should return any one of the status messages basis on
	 	 * different situations: 1. 200(OK) - If the theatre found successfully. 
	 	 * 
	 	 * 
	 	 * This handler method should map to the URL "/api/v1/theatre/{id}" using HTTP GET method
	 	 */

		@GetMapping("/api/v1/distributors/{distributorsId}")
	     public ResponseEntity<?> getDistributorsBydistributorsId(@PathVariable String distributorsId) {
			     ResponseEntity<?>responseEntity=null;
	         try {
	            
	             	Distributors getuser=distributorsService.getDistributorsByDistributorsId(distributorsId);
	                 if(getuser==null)
	                	 responseEntity = new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	                 else
	                	 responseEntity = new ResponseEntity<Distributors>(getuser, HttpStatus.OK);
	             }
	            
	         catch(DistributorsNotFoundException e) {
	        	 responseEntity = new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	         }
	         return responseEntity;
	     }



	  	/*
	  	 * Define a handler method which will get us the theater by a city.
	  	 * 
	  	 * This handler method should return any one of the status messages basis on
	  	 * different situations: 1. 200(OK) - If the theater found successfully. 
	  	 * 
	  	 * 
	  	 * This handler method should map to the URL "/api/v1/theater/{city}" using HTTP GET method
	  	 */
	 
	}
