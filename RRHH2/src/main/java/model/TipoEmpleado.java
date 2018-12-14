package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="employeetype")
public class TipoEmpleado {

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="initials")
	private String initials;
	@Column(name="description")
	private String description;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TipoEmpleado(Integer id, String initials, String description ) {
		
	
		super();
		this.id = id;
		this.initials = initials;
		this.description = description;

	}
	
	public TipoEmpleado(){
		super();
	}

}
