package com.dev.action.persona;

import com.dev.dao.PersonaDAO;
import com.dev.model.Persona;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

public class PersonaJSONAction implements Action, ModelDriven<Persona>, ServletContextAware {
    private Persona model = new Persona();
    private String term;
    private ServletContext ctx;
    private List list;

    public List getList() {
        return list;
    }

    public Persona getList(int position) {
        return (Persona) getList().get(position);
    }

    public PersonaJSONAction setList(List list) {
        this.list = list;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public PersonaJSONAction setTerm(String term) {
        this.term = term;
        return this;
    }

    @Override
    public Persona getModel() {
        return model;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.ctx = sc;
    }

    public String buscarNombreJSON() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        PersonaDAO objDAO = new PersonaDAO(sf);
        setList(objDAO.getByNombreApellido(getTerm()));
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }
}
