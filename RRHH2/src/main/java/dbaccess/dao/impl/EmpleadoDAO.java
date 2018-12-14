package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import dbaccess.dto.EmpleadoDTO;
import model.Empleado;


public class EmpleadoDAO extends GenericDAO{


	public Integer create(Empleado emp){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(emp);
		this.getEntityManager().getTransaction().commit();
		return emp.getId();

	} 
	
	//Recupera un empleadoDTO con un id dado
	public EmpleadoDTO getEmpleado(Integer id){
		Empleado empleado = null;
		EmpleadoDTO empleadoDTO = null;
		System.out.println("valor de id antes de la query: " + id);
		String query = "from employee a where a.id = :id ";
		try {
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()){
		empleado = (Empleado)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (empleado != null){
			this.getEntityManager().refresh(empleado);
			 empleadoDTO = new EmpleadoDTO(empleado);
					}
		//System.out.println("valor de nombre de empleadoDTO despues de la query" + empleadoDTO.getFirstName());
		}
		catch(NoResultException e) {
			return null;
		}
		return empleadoDTO;
		
	}
	
	public Empleado findById(Integer id){	
		String query = "from employee a where a.id = :id ";
		Empleado emp = null;
		try {
		emp = (Empleado) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		if (emp != null) {
			this.getEntityManager().refresh(emp);
		}
		}
		catch(NoResultException e) {
			return null;
		}
		return emp;
	}
	
	public Empleado modify(Integer id, String firstName, String lastName, String email,
			String phoneNumber, String hireDate, String salary, String commissionPct){	
		String query = "from employee a where a.id = :id ";
		Empleado emp = null;
		try {
		emp = (Empleado) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
		return emp;
	}
	
	
	public List<EmpleadoDTO> getAll(){
		String query = "from employee ";
		List<Empleado> empleados = null;
		List<EmpleadoDTO> empleadosDTO = null;
		try {
		
		 empleados = (List<Empleado>)this.getEntityManager().createQuery(query).getResultList();
		 empleadosDTO = new ArrayList<EmpleadoDTO>();
		for(Empleado a : empleados){
			empleadosDTO.add(new EmpleadoDTO(a));
		}
		}
		catch(NoResultException e) {
			return null;
		}
		return empleadosDTO;
	}


}
