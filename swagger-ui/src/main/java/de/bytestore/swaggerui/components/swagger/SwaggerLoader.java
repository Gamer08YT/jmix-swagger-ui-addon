package de.bytestore.swaggerui.components.swagger;

import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;

/**
 * SwaggerLoader is a component loader responsible for creating and configuring instances
 * of the SwaggerUI component based on XML definitions. It integrates Swagger UI with
 * Vaadin Flow applications for API documentation visualization.
 *
 * This class extends AbstractComponentLoader and provides an implementation for creating
 * the component and loading its properties from the XML configuration.
 */
public class SwaggerLoader extends AbstractComponentLoader<SwaggerUI> {
    @Override
    protected SwaggerUI createComponent() {
        return factory.create(SwaggerUI.class);
    }

    /**
     * Loads component properties by XML definition.
     */
    @Override
    public void loadComponent() {
        loadString(element, "url", resultComponent::setUrl);
        loadBoolean(element, "requestSnippetsEnabled", resultComponent::setRequestSnippetsEnabled);
        loadBoolean(element, "tryItOutEnabled", resultComponent::setTryItOutEnabled);
        loadEnum(element, DocExpansion.class, "docExpansion", resultComponent::setDocExpansion);
        loadBoolean(element, "deepLinking", resultComponent::setDeepLinking);
        loadBoolean(element, "syntaxHighlight", resultComponent::setSyntaxHighlight);
        loadBoolean(element, "useUnsafeMarkdown", resultComponent::setUseUnsafeMarkdown);

        componentLoader().loadSizeAttributes(resultComponent, element);
    }
}
