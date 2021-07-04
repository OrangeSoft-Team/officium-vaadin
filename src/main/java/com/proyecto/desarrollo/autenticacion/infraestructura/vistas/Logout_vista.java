package com.proyecto.desarrollo.autenticacion.infraestructura.vistas;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("logout")
@PageTitle("Logout | Officium")
public class Logout_vista extends Composite<VerticalLayout> {
    public Logout_vista() {
        UI.getCurrent().getPage().setLocation("login");
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
    }
}
