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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import py.una.cnc.lib.core.util.AppLogger;
import py.una.pol.ws.dao.CorreoDao;

import py.una.pol.ws.dao.UsuarioDao;
import py.una.pol.ws.domain.Correo;
import py.una.pol.ws.domain.Usuario;
import py.una.pol.ws.util.ErrorCampo;
import py.una.pol.ws.util.Respuesta;

@RestController
@RequestMapping("/correo")
public class CorreoController {
    
	   AppLogger logger = new AppLogger(getClass());
	@Autowired
	private CorreoDao correoDao;

	

	// Buscar por correo
	@GetMapping // Entre corchetes por que recibe un valor
	public ResponseEntity<Correo> buscarCorreo(@RequestParam  String correo) {
		try {
                        Correo u = correoDao.findCorreo(correo);
                         logger.info("resultado busqueda correo {}:{}", correo,u);
			/*Usuario u = new Usuario();
			u.setNombre("nombre_prueba_directo");
			u.setCorreo("correoPrueba3@gmail.com"); */

			if (u == null) {
				return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
			} else {
				return new ResponseEntity<>(u, HttpStatus.OK);
			}

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
