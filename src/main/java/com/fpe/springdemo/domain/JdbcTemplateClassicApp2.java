package com.fpe.springdemo.domain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fpe.springdemo.domain.dao.OrganizationDao;

public class JdbcTemplateClassicApp2 {

	public static void main(String[] args) {

		// creemos el application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// Creemos la bean
		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");

		DaoUtils.createSeedData(dao);

		List<Organization> orgs = dao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);

		Organization org = new Organization("General Electric", 1978, "98569", 5776, "GE slogan 012");
		boolean isCreated = dao.create(org);

		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.createOperation);

		orgs = dao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);

		Organization org2 = dao.getOrganization(1);
		DaoUtils.printOrganization(org2, "getOrganization");

		Organization org3 = dao.getOrganization(2);
		String originalSlogan = org3.getSlogan();
		System.out.println("----> Slogan original: " + originalSlogan);
		org3.setSlogan("We build ** awesome ** driving machines!");
		boolean isUpdated = dao.update(org3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(dao.getOrganization(2), DaoUtils.updateOperation);

		boolean isDeleted = dao.delete(dao.getOrganization(1));
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.deleteOperation);
		
		String OrganizationToSerach = "Google";
		Organization org4 = dao.getOrganizationIdByName(OrganizationToSerach);
		if (org4 != null){
			int idOrg = org4.getId();
			System.out.println("El id de la organización " + OrganizationToSerach + " es:" + idOrg);
			System.out.println("Los datos de la organización son: " + org4);
		}

		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.cleanpOperation);

		// cerremos de application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
