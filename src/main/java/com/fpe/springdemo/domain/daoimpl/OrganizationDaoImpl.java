package com.fpe.springdemo.domain.daoimpl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fpe.springdemo.domain.Organization;
import com.fpe.springdemo.domain.dao.OrganizationDao;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public boolean create(Organization org) {
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) "
				+ "VALUES(?, ?, ?, ?, ?)";
		Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPotalCode(),
				org.getEmployeeCount(), org.getSlogan() };

		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public Organization getOrganization(Integer id) {
		String sqlQuery = "SELECT * FROM organization WHERE id = ?";
		Object[] args = new Object[] { id };
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}
	
	public Organization getOrganizationIdByName(String compName){
		String sqlQuery = "SELECT * FROM organization WHERE company_name = ?";
		Object[] args = new Object[] { compName };
		Organization org;
		try {
			org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		}catch (Exception e) {
			System.out.println("!!!!! NO ENCONTRÉ LA ORIGANIZATION " + compName + "EN LA DB");
			return null;
		}
		System.out.println("_____ ENCONTRÉ LA ORGANIZATION " + compName + " EN LA DB");
		return org;
	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		String sqlQuery = "DELETE FROM organization WHERE id = ?";
		Object[] args = new Object[] { org.getId() };
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public boolean update(Organization org) {
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[] { org.getSlogan(), org.getId() };
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}
	
	public List<Organization> getOrganizationByMinEmployees(Integer employees) {
		String sqlQuery = "SELECT * FROM organization WHERE employee_count > ?";
		Object[] args = new Object[] { employees };
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, args, new OrganizationRowMapper());
		return orgList;
	}

	// elimina totalmente los registros de una tabla
	// no es normal añadir este metodo
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);

	}

	

}
