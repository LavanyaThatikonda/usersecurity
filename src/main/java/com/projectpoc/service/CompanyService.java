package com.projectpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpoc.entity.Company;
import com.projectpoc.repository.CompanyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	
	 public Company createCompany(Company company) {
	        if (companyRepository.findByName(company.getName()) != null) {
	            throw new RuntimeException("Company already exists");
	        }
	        return companyRepository.save(company);
	    }
	 

//	    public Company updateCompany(int id, Company company) {
//	        // Check if another company with the same name exists
//	        Company companyWithSameName = companyRepository.findByName(company.getName());
//
//	        if (companyWithSameName != null && companyWithSameName.getId() != id) {
//	            throw new RuntimeException("Company with this name already exists");
//	        }
//
//	        // Retrieve the existing company from the database
//	        Company existingCompany = companyRepository.findById(id)
//	                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
//
//	        // Update the existing company properties
//	        existingCompany.setName(company.getName());
//	        existingCompany.setDescription(company.getDescription());
//
//	        // Save and return the updated company
//	        return companyRepository.save(existingCompany);
//	    }
	 public Company updateCompany(int id, Company company) {
		    // Log the ID to check if it's correct
		    System.out.println("Updating company with ID: " + id);

		    // Retrieve the existing company from the database (similar to your existing code)
		    Company existingCompany = companyRepository.findById(id)
		            .orElseThrow(() -> new EntityNotFoundException("Company not found"));

		    // Update the existing company properties
		    existingCompany.setName(company.getName());
		    existingCompany.setDescription(company.getDescription());

		    // Save and return the updated company
		    Company updatedCompany = companyRepository.save(existingCompany);

		    // Log a message indicating the update is successful
		    System.out.println("Company with ID " + id + " has been updated.");

		    return updatedCompany;
		}




		 

	    public void deleteCompany(int id) {
	        Company company = companyRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Company not found"));

	        companyRepository.delete(company);
	    }
	
	    public Company getCompanyByName(String name) {
	        return companyRepository.findByName(name);
	    }
	    public List<Company> getall(){
			return companyRepository.findAll();
		}

	
	

}
