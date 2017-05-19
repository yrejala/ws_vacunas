package py.una.pol.ws.dao;

import java.util.List;
import py.una.pol.ws.domain.Correo;

import py.una.pol.ws.domain.Usuario;

public interface CorreoDao {

	Correo findCorreo(String correo);// Interfaz para buscar por correo

}
