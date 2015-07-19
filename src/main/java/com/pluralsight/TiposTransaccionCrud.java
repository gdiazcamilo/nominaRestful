package com.pluralsight;


import javax.ws.rs.Path;

import com.model.TipoTransaccion;
import com.model.businesslogic.TipoTransaccionService;

@Path("tipotransaccion")
public class TiposTransaccionCrud extends BaseCrud<TipoTransaccion> {
	static TipoTransaccionService ttSvc = new TipoTransaccionService();
	
	public TiposTransaccionCrud() {
		super(ttSvc, TipoTransaccion.class);
	}	
}
