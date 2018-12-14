package dbaccess.dto;

import model.Empleado;


public class EmpleadoDTO {

	private Integer id;
	private String firstName;
	private String surname;
	private String email;
	private String password;
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



	public String toString() {
		return (" Empleado id: " + this.getId() + " Empleado name " + this.getFirstName());
	}


	public EmpleadoDTO(Empleado emp) {
		super();

		this.id = emp.getId();
		this.firstName = emp.getEmail();
		this.surname = emp.getSurname();
		this.email = emp.getEmail();
		this.password = emp.getPassword();
		this.tipoEmpleado = emp.getTipoEmpleado().getId();
		}


}
