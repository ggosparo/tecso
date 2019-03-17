package com.dev.dao;

import com.dev.model.Alumno;
import com.dev.model.Curso;
import com.dev.model.Persona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements ICursoDAO {

    private SessionFactory sf;

    public CursoDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Curso> getList() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String consulta = "  from Curso";
        Query query = session.createQuery(consulta);
        List<Curso> obj = query.list();
        tx.commit();
        session.close();
        if (obj != null) {
            return obj;
        } else {
            return new ArrayList<Curso>();
        }
    }

    @Override
    public List<Curso> getListByCarrera(int identificador) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String consulta = "  from Curso where carrera=:identificador";
        Query query = session.createQuery(consulta);
        query.setInteger("identificador", identificador);
        List<Curso> obj = query.list();
        tx.commit();
        session.close();
        if (obj != null) {
            return obj;
        } else {
            return new ArrayList<Curso>();
        }
    }
}
