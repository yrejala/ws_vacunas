package py.una.pol.ws.dao;

import java.util.List;
import org.springframework.http.ResponseEntity;

import py.una.pol.ws.domain.Hijo;

public interface HijosDao {

    List<Hijo> getListByUsuarioId(Integer usuarioId);

}
