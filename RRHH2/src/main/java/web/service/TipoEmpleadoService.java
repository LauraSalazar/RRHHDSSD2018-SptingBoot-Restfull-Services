package web.service;

import dbaccess.dao.impl.TipoEmpleadoDAO;

import model.TipoEmpleado;


public class TipoEmpleadoService {


	TipoEmpleadoDAO tipoEmpleadoDAO;

	public TipoEmpleadoService() {
		super();
		tipoEmpleadoDAO = new TipoEmpleadoDAO();
	}

	public TipoEmpleado getTipoEmpleado(Integer id) {
		return (tipoEmpleadoDAO.findById(id));
	}


}
