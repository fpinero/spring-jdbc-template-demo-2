package com.fpe.springdemo.domain;

import java.util.ArrayList;
import java.util.List;

import com.fpe.springdemo.domain.dao.OrganizationDao;

public class DaoUtils {
	
	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanpOperation = "TRUNCATE";
	
	public static void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n********* printing organizations after " + operation + 
				" operation *********");
		
		for (Organization org : orgs) {
			System.out.println(org);
		}
	}
	
	public static void printOrganization(Organization org, String operation){
		System.out.println("\n*********Printing organization after invoking " + operation +
					" **********\n" + org);
	}

	public static void printSuccessFailure(String operation, boolean param){
		if(param){
			System.out.println("\nOperation " + operation + " succesful");
		}else{
			System.out.println("\nOperation " + operation + " failed");
		}
	}
	
	public static void createSeedData(OrganizationDao dao){
		Organization org1 = new Organization("Amazon", 1994, "65584", 8765, "Amazon slogan 123");
		Organization org2 = new Organization("BMW", 1929, "45854", 5501, "BMW slogan 456");
		Organization org3 = new Organization("Google", 1996, "57575", 4567, "Google slogan 789");
	
		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(0, org1);
		orgs.add(1, org2);
		orgs.add(2, org3);
		
		int createCount = 0;
		for(Organization org : orgs){
			boolean isCreated = dao.create(org);
			if (isCreated){
				createCount++;
			}
			
			System.out.println("Created " + createCount + " organizations");
		}
	
	}
	
	public static void printOrganizationCount(List<Organization> orgs, String operation){
		System.out.println("\n************Currently we have " + orgs.size() + " organizations "
				+ "after " + operation + " operation" );
		
	}
	
	
}
