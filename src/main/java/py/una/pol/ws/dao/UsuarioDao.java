package py.una.pol.ws.dao;

import java.util.List;

import py.una.pol.ws.domain.Usuario;

public interface UsuarioDao {
	List<Usuario> getList();

	void create(Usuario usuario);

	Usuario find(Integer id);

	//Usuario findCorreo(String correo);// Interfaz para buscar por correo

	void borrar(Integer id);

}
