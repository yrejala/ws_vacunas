package py.una.pol.ws.main;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import py.una.cnc.lib.core.util.AppLogger;

public class CustomHttpMessageConverter extends MappingJackson2HttpMessageConverter {

	private AppLogger logger = new AppLogger(getClass());

	public CustomHttpMessageConverter() {
		super();
		logger.info("Asignando zona horaria {}", LocaleContextHolder.getTimeZone().getID());
		//objectMapper.setTimeZone(LocaleContextHolder.getTimeZone());
	}

}
