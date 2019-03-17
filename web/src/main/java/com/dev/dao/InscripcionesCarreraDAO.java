package com.dev.dao;

import com.dev.model.InscripcionesCarrera;
import com.dev.model.InscripcionesCurso;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class InscripcionesCarreraDAO implements IInscripcionesCarreraDAO {

    private SessionFactory sf;

    public InscripcionesCarreraDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<InscripcionesCarrera> getListByAlumno(int identificador) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from inscripciones_carrera " +
                "where alumnocarrera.alumno=:identificador");
        query.setInteger("identificador", identificador);
        List<InscripcionesCarrera> obj = query.list();
        tx.commit();
        session.close();
        return obj;
    }
}
