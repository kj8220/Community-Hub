package io.github.roopan.rc.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.google.common.base.Predicate;

import io.github.roopan.rc.service.AppServiceImpl;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * Class that implements the necessary settings for using Swagger as an API documentation tool.
 * 
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 * 
 */
@Configuration
@Profile({"dev"})
@EnableSwagger2
public class SwaggerConfiguration 
{
	@Autowired
	private AppServiceImpl appServiceImpl;
	
	private static final String GROUP_NAME = "Reddit Clone";
	
	private static final String TITLE = "Reddit Clone";
	private static final String DESCRIPTION = "Backend to the clone of the popular social media platform Reddit";
	private static final String TERMS_OF_SERVICE_URL = "https://github.com/Spring-Boot-Framework/Community-Hub";
	private static final String LICENSE = "https://app.fossa.com/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FCommunity-Hub";
	private static final String LICENSE_URL = "https://app.fossa.com/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FCommunity-Hub";
	private static final Contact CONTACT = new Contact("Anantha Raju C", "https://roopan.github.io/", "roopan@gmail.com");
	
	/**
	 * Method that configures all the endpoint's mapped in the documentation.
	 * 
	 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
	 *  
	 * @return <code>Docket</code> object
	 */
	@Bean
	public Docket postsApi() 
	{
		return new Docket(DocumentationType.SWAGGER_2)
					.groupName(GROUP_NAME)
					.apiInfo(apiInfo())
					.select()
					.paths(postPaths())
					.build();
	}

	/**
	 * Method that configures the informations about the API. 
	 * 
	 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
	 * 
	 * @return <code>ApiInfo</code> object
	 */
	private ApiInfo apiInfo() 
	{
		appServiceImpl.loadApplicationSettings();
		
		return new ApiInfoBuilder()
						.title(TITLE)
						.description(DESCRIPTION)
						.termsOfServiceUrl(TERMS_OF_SERVICE_URL)
						.license(LICENSE)
						.licenseUrl(LICENSE_URL)
						.version(appServiceImpl.getReleaseVersion().concat("_").concat(appServiceImpl.getApiVersion()))
						.contact(CONTACT)
						.build();
	}
	
	private Predicate<String> postPaths() 
	{
		return or(regex("/api.*"),
				  regex("/actuator.*"));
	}
}