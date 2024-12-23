package de.bytestore.swaggerui.components.swagger;

import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;

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

        componentLoader().loadSizeAttributes(resultComponent, element);
    }
}
