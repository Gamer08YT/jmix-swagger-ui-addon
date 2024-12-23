package de.bytestore.autoconfigure.swaggerui;

import de.bytestore.swaggerui.SwaggerConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({SwaggerConfiguration.class})
public class SwaggerAutoConfiguration {
}

