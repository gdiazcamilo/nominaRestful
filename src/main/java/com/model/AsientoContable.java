package com.model;

public class AsientoContable {
	private int idasientosContables;
	private String descripcion;
	private String cuenta;
	private int tipoMovimiento;
	private String fecha;
	private double monto;
	private boolean estado;
	private int transaccionId;
	
	
	public int getTransaccionId() {
		return transaccionId;
	}
	public void setTransaccionId(int transaccionId) {
		this.transaccionId = transaccionId;
	}
	public int getIdasientosContables() {
		return idasientosContables;
	}
	public void setIdasientosContables(int idasientosContables) {
		this.idasientosContables = idasientosContables;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public int getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
