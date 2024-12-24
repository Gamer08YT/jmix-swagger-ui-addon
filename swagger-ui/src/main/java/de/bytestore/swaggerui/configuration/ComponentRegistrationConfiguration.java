package de.bytestore.swaggerui.configuration;

import de.bytestore.swaggerui.components.swagger.SwaggerLoader;
import de.bytestore.swaggerui.components.swagger.SwaggerUI;
import io.jmix.flowui.sys.registration.ComponentRegistration;
import io.jmix.flowui.sys.registration.ComponentRegistrationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A Spring configuration class for registering components. This class is responsible for
 * creating and configuring beans associated with UI components.
 */
@Configuration
public class ComponentRegistrationConfiguration {
    /**
     * Configures and registers a Swagger UI component.
     */
    @Bean
    public ComponentRegistration swagger() {
        return ComponentRegistrationBuilder.create(SwaggerUI.class)
                .withComponentLoader("swagger-ui", SwaggerLoader.class)
                .build();
    }

}
