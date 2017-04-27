package py.una.pol.ws.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.una.cnc.lib.db.dataprovider.SQLExecuter;
import py.una.pol.ws.dao.UsuarioDao;
import py.una.pol.ws.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends DaoImpl implements UsuarioDao {

	@Override
	public List<Usuario> getList() {

		return getListFromSQL(Usuario.class, "SELECT id, nombre, correo FROM usuarios");
	}

	@Override
	public void create(Usuario usuario) {
		String sql = "INSERT INTO usuarios(nombre, correo) VALUES (?, ?)";
		super.create(sql, usuario.getNombre(), usuario.getCorreo());

	}

	@Override
	public Usuario find(Integer id) {
		String sql = "SELECT id, nombre, correo FROM usuarios WHERE id = ?";
		return super.getObjectFromSQL(sql, Usuario.class, id);
	}

	// Buscar por correo
	@Override
	public Usuario findCorreo(String correo) {
		String sql = "SELECT id, nombre, correo FROM usuarios WHERE correo = ?";
		return super.getObjectFromSQL(sql, Usuario.class, correo);
	}

	@Override
	public void borrar(Integer id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		SQLExecuter exec = new SQLExecuter(getDsPool());
		exec.execute(ds, sql, id);

	}
}
