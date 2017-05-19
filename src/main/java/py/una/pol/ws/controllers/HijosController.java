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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import py.una.pol.ws.dao.CorreoDao;

import py.una.pol.ws.dao.UsuarioDao;
import py.una.pol.ws.dao.HijosDao;
import py.una.pol.ws.domain.Correo;
import py.una.pol.ws.domain.Usuario;
import py.una.pol.ws.domain.Hijo;
import py.una.pol.ws.util.ErrorCampo;
import py.una.pol.ws.util.Respuesta;

@RestController
@RequestMapping("/hijos")
public class HijosController {

    @Autowired
    private HijosDao hijosDao;

    @GetMapping("/{usuarioId}") // Entre corchetes por que recibe un valor
    public ResponseEntity<List<Hijo>> hijolist(@PathVariable Integer usuarioId) {
        try {
            List<Hijo> hijos = hijosDao.getListByUsuarioId(usuarioId);

            return new ResponseEntity<List<Hijo>>(hijos, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
