package com.dev.action.reporteAcademico;

import com.dev.dao.AlumnoDAO;
import com.dev.dao.InscripcionesCursoDAO;
import com.dev.dao.PersonaDAO;
import com.dev.model.Alumno;
import com.dev.model.Carrera;
import com.dev.model.Curso;
import com.dev.model.InscripcionesCurso;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReporteAcademicoAction implements Action, ModelDriven<Alumno>, ServletContextAware {
    private Alumno model = new Alumno();
    private ServletContext ctx;
    private double notaaprobacion = 6;
    private List list;
    private List<InscripcionesCurso> listaCursos;
    private HashMap<Carrera, Double> promedios;

    public List getList() {
        return list;
    }

    public ReporteAcademicoAction setList(List list) {
        this.list = list;
        return this;
    }

    public void setPromedios(HashMap<Carrera, Double> promedios) {
        this.promedios = promedios;
    }

    public HashMap<Carrera, Double> getPromedios() {
        return promedios;
    }

    public double getNotaaprobacion() {
        return notaaprobacion;
    }

    public ReporteAcademicoAction setNotaaprobacion(double notaaprobacion) {
        this.notaaprobacion = notaaprobacion;
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

    public ReporteAcademicoAction setListaCursos(List<InscripcionesCurso> listaCursos) {
        this.listaCursos = listaCursos;
        return this;
    }

    public List<InscripcionesCurso> getListaCursos() {
        return listaCursos;
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
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        AlumnoDAO objDAO = new AlumnoDAO(sf);
        model = objDAO.getByIdentificador(getModel().getIdentificador());

        InscripcionesCursoDAO inscripcionesCursoDAO = new InscripcionesCursoDAO(sf);
        setListaCursos(inscripcionesCursoDAO.getListByAlumno(getModel().getIdentificador()));
        // caculo promedio
        Set<Carrera> carreras = new HashSet<Carrera>();
        for (InscripcionesCurso c : getListaCursos()) {
            carreras.add(c.getCurso().getCarrera());
        }
        HashMap<Carrera, Double> promedio = new HashMap<Carrera, Double>();
        for (Carrera c : carreras) {
            // utilizo un bigdecimal porque el double no es preciso
            BigDecimal bd = new BigDecimal(0);
            int cantidad = 0;
            for (InscripcionesCurso ic : getListaCursos()) {
                if (c.equals(ic.getCurso().getCarrera())) {
                    bd = bd.add(new BigDecimal(ic.getNota()));
                    cantidad++;
                }
            }
            promedio.put(c, bd.divide(new BigDecimal(cantidad), 2, BigDecimal.ROUND_FLOOR).doubleValue());
        }
        setPromedios(promedio);

        return SUCCESS;
    }

}
