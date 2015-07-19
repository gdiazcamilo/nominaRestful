package com.pluralsight;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Result;
import com.model.businesslogic.IBaseService;

public class BaseCrud<T> {
	private IBaseService _svc;
	private Class<T> _class;
	
	private String successMsg = "Operación exitosa";
	private String errorMsg = "Ocurrió un error ejecutando su requerimiento";
	
	public BaseCrud(IBaseService service, Class<T> classParam) {
		this._svc = service;
		this._class = classParam;
	}
	
	
	private Result handleException(Exception ex){
		System.out.println(ex.getMessage());
		
		Result result = new Result();
		result.setMessage(ex.getMessage());
		result.setUserDescription(errorMsg);
		result.setResult(false);
		
		return result;
	}
	
	@POST
	@Path("nuevo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Result nuevo(T newEntity) {
		Result result = new Result();
		
		try {
			_svc.create(newEntity);
			
	    	result.setUserDescription(successMsg);
			result.setResult(true);
		}
		catch(Exception ex){
			result = handleException(ex);
		}
		
		return result;
	}
	
	
	
	@POST
	@Path("modificar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Result modificar(T entityToUpdate) {
		Result result = new Result();
		
		try {
			_svc.update(entityToUpdate);
			
			result.setResult(true);
			result.setUserDescription(successMsg);
		}
		catch(Exception ex){
			result = handleException(ex);
		}
		
		return result;
	}
	
	@GET
	@Path("obtenerPorId/{entityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public T obtenerPorId(@PathParam("entityId") int entityId) {
		
		try {
			T foundEntity = (T) _svc.findById(entityId);
			return foundEntity;
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return null;
	}
	
	@GET
	@Path("obtenerTodo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> obtenerTodo() {
		
		try {
			List<T> foundEntities = _svc.findAll();
			return foundEntities;
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return null;
	}
	
	
	
	@GET
	@Path("eliminar/{entityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Result eliminar(@PathParam("entityId") int entityId) {
		Result result = new Result();
		
		try {
			T entity = (T)_svc.findById(entityId);
			_svc.delete(entity);
			
			result.setResult(true);
			result.setUserDescription(successMsg);
		}
		catch(Exception ex){
			result = handleException(ex);
		}
		
		return result;
	}
}
