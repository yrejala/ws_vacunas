package py.una.pol.ws.domain;



public class Correo {

    private Integer id;
    private String correo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
        @Override
    public String toString() {
        return "Correo{" + "id=" + id + ", correo=" + correo + '}';
    }

}
