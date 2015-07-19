package com.model;

public class TipoTransaccionEmpleado {

	
	private int idtipoTransaccionEmpleado;
	private int idEmpleado;
	private int idTipoTransaccion;
	private double monto;
	
	
	public int getIdtipoTransaccionEmpleado() {
		return idtipoTransaccionEmpleado;
	}
	public void setIdtipoTransaccionEmpleado(int idtipoTransaccionEmpleado) {
		this.idtipoTransaccionEmpleado = idtipoTransaccionEmpleado;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdTipoTransaccion() {
		return idTipoTransaccion;
	}
	public void setIdTipoTransaccion(int idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;	
	}
	
	
	
}
