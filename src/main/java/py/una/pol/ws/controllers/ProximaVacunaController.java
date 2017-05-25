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
import py.una.pol.ws.dao.RegistroVacunaDao;
import py.una.pol.ws.domain.Correo;
import py.una.pol.ws.domain.Usuario;
import py.una.pol.ws.domain.Hijo;
import py.una.pol.ws.domain.RegistroVacuna;
import py.una.pol.ws.util.ErrorCampo;
import py.una.pol.ws.util.Respuesta;

@RestController
@RequestMapping("/registro")
public class RegistroVacunaController {

    @Autowired
    private RegistroVacunaDao RegistroVacunaDao;

    @GetMapping("/{hijoId:.+}") // Entre corchetes por que recibe un valor
    public ResponseEntity<List<RegistroVacuna>> getListByHijoId(@PathVariable Integer hijoId) {
        try {
            List<RegistroVacuna> registro = RegistroVacunaDao.getListByHijoId(hijoId);

            return new ResponseEntity<List<RegistroVacuna>>(registro, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
