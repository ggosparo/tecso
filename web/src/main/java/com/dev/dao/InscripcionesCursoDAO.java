package com.dev.dao;

import com.dev.model.Curso;
import com.dev.model.InscripcionesCurso;
import com.dev.model.Persona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InscripcionesCursoDAO implements IInscripcionesCursoDAO {

    private SessionFactory sf;

    public InscripcionesCursoDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<InscripcionesCurso> getListByAlumno(int identificador) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from inscripciones_curso " +
                "where alumnocurso.alumno=:identificador");
        query.setInteger("identificador", identificador);
        List<InscripcionesCurso> obj = query.list();
        tx.commit();
        session.close();
        return obj;
    }

    @Override
    public List<InscripcionesCurso> getListByCurso(int identificador) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from inscripciones_curso " +
                "where alumnocurso.curso=:identificador");
        query.setInteger("identificador", identificador);
        List<InscripcionesCurso> obj = query.list();
        tx.commit();
        session.close();
        return obj;
    }

    @Override
    public void save(InscripcionesCurso obj) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(obj);
        tx.commit();
        session.close();
    }
}
