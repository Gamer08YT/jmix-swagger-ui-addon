package de.bytestore.swaggerui.view.apidocs;


import com.vaadin.flow.router.Route;
import de.bytestore.swaggerui.components.swagger.SwaggerUI;
import io.jmix.flowui.view.*;

@Route(value = "api-docs", layout = DefaultMainViewParent.class)
@ViewController(id = "swagger_ApiDocs")
@ViewDescriptor(path = "api-docs.xml")
public class ApiDocs extends StandardView {

    @ViewComponent("swagger")
    private SwaggerUI swagger;


    @Subscribe
    public void onInit(final InitEvent event) {
        swagger.setUrls("/rest/docs/interna", "/rest/docs/openapi.json", "/rest/docs/openapiDetailed.json");
    }

}