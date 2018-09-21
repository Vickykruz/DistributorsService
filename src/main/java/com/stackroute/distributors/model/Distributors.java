package com.stackroute.distributors.model;

	import java.util.List;

	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

	//import org.springframework.data.annotation.Id;
	//import org.springframework.data.mongodb.core.mapping.Document;

	@Document
	public class Distributors {
		
		@Id
		String distributorsId;
		String distributorsName;
		String distributorsLocation;
		List<Movies> movies;

		public Distributors(String distributorsId, String distributorsName, String distributorsLocation, List<Movies> movies) {
			super();
			this.distributorsId = distributorsId;
			this.distributorsName = distributorsName;
			this.distributorsLocation = distributorsLocation;
			this.movies = movies;
		}

		
		public Distributors() {
			super();
			// TODO Auto-generated constructor stub
		}


		public String getDistributorsId() {
			return distributorsId;
		}

		public void setDistributorsId(String distributorsId) {
			this.distributorsId = distributorsId;
		}

		public String getDistributorsName() {
			return distributorsName;
		}

		public void setDistributorsName(String distributorsName) {
			this.distributorsName = distributorsName;
		}

		public String getDistributorsLocation() {
			return distributorsLocation;
		}

		public void setDistributorsLocation(String distributorsLocation) {
			this.distributorsLocation = distributorsLocation;
		}

		public List<Movies> getMovies() {
			return movies;
		}

		public void setMovies(List<Movies> movies) {
			this.movies = movies;
		}

		@Override
		public String toString() {
			return "distributors [distributorsId=" + distributorsId + ", distributorsName=" + distributorsName
					+ ", distributorsLocation=" + distributorsLocation + ", movies=" + movies + "]";
		}


	}

