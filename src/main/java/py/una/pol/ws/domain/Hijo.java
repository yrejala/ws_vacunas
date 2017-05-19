package py.una.pol.ws.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Usuario {
	private Integer id;

	@NotNull(message="Debe ingresar nombre")
	private String nombre;
	@NotNull(message="Debe ingresar correo")
	@Email(message="Email mal formado")
	private String correo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
