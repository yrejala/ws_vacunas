package py.una.pol.ws.util;

import java.util.List;

public class Respuesta<T> {

	private boolean exito;
	private String errorMsg;
	private String exitoMsg;
	private T dato;
	private List<ErrorCampo> errores;

	public boolean isExito() {

		return exito;
	}

	public void setExito(boolean exito) {

		this.exito = exito;
	}

	public String getErrorMsg() {

		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {

		this.errorMsg = errorMsg;
	}

	public String getExitoMsg() {

		return exitoMsg;
	}

	public void setExitoMsg(String exitoMsg) {

		this.exitoMsg = exitoMsg;
	}

	public T getDato() {

		return dato;
	}

	public void setDato(T dato) {

		this.dato = dato;
	}

	public List<ErrorCampo> getErrores() {

		return errores;
	}

	public void setErrores(List<ErrorCampo> errores) {

		this.errores = errores;
	}

}
