package com.ty.springBoot_FoodApp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // all configure data is present
@EnableSwagger2 
public class ApplicationConfig {
 // Docket means documentation
	@Bean // it create the object for docket it display the name of project on documentation
	public Docket getDocket() {
		Contact contact = new Contact("infosys", "www.infosys.com", "infosys@gmail.com");	 //contact for problem in api or App
		List<VendorExtension> extensions = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("Food App", "foodapp for inhouse order", "1.01", "1 year of free service", contact, "www.infosys.com", "www.infosys.com", extensions); //for providing the information for client
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.basePackage("com.ty.springBoot_FoodApp")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
