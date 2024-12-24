package de.bytestore.swaggerui.components;

import io.jmix.flowui.kit.meta.StudioComponent;
import io.jmix.flowui.kit.meta.StudioProperty;
import io.jmix.flowui.kit.meta.StudioPropertyType;
import io.jmix.flowui.kit.meta.StudioUiKit;

/**
 * The StudioComponents interface serves as a configuration container for integrating
 * and defining custom UI components within the Jmix platform. It provides metadata
 * annotations to specify the behavior, properties, and appearance of these components
 * in the Jmix Studio UI.
 *
 * The interface is annotated with @StudioUiKit, signaling its role as a part of the
 * Studio UI Kit extension framework, enabling the integration of custom components
 * into the Jmix design environment.
 *
 * The swagger method defines the "SwaggerUI" component configuration, specifying its
 * class implementation, category, XML element name, associated XML namespace, and
 * supported runtime properties.
 *
 * Key capabilities:
 * - Integration of Swagger UI into the Jmix UI using the "swagger-ui" XML element.
 * - Configurable properties for size, visibility, and specific functionality like providing a Swagger endpoint URL.
 * - Categorization to "Components" for use within the Jmix framework's Studio UI design tools.
 *
 * Customizable properties:
 * - Common attributes, such as `id` for component identification and `visible` to set visibility.
 * - Size attributes, such as `height`, `width`, `maxHeight`, and `maxWidth`, to determine the component's dimensions.
 * - Specific attributes, such as `url`, to define the endpoint for the Swagger UI.
 */
@StudioUiKit
public interface StudioComponents {
    // https://docs.jmix.io/jmix/flow-ui/vc/creating-components/integrating-into-jmix-ui.html
    @StudioComponent(
            name = "SwaggerUI",
            classFqn = "de.bytestore.hostinger.components.swagger.SwaggerUI",
            category = "Components",
            xmlElement = "swagger-ui",
            xmlns = "http://byte-store.de/schema/app-ui-components",
            xmlnsAlias = "app",
            properties = {
                    /* Common attributes */
                    @StudioProperty(xmlAttribute = "id", type = StudioPropertyType.COMPONENT_ID),
                    @StudioProperty(xmlAttribute = "visible", type = StudioPropertyType.BOOLEAN,
                            defaultValue = "true"),

                    /* Size attributes */
                    @StudioProperty(xmlAttribute = "height", type = StudioPropertyType.SIZE),
                    @StudioProperty(xmlAttribute = "width", type = StudioPropertyType.SIZE),
                    @StudioProperty(xmlAttribute = "maxHeight", type = StudioPropertyType.SIZE),
                    @StudioProperty(xmlAttribute = "maxWidth", type = StudioPropertyType.SIZE),
                    @StudioProperty(xmlAttribute = "minHeight", type = StudioPropertyType.SIZE),
                    @StudioProperty(xmlAttribute = "minWidth", type = StudioPropertyType.SIZE),

                    /* Specific attributes */
                    @StudioProperty(xmlAttribute = "url", type = StudioPropertyType.STRING),
            }

    )
    void swagger();
}
