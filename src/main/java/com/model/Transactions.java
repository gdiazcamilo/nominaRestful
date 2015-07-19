package com.model;

public class Transactions {
	
	private int idtransactions;
	private String fecha;
	private double monto;
	private boolean estado;
	private int tipoTransaccionEmpleado;
	private int nominaId;
	
	
	public int getNominaId() {
		return nominaId;
	}
	public void setNominaId(int nominaId) {
		this.nominaId = nominaId;
	}
	public int getTipoTransaccionEmpleado() {
		return tipoTransaccionEmpleado;
	}
	public void setTipoTransaccionEmpleado(int tipoTransaccionEmpleado) {
		this.tipoTransaccionEmpleado = tipoTransaccionEmpleado;
	}
	public int getIdtransactions() {
		return idtransactions;
	}
	public void setIdtransactions(int idtransactions) {
		this.idtransactions = idtransactions;
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
