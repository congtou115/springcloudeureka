package com.zzidc.exception;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPagesConfig {

	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage errorPage400 = new ErrorPage(HttpStatus.FORBIDDEN, "/page_403.html");
				ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/page_404.html");
				ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/page_500.html");
				container.addErrorPages(errorPage400,errorPage404,errorPage500);
			}
			
		};
	}
}
