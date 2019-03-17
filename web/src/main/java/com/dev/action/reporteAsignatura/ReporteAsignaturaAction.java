package com.dev.action.reporteAsignatura;

import com.dev.dao.*;
import com.dev.model.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReporteAsignaturaAction implements Action, ModelDriven<Curso>, ServletContextAware {
    private Curso model = new Curso();
    private ServletContext ctx;
    private List list;
    private List<InscripcionesCurso> listaCursos;
    private Persona profesor;

    public Persona getProfesor() {
        return profesor;
    }

    public ReporteAsignaturaAction setProfesor(Persona profesor) {
        this.profesor = profesor;
        return this;
    }

    public void setListaCursos(List<InscripcionesCurso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public String getProfesorNombreApellido() {
        return getProfesor() != null ? getProfesor().getNombre() + " " + getProfesor().getApellido() : "";
    }

    public List<InscripcionesCurso> getListaCursos() {
        return listaCursos;
    }

    public List getList() {
        return list;
    }

    public ReporteAsignaturaAction setList(List list) {
        this.list = list;
        return this;
    }

    @Override
    public Curso getModel() {
        return model;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.ctx = sc;
    }


    public String listar() throws Exception {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        CursoDAO objDAO = new CursoDAO(sf);
        setList(objDAO.getList());
        return SUCCESS;
    }


    @Override
    public String execute() throws Exception {
        listar();
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");

        InscripcionesCursoDAO inscripcionesCursoDAO = new InscripcionesCursoDAO(sf);
        setListaCursos(inscripcionesCursoDAO.getListByCurso(getModel().getIdentificador()));

        ProfesoresCursoDAO profesoresCursoDAO = new ProfesoresCursoDAO(sf);
        setProfesor(profesoresCursoDAO.getByCurso(getModel().getIdentificador()));

        return SUCCESS;
    }

}
