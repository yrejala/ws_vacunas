package py.una.pol.ws.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.una.pol.ws.dao.UsuarioDao;
import py.una.pol.ws.domain.Usuario;
import py.una.pol.ws.util.ErrorCampo;
import py.una.pol.ws.util.Respuesta;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioDao usuarioDao;

	@GetMapping("/list")
	public List<Usuario> list() {
		try {
			return usuarioDao.getList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Respuesta<Usuario>> insert(@Valid Usuario usuario, BindingResult bindingResult) {

		Respuesta<Usuario> resp = new Respuesta<>();
		resp.setDato(usuario);
		if (bindingResult.hasErrors()) {
			resp.setExito(false);
			resp.setExitoMsg("Errores de validación");
			List<ErrorCampo> errorList = new ArrayList<>();
			for (FieldError fe : bindingResult.getFieldErrors()) {
				ErrorCampo ec = new ErrorCampo();
				ec.setCampo(fe.getField());
				ec.setError(fe.getDefaultMessage());
				errorList.add(ec);
			}
			resp.setErrores(errorList);

			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}
		try {
			usuarioDao.create(usuario);
			resp.setExito(true);
			resp.setExitoMsg("Registro creado con éxito");

			return new ResponseEntity<>(resp, HttpStatus.OK);
		} catch (Exception ex) {
			resp.setExito(false);
			resp.setErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}") // Entre corchetes por que recibe un valor
	public ResponseEntity<Usuario> buscar(@PathVariable Integer id) {
		try {
			Usuario u = usuarioDao.find(id);
			if (u == null) {
				return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
			} else {
				return new ResponseEntity<>(u, HttpStatus.OK);
			}

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Buscar por correo
	//@GetMapping("/email/{correo:.+}") // Entre corchetes por que recibe un valor
	//public ResponseEntity<Usuario> buscarCorreo(@PathVariable String correo) {
	//	try {
        //                Usuario u = usuarioDao.findCorreo(correo);

			/*Usuario u = new Usuario();
			u.setNombre("nombre_prueba_directo");
			u.setCorreo("correoPrueba3@gmail.com"); */

	//		if (u == null) {
	//			return new ResponseEntity<Usuario>(HttpStatus.UNPROCESSABLE_ENTITY);
	//		} else {
	//			return new ResponseEntity<Usuario>(u, HttpStatus.OK);
	//		}

	//	} catch (Exception ex) {
	//		return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
	//	}
	//}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> borrar(@PathVariable Integer id) {
		try {
			Usuario u = usuarioDao.find(id);
			if (u == null) {
				return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
			} else {
				usuarioDao.borrar(id);
				return new ResponseEntity<>(u, HttpStatus.OK);
			}
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
