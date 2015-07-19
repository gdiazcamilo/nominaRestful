package com.pluralsight;

import javax.ws.rs.Path;

import com.model.Nomina;
import com.model.businesslogic.NominaService;

@Path("nomina")
public class NominaCrud extends BaseCrud<Nomina> {

	static NominaService nomSvc = new NominaService();
	
	public NominaCrud() {
		super(nomSvc, Nomina.class);
	}
	
}

