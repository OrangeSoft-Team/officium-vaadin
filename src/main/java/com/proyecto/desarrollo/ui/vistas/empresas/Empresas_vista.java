package com.proyecto.desarrollo.ui.vistas.empresas;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.proyecto.desarrollo.ui.vistas.layout.MainLayout;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "empresas", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Empresas")

public class Empresas_vista extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public Empresas_vista() {
        addClassName("hello-world-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }

}
