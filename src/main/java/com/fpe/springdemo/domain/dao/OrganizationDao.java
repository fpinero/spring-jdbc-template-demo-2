package com.fpe.springdemo.domain.dao;

import java.util.List;
import javax.sql.DataSource;
import com.fpe.springdemo.domain.Organization;

public interface OrganizationDao {

	// Establece el data-source q requeriremos para crear la conexión con la DB
	public void setDataSource(DataSource ds);

	// Crea un registro en la tabala organization
	public boolean create(Organization org);

	// Retorna una organization específica según el id dado
	public Organization getOrganization(Integer id);

	// Retorna todas las organizations de la tabla
	public List<Organization> getAllOrganizations();

	// Elimina la organozation dada de la tabla
	public boolean delete(Organization org);

	// Actualiza los datos de una organization dada
	public boolean update(Organization org);

	// no es necesario, elimina todo el contenido de la tabla.
	// Es útil si vas a estar jugando con la tabla haciendo pruebas CRUD
	public void cleanup();

	public Organization getOrganizationIdByName(String string);
	
	public List<Organization> getOrganizationByMinEmployees(Integer employees);
}
