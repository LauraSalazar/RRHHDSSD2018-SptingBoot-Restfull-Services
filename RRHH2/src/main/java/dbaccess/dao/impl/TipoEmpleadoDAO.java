package dbaccess.dao.impl;

import javax.persistence.NoResultException;

import model.Empleado;
import model.TipoEmpleado;

public class TipoEmpleadoDAO extends GenericDAO{



	public Integer create(Empleado emp){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(emp);
		this.getEntityManager().getTransaction().commit();
		return emp.getId();

	} 

	public TipoEmpleado findById(Integer id){	
		String query = "from employeetype a where a.id = :id ";
		TipoEmpleado tipoEmpleado = null;
		try {
		 tipoEmpleado = (TipoEmpleado) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		 if(tipoEmpleado != null) {
				this.getEntityManager().refresh(tipoEmpleado);
		 }
		}
		catch(NoResultException e) {
			return null;
		}
		return tipoEmpleado;
	}





}
