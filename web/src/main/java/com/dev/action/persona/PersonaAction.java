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

public class PersonaAction extends ActionSupport implements Action, ModelDriven<Persona>, ServletContextAware {
    private Persona model = new Persona();
    private ServletContext ctx;
    private List list;

    public List getList() {
        return list;
    }

    public PersonaAction setList(List list) {
        this.list = list;
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

    @Override
    public void validate() {
    }

    private boolean validar() {
        Boolean respuesta = null;
        if (getModel().getDocumento() < 1) {
            addFieldError("documento", getText("error.requerido"));
            respuesta = false;
        }
        if (getModel().getNombre().trim().length() < 2) {
            addFieldError("nombre", getText("error.requerido"));
            respuesta = false;
        }
        if (getModel().getApellido().trim().length() < 2) {
            addFieldError("apellido", getText("error.requerido"));
            respuesta = false;
        }
        if (getModel().getDireccion().trim().length() < 2) {
            addFieldError("direccion", getText("error.requerido"));
            respuesta = false;
        }
        if (getModel().getFechanac() == null || getModel().getFechanac() == new Date()) {
            addActionError(getText("error.requerido"));
            respuesta = false;
        }
        return respuesta == null;
    }

    public String listar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        PersonaDAO objDAO = new PersonaDAO(sf);
        setList(objDAO.getList());
        return SUCCESS;
    }

    public String aceptar() throws Exception {
        if (this.validar()) {
            SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
            PersonaDAO objDAO = new PersonaDAO(sf);
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
        getModel().setNombre("");
        getModel().setApellido("");
        getModel().setDireccion("");
        getModel().setTipodoc("");
        getModel().setDocumento(0);
        getModel().setFechanac(null);
        getModel().setIdentificador(0);
        listar();
        return SUCCESS;
    }

    public String actualizar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        PersonaDAO objDAO = new PersonaDAO(sf);
        Persona obj = objDAO.getByIdentificador(getModel().getIdentificador());
        if (obj == null) {
            addActionError(getText("error.identificadorNoEncontrado"));
        } else {
            getModel().setNombre(obj.getNombre());
            getModel().setApellido(obj.getApellido());
            getModel().setDireccion(obj.getDireccion());
            getModel().setTipodoc(obj.getTipodoc());
            getModel().setDocumento(obj.getDocumento());
            getModel().setFechanac(obj.getFechanac());
            getModel().setIdentificador(obj.getIdentificador());
        }
        listar();
        return SUCCESS;
    }

    public String borrar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        PersonaDAO objDAO = new PersonaDAO(sf);
        Persona obj = objDAO.getByIdentificador(getModel().getIdentificador());
        if (obj == null) {
            addActionError(getText("error.identificadorNoEncontrado"));
        } else {
            objDAO.delete(obj);
        }
        cancelar();
        return SUCCESS;
    }
}
