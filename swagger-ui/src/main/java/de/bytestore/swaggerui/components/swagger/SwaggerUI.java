package de.bytestore.swaggerui.components.swagger;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import java.util.Arrays;

/**
 * A Vaadin component that integrates the Swagger UI for API documentation visualization.
 * The component allows configuring a single URL or a list of URLs for API documentation.
 * This class is designed to be used in Vaadin Flow applications.
 */
@Tag("swagger-ui")
@NpmPackage(value = "jquery", version = "1.9.1")
@NpmPackage(value = "swagger-ui", version = "5.18.2")
@JsModule(value = "./src/swagger/swagger-ui.js")
@CssImport(value = "swagger-ui/dist/swagger-ui.css", include = "swagger-ui", themeFor = "swagger-ui")
@CssImport(value = "./src/swagger/swagger-ui.css", include = "swagger-ui", themeFor = "swagger-ui")
public class SwaggerUI extends Component implements HasSize {
    public static final String VALUE_URL = "url";

    public static final String VALUE_URLS = "urls";

    /**
     * Retrieves the URL property of the SwaggerUi component.
     *
     * @return the URL associated with the SwaggerUi component, or null if the property is undefined
     */
    public String getUrl() {
        return getElement().getProperty(VALUE_URL, null);
    }

    /**
     * Sets the URL property of the SwaggerUi component.
     *
     * @param valueIO the URL to be set for the SwaggerUi component
     */
    public void setUrl(String valueIO) {
        getElement().setProperty(VALUE_URL, valueIO);
    }

    /**
     * Sets a list of URLs for the Swagger UI component.
     *
     * @param valueIO an array of URLs to be set for the Swagger UI component
     */
    public void setUrls(String... valueIO) {
        getElement().setPropertyList(VALUE_URLS, Arrays.stream(valueIO).toList());
    }
}


