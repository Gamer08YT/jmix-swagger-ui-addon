package de.bytestore.swaggerui.components.swagger;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;

/**
 * A Vaadin component that integrates the Swagger UI for API documentation visualization.
 * The component allows configuring a single URL or a list of URLs for API documentation.
 * This class is designed to be used in Vaadin Flow applications.
 */
@Tag("swagger-ui")
@NpmPackage(value = "swagger-ui", version = "5.25.2")
@JsModule(value = "./src/swagger/swagger-ui.js")
@CssImport(value = "swagger-ui/dist/swagger-ui.css", include = "swagger-ui", themeFor = "swagger-ui")
// @CssImport(value = "./src/swagger/swagger-ui.css", include = "swagger-ui", themeFor = "swagger-ui")
public class SwaggerUI extends Component implements HasSize {
    public static final String VALUE_URL = "url";

    public static final String VALUE_URLS = "urls";

    public static final String REQUEST_SNIPPETS_ENABLED = "requestSnippetsEnabled";

    public static final String TRY_IT_OUT_ENABLED = "tryItOutEnabled";

    public static final String DOC_EXPANSION = "docExpansion";

    public static final String DEEP_LINKING = "deepLinking";

    public static final String SYNTAX_HIGHLIGHT = "syntaxHighlight";

    public static final String USE_UNSAFE_MARKDOWN = "useUnsafeMarkdown";

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

        throw new NotImplementedException("Currently not implemented, because of an issue with the Swagger UI Frontend.");
    }

    /**
     * Enables or disables the request snippets feature in the Swagger UI component.
     *
     * @param valueIO a boolean flag indicating whether request snippets should be enabled (true) or disabled (false)
     */
    public void setRequestSnippetsEnabled(boolean valueIO) {
        getElement().setProperty(REQUEST_SNIPPETS_ENABLED, valueIO);
    }

    /**
     * Enables or disables the "Try It Out" feature in the Swagger UI component.
     *
     * @param valueIO a boolean flag indicating whether the "Try It Out" feature should be enabled (true) or disabled (false)
     */
    public void setTryItOutEnabled(boolean valueIO) {
        getElement().setProperty(TRY_IT_OUT_ENABLED, valueIO);
    }

    /**
     * Sets the document expansion mode for the Swagger UI component.
     *
     * @param valueIO the DocExpansion enum value representing the desired document expansion mode
     */
    public void setDocExpansion(DocExpansion valueIO) {
        getElement().setProperty(DOC_EXPANSION, valueIO.getId());
    }

    /**
     * Enables or disables the deep linking feature in the Swagger UI component.
     *
     * @param valueIO a boolean flag indicating whether deep linking should be enabled (true) or disabled (false)
     */
    public void setDeepLinking(boolean valueIO) {
        getElement().setProperty(DEEP_LINKING, valueIO);
    }

    /**
     * Enables or disables syntax highlighting in the Swagger UI component.
     *
     * @param valueIO a boolean flag indicating whether syntax highlighting should be enabled (true) or disabled (false)
     */
    public void setSyntaxHighlight(boolean valueIO) {
        getElement().setProperty(SYNTAX_HIGHLIGHT, valueIO);
    }

    /**
     * Enables or disables the use of unsafe Markdown processing in the Swagger UI component.
     *
     * @param valueIO a boolean flag indicating whether unsafe Markdown processing should be
     *                enabled (true) or disabled (false)
     */
    public void setUseUnsafeMarkdown(boolean valueIO) {
        getElement().setProperty(USE_UNSAFE_MARKDOWN, valueIO);
    }
}


