package py.una.pol.ws.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.una.cnc.lib.db.dataprovider.SQLExecuter;
import py.una.pol.ws.dao.HijosDao;
import py.una.pol.ws.dao.RegistroVacunaDao;
import py.una.pol.ws.domain.Correo;
import py.una.pol.ws.domain.Hijo;
import py.una.pol.ws.domain.RegistroVacuna;

@Repository
public class RegistroVacunaDaoImpl extends DaoImpl implements RegistroVacunaDao {

    @Override
    public List<RegistroVacuna> getListByHijoId(Integer hijoId) {

        //return getListFromSQL(RegistroVacuna.class, "SELECT id, nombre, apellido, fecha_nac as \"fechaNac\" FROM hijos WHERE id_usuario = ?", hijoId);
        return getListFromSQL(RegistroVacuna.class, "select v.nombre as \"nombreVacuna\", v.descripcion as \"descripcionVacuna\", v.dosis, v.meses, rv.fecha_apli as \"fechaApli\", rv.responsable from vacunas v, registro_vacunas rv where v.id = rv.id_vacuna and rv.id_hijo = ?", hijoId);
    }

}
