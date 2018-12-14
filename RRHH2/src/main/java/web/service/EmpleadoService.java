package web.service;

import java.util.List;

import dbaccess.dao.impl.EmpleadoDAO;

import dbaccess.dto.EmpleadoDTO;
import model.Empleado;
import model.TipoEmpleado;

public class EmpleadoService {


	EmpleadoDAO empleadoDAO;
	
	public EmpleadoService(){
		super();
		empleadoDAO = new EmpleadoDAO();
	}

public EmpleadoDTO getEmpleado(Integer id){
return (empleadoDAO.getEmpleado(id));
}

public List<EmpleadoDTO> getAll(){
List<EmpleadoDTO> empleadosDTO = empleadoDAO.getAll();
return (empleadosDTO);
}


public Integer create(String firstName,String surname,String email, String password,TipoEmpleado tipoEmpleado){
return empleadoDAO.create(new Empleado(firstName, surname,email,password,tipoEmpleado));
}




}
