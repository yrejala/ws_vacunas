package py.una.pol.ws.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.una.pol.ws.dao.UsuarioDao;
import py.una.pol.ws.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends DaoImpl implements UsuarioDao{


	@Override
	public List<Usuario> getList() {

		return getListFromSQL(Usuario.class, "SELECT id, nombre, correo FROM usuarios");
	}

	@Override
	public void create(Usuario usuario) {
		String sql= "INSERT INTO usuarios(nombre, correo) VALUES (?, ?)";
		super.create(sql, usuario.getNombre(), usuario.getCorreo());

	}

	@Override
	public Usuario find(Integer id) {
		String sql = "SELECT id, nombre, correo FROM usuarios WHERE id = ?1";
		return super.getObjectFromSQL(sql, Usuario.class, id);
	}
}
