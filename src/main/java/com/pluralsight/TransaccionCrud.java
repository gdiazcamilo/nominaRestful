package com.pluralsight;

import javax.ws.rs.Path;

import com.model.Transactions;
import com.model.businesslogic.TransaccionService;

@Path("transaccion")
public class TransaccionCrud extends BaseCrud<Transactions> {
	
	static TransaccionService trxSvc = new TransaccionService();
	
	public TransaccionCrud() {
		super(trxSvc, Transactions.class);
	}

}
