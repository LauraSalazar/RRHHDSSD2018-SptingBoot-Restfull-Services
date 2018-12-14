package com.RRHH2.RRHH2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dbaccess.dto.EmpleadoDTO;

import web.service.EmpleadoService;


@RestController
public class EmpleadoResource {

	EmpleadoService empleadoService;

	public EmpleadoResource() {
		super();
		empleadoService = new EmpleadoService();
	}

/*	@GET
	@Path("/{empleadoId}")*/
	@CrossOrigin
	@RequestMapping(value = "/{empleadoId}",produces = "application/json")
	public EmpleadoXml getEmpleado(@PathVariable("empleadoId") Integer id) {

		EmpleadoDTO empleadoDTO = empleadoService.getEmpleado(id);
		EmpleadoXml empXml = new EmpleadoXml();
		if (empleadoDTO != null) {
			System.out.println("Antes de ProductoXml");
			//productosXml = new ArrayList<ProductoXml>();
			empXml.setEmail(empleadoDTO.getEmail());
			empXml.setFirstName(empleadoDTO.getFirstName());
			empXml.setId(empleadoDTO.getId());
			empXml.setPassword(empleadoDTO.getPassword());
			empXml.setSurname(empleadoDTO.getSurname());
			empXml.setTipoEmpleado(empleadoDTO.getTipoEmpleado());
		}
		return empXml;
		
	}

/*	// Crea un empleado
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response createEmpleado(EmpleadoXml empleado) {
		Response response = null;
		try {
			System.out.println("empleado.getId: " + empleado.getId());
			System.out.println("empleado.getFirstName: " + empleado.getFirstName());
			System.out.println("empleado.surname: " + empleado.getSurname());
			System.out.println("empleado.password: " + empleado.getEmail());
			System.out.println("empleado.tipoempleado: " + empleado.getTipoEmpleado());

			TipoEmpleadoService tipoEmpleadoService = new TipoEmpleadoService();
			TipoEmpleado tipoEmpleado = tipoEmpleadoService
					.getTipoEmpleado(Integer.valueOf(empleado.getTipoEmpleado()));
			System.out.println("empleado.tipoEmpleado:" + tipoEmpleado);
			// String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta,
			// String estado, String ubicacionLatitud, String ubicacionLongitud, Integer
			// cantidad
			// usuarioService.create(usuario.getDni(),usuario.getApellido(),usuario.getNombres(),usuario.getDomicilio(),usuario.getFechaNac(),usuario.getSexo(),usuario.getMail());
			Integer id = empleadoService.create(empleado.getFirstName(), empleado.getSurname(), empleado.getEmail(),
					empleado.getPassword(), tipoEmpleado);

			response = Response.ok(200).entity(String.valueOf(id)).build();
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}*/

/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoempleados")*/
	@CrossOrigin
	@RequestMapping(value = "/listadoempleados",produces = "application/json")
	public List<EmpleadoXml> getempleados() {
		EmpleadoXml empXml = null;
		List<EmpleadoDTO> empleadosDTO;
		List<EmpleadoXml> empleadosXml= new ArrayList<EmpleadoXml>();
		empleadosDTO = empleadoService.getAll();
		if(empleadosDTO != null) {
			for (EmpleadoDTO empleadoDTO : empleadosDTO) {
				empXml = new EmpleadoXml();
				empXml.setEmail(empleadoDTO.getEmail());
				empXml.setFirstName(empleadoDTO.getFirstName());
				empXml.setId(empleadoDTO.getId());
				empXml.setPassword(empleadoDTO.getPassword());
				empXml.setSurname(empleadoDTO.getSurname());
				empXml.setTipoEmpleado(empleadoDTO.getTipoEmpleado());
				empleadosXml.add(empXml);
			}
		}

		return empleadosXml;

	}

}
