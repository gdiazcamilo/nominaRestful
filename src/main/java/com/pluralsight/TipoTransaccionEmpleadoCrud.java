package com.pluralsight;

import javax.ws.rs.Path;

import com.model.TipoTransaccionEmpleado;
import com.model.businesslogic.TipoTransaccionEmpleadoService;

@Path("tipotransaccionempleado")
public class TipoTransaccionEmpleadoCrud extends BaseCrud<TipoTransaccionEmpleado>  {
	static TipoTransaccionEmpleadoService tteSvc = new TipoTransaccionEmpleadoService();
	
	public TipoTransaccionEmpleadoCrud() {
		super(tteSvc, TipoTransaccionEmpleado.class);
	}
}


