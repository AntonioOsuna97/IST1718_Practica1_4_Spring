package org.ingservicio.IST1718Practica4;

import java.io.Serializable;

public class DTOUsuarios implements Serializable {
//Datos de nuestra tabla
	private String nombre;
	private String password;
	private String email;
	private String dni;

	public DTOUsuarios() {
		this.nombre="";
		this.email="";
		this.dni="";
		this.password="";
	}
	
	public DTOUsuarios(String nombre, String password, String email, String dni) {
		this.nombre=nombre;
		this.password=password;
		this.email=email;
		this.dni=dni;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
