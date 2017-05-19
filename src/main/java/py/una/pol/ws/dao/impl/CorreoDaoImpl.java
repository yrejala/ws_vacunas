package py.una.pol.ws.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import py.una.cnc.lib.core.util.AppLogger;

import py.una.cnc.lib.db.dataprovider.SQLExecuter;
import py.una.pol.ws.dao.CorreoDao;
import py.una.pol.ws.domain.Correo;
import py.una.pol.ws.domain.Usuario;

@Repository
public class CorreoDaoImpl extends DaoImpl implements CorreoDao {

	   AppLogger logger = new AppLogger(getClass());
	public Correo findCorreo(String correo) {
            logger.info("Buscando correo : {}",correo);
		//String sql = "SELECT id, nombre, correo FROM usuarios WHERE correo = ?";
                String sql = "SELECT id, correo FROM usuarios WHERE correo = ?";
		return super.getObjectFromSQL(sql, Correo.class, correo);
	}

}
