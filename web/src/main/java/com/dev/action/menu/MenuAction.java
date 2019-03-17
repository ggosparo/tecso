package com.dev.action.menu;

import com.dev.dao.AlumnoDAO;
import com.dev.dao.CursoDAO;
import com.dev.dao.PersonaDAO;
import com.dev.model.Persona;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuAction implements Action, ModelDriven<Persona>, ServletContextAware {

    private ServletContext ctx;
    private List list;
    private List personas;

    public List getPersonas() {
        return personas;
    }

    public MenuAction setPersonas(List personas) {
        this.personas = personas;
        return this;
    }

    public List getList() {
        return list;
    }

    public MenuAction setList(List list) {
        this.list = list;
        return this;
    }

    public String abmPersona() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        PersonaDAO objDAO = new PersonaDAO(sf);
        setList(objDAO.getList());
        return SUCCESS;
    }

    public String abmAlumno() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        setList(objDAO.getList());
        PersonaDAO perDAO = new PersonaDAO(sf);
        setPersonas(perDAO.getList());
        return SUCCESS;
    }

    public String reporteAcademico() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        setList(objDAO.getList());
        return SUCCESS;
    }

    public String reporteAsignatura() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        CursoDAO objDAO = new CursoDAO(sf);
        setList(objDAO.getList());
        return SUCCESS;
    }

    public String inscripcionMateria() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        setList(objDAO.getList());
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }

    @Override
    public Persona getModel() {
        return null;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.ctx = servletContext;
    }
}
