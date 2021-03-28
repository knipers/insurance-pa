package br.com.autoinsurance.quote.configurations;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import static java.util.Collections.singletonList;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@EnableSwagger2
@EnableOpenApi
public class SwaggerConfiguration {
    private static final String API_TITLE = "Insurance Quotation";
    private static final String API_DESCRIPTION = "API for auto insurance quotation";
    private static final String API_VERSION = "0.0.1-ALPHA";
    private static final String TERMS_OF_SERVICE_URL = "none";
    private static final Contact CONTACT = new Contact("Moacir Rafael Knipers", "none", "moacir.rafael@gmail.com");
    private static final String LICENSE = "Apache 2.0";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";

    private TypeResolver typeResolver;

    @Autowired
    public SwaggerConfiguration(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Bean
    public Docket insuranceApi() {
        Docket docket = new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2);
        return docket.apiInfo(getApiInfo());
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .showCommonExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }

    @Bean
    public Docket openApiPetStore() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("open-api-insurance-quotation")
                .select()
                .paths(petstorePaths())
                .build();
    }

    private Predicate<String> petstorePaths() {
        return regex(".*/api/.*");
    }

    private static ApiInfo getApiInfo() {
        return new ApiInfo(API_TITLE, API_DESCRIPTION, API_VERSION,TERMS_OF_SERVICE_URL,CONTACT,LICENSE,LICENSE_URL, new ArrayList<>());
    }

}
