package com.RRHH2.RRHH2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpleadoXml {

	@XmlElement
	private Integer id;
	@XmlElement
	private String firstName;
	@XmlElement
	private String surname;
	@XmlElement
	private String email;
	@XmlElement
	private String password;

	@XmlElement
	// Nombre del tipo de producto
	private Integer tipoEmpleado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(Integer tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public EmpleadoXml() {
	}

	public EmpleadoXml(Integer id, String firstName, String surname, String email, String password,
			Integer tipoEmpleado) {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setEmail(email);
		this.setPassword(password);
		this.setTipoEmpleado(tipoEmpleado);
	}

}
