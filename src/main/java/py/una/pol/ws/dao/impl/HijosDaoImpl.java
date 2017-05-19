package py.una.pol.ws.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.una.cnc.lib.db.dataprovider.SQLExecuter;
import py.una.pol.ws.dao.HijosDao;
import py.una.pol.ws.domain.Correo;
import py.una.pol.ws.domain.Hijo;

@Repository
public class HijosDaoImpl extends DaoImpl implements HijosDao {

    @Override
    public List<Hijo> getListByUsuarioId(Integer usuarioId) {

        return getListFromSQL(Hijo.class, "SELECT id, nombre, apellido, sexo, fecha_nac as \"fechaNac\" FROM hijos WHERE id_usuario = ?", usuarioId);
        //return getListFromSQL(Hijo.class, "SELECT id, nombre FROM hijos WHERE id_usuario = ?", usuarioId);
    }

}
