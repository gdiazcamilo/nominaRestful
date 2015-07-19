package com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoTransaccion extends Result {

	private int idtipoTransaccion;
	private String nombre;
	private boolean dependeSalario;
	private boolean Estado;
	private String codigo;
	private double porcentaje;
	
	
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public int getIdtipoTransaccion() {
		return idtipoTransaccion;
	}
	public void setIdtipoTransaccion(int idtipoTransaccion) {
		this.idtipoTransaccion = idtipoTransaccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isDependeSalario() {
		return dependeSalario;
	}
	public void setDependeSalario(boolean dependeSalario) {
		this.dependeSalario = dependeSalario;
	}
	public boolean getEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
