package de.bytestore.swaggerui.view.apidocs;


import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.DefaultMainViewParent;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "api-docs", layout = DefaultMainViewParent.class)
@ViewController(id = "swagger_ApiDocs")
@ViewDescriptor(path = "api-docs.xml")
public class ApiDocs extends StandardView {
}