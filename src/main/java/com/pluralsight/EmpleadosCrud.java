package com.pluralsight;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.hibernatesetup.HibernateUtilities;
import com.model.Empleado;
import com.model.Result;
import com.model.businesslogic.EmpleadoService;
import com.model.businesslogic.IBaseService;
@Path("empleados")
public class EmpleadosCrud extends BaseCrud<Empleado> {

	static EmpleadoService emplSvc = new EmpleadoService();
	
	public EmpleadosCrud() {
		super(emplSvc, Empleado.class);
	}	
}
