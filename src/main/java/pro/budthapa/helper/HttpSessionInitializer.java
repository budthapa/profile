package pro.budthapa.helper;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import pro.budthapa.config.HttpSessionConfig;

public class HttpSessionInitializer extends AbstractHttpSessionApplicationInitializer {

	public HttpSessionInitializer() {
		super(HttpSessionConfig.class);
	}
}
