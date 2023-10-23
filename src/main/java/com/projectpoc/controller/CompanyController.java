package com.projectpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectpoc.entity.Company;
import com.projectpoc.service.CompanyService;



@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/company")
	    public Company createCompany(@RequestBody Company company) {
	        return companyService.createCompany(company);
	    }
	 @PutMapping("/updatebyid/{id}")
	    public Company updateCompany(@PathVariable int id, @RequestBody Company company) {
	        return companyService.updateCompany(id, company);
	    }
	 @DeleteMapping("by/{id}")
	    public void deleteCompany(@PathVariable int id) {
	        companyService.deleteCompany(id);
	    }
	 @GetMapping("/getallcompany")
		public List<Company> getall(){
			return  companyService.getall();
		}
	 @GetMapping("/getcompany/{name}")
	 public Company getCompanyByName(@PathVariable String name) {
	         return companyService.getCompanyByName(name);
	     }
}
