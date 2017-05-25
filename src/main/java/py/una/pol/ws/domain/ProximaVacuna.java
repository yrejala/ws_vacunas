package py.una.pol.ws.domain;

import java.util.Date;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class RegistroVacuna {

    private String nombreVacuna;
    private String descripcionVacuna;
    private Integer dosis;
    private Integer meses;
    private Date fechaApli;
    private String responsable;

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
    public String getDescripcionVacuna() {
        return descripcionVacuna;
    }

    public void setDescripcionVacuna(String descripcionVacuna) {
        this.descripcionVacuna = descripcionVacuna;
    }
    
    public Integer getDosis() {
        return dosis;
    }

    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Date getFechaApli() {
        return fechaApli;
    }

    public void setFechaApli(Date fechaApli) {
        this.fechaApli = fechaApli;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

}
