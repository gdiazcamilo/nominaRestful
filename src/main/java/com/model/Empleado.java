package com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empleado extends Result {

	private int idempleados;
	private String cedula;
	private String nombre;
	private String departamento;
	private String puesto;
	
	public int getIdempleados() {
		return idempleados;
	}
	public void setIdempleados(int idempleados) {
		this.idempleados = idempleados;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
}
