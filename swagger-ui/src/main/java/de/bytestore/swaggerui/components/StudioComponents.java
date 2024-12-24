package de.bytestore.swaggerui.components;

import io.jmix.flowui.kit.meta.StudioComponent;
import io.jmix.flowui.kit.meta.StudioProperty;
import io.jmix.flowui.kit.meta.StudioPropertyType;
import io.jmix.flowui.kit.meta.StudioUiKit;

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
