package com.pluralsight;

import javax.ws.rs.Path;

import com.model.AsientoContable;
import com.model.businesslogic.AsientoContableService;

@Path("asientocontable")
public class AsientoContableCrud extends BaseCrud<AsientoContable> {

	static AsientoContableService svc = new AsientoContableService();
	
	public AsientoContableCrud() {
		super(svc, AsientoContable.class);
	}
}
