package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class WebBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBaseApplication.class, args);
	}



	/**
	 * 解决异常信息：
	 *  java.lang.IllegalArgumentException:
	 *      Invalid character found in the request target. The valid characters are defined in RFC 7230 and RFC 3986
	 * @return
	 */
	/*@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
			@Override
			public void customize(Connector connector) {
				connector.setProperty("relaxedQueryChars", "|{}[]/\\");
			}
		});
		return factory;
	}*/
}
