package py.una.pol.ws.dao;

import java.util.List;
import org.springframework.http.ResponseEntity;

import py.una.pol.ws.domain.RegistroVacuna;

public interface RegistroVacunaDao {

    List<RegistroVacuna> getListByHijoId(Integer HijoId);

}
