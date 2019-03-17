package com.dev.action.alumno;

import com.dev.dao.AlumnoDAO;
import com.dev.dao.PersonaDAO;
import com.dev.model.Alumno;
import com.dev.model.Persona;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

public class AlumnoAction extends ActionSupport implements Action, ModelDriven<Alumno>, ServletContextAware {
    private Alumno model = new Alumno();
    private ServletContext ctx;
    private List list;
    private List personas;

    public List getPersonas() {
        return personas;
    }

    public AlumnoAction setPersonas(List personas) {
        this.personas = personas;
        return this;
    }

    public List getList() {
        return list;
    }

    public AlumnoAction setList(List list) {
        this.list = list;
        return this;
    }

    @Override
    public Alumno getModel() {
        return model;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.ctx = sc;
    }

    @Override
    public void validate() {
    }

    private boolean validar() {
        Boolean respuesta = null;
        if (getModel().getLegajo() < 1) {
            addFieldError("legajo", getText("error.requerido"));
            respuesta = false;
        }
        if (getModel().getPersona().getIdentificador() <= 0) {
            addFieldError("persona.identificador", getText("error.requerido"));
            respuesta = false;
        }
        return respuesta == null;
    }

    public String listar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        setList(objDAO.getList());
        PersonaDAO perDAO = new PersonaDAO(sf);
        setPersonas(perDAO.getList());
        return SUCCESS;
    }

    public String aceptar() throws Exception {
        if (this.validar()) {
            SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
            AlumnoDAO objDAO = new AlumnoDAO(sf);
            if (objDAO.save(getModel())) {
                cancelar();
                return SUCCESS;
            } else {
                addActionError(getText("error.noSePudoIngresarElRegistro"));
                listar();
                return INPUT;
            }
        } else {
            listar();
            return INPUT;
        }
    }

    public String cancelar() throws Exception {
        getModel().setLegajo(0);
        getModel().setPersona(null);
        getModel().setIdentificador(0);
        listar();
        return SUCCESS;
    }

    public String actualizar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        Alumno obj = objDAO.getByIdentificador(getModel().getIdentificador());
        if (obj == null) {
            addActionError(getText("error.identificadorNoEncontrado"));
        } else {
            getModel().setLegajo(obj.getLegajo());
            getModel().setPersona(obj.getPersona());
            getModel().setIdentificador(obj.getIdentificador());
        }
        listar();
        return SUCCESS;
    }

    public String borrar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        Alumno obj = objDAO.getByIdentificador(getModel().getIdentificador());
        if (obj == null) {
            addActionError(getText("error.identificadorNoEncontrado"));
        } else {
            objDAO.delete(obj);
        }
        cancelar();
        return SUCCESS;
    }
}
