package com.dev.action.inscripcionMateria;

import com.dev.dao.*;
import com.dev.model.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InscripcionMateriaAction extends ActionSupport implements Action, ModelDriven<Alumno>, ServletContextAware {
    private Alumno model = new Alumno();
    private Carrera carrera = new Carrera();
    private Curso curso = new Curso();
    private ServletContext ctx;
    private List list = new ArrayList();
    private List listCarrera = new ArrayList();
    private List listCurso = new ArrayList();

    public Carrera getCarrera() {
        return carrera;
    }

    public InscripcionMateriaAction setCarrera(Carrera carrera) {
        this.carrera = carrera;
        return this;
    }

    public Curso getCurso() {
        return curso;
    }

    public InscripcionMateriaAction setCurso(Curso curso) {
        this.curso = curso;
        return this;
    }

    public void setListCurso(List<Curso> listaCursos) {
        this.listCurso = listaCursos;
    }

    public List<InscripcionesCurso> getListCurso() {
        return listCurso;
    }

    public List getList() {
        return list;
    }

    public InscripcionMateriaAction setList(List list) {
        this.list = list;
        return this;
    }

    public List getListCarrera() {
        return listCarrera;
    }

    public void setListCarrera(List listCarrera) {
        this.listCarrera = listCarrera;
    }

    @Override
    public Alumno getModel() {
        return model;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.ctx = sc;
    }


    public String listar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        setList(objDAO.getList());
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        listar();

        return SUCCESS;
    }

    public String buscarCarrera() throws Exception {
        listar();
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        InscripcionesCarreraDAO inscripcionesCarreraDAO = new InscripcionesCarreraDAO(sf);
        setListCarrera(inscripcionesCarreraDAO.getListByAlumno(getModel().getIdentificador()));

        return SUCCESS;
    }

    public String buscarCurso() throws Exception {
        buscarCarrera();
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        CursoDAO cursoDAO = new CursoDAO(sf);
        setListCurso(cursoDAO.getListByCarrera(getCarrera().getIdentificador()));

        return SUCCESS;
    }

    public String aceptar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        if (getModel().getIdentificador() > 0) {
            if (getCarrera().getIdentificador() > 0) {
                if (getCurso().getIdentificador() > 0) {
                    InscripcionesCursoDAO objDAO = new InscripcionesCursoDAO(sf);
                    InscripcionesCurso obj = new InscripcionesCurso();
                    obj.setAlumno(getModel());
                    obj.setCurso(getCurso());
                    obj.setAlumnocurso(new AlumnoCurso(getModel().getIdentificador(), getCurso().getIdentificador()));
                    obj.setFechainscripcion(new Date());
                    obj.setNota(0);
                    objDAO.save(obj);
                    return SUCCESS;
                } else {
                    addFieldError("curso.identificador", "error.requerido");
                }
            } else {
                addFieldError("carrera.identificador", "error.requerido");
            }
        } else {
            addFieldError("model.identificador", "error.requerido");
        }
        return INPUT;
    }

    public String cancelar() throws Exception {
        listar();
        model = new Alumno();
        setCurso(new Curso());
        setCarrera(new Carrera());
        setListCarrera(new ArrayList());
        setListCurso(new ArrayList<Curso>());
        return SUCCESS;
    }
}
