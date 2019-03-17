package com.dev.dao;

import com.dev.model.Persona;
import com.dev.model.ProfesoresCurso;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProfesoresCursoDAO implements IProfesoresCursoDAO {

    private SessionFactory sf;

    public ProfesoresCursoDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Persona getByCurso(int identificador) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from profesores_curso where curso=:identificador");
        query.setInteger("identificador", identificador);
        ProfesoresCurso obj = (ProfesoresCurso) query.uniqueResult();
        tx.commit();
        session.close();
        return obj != null ? obj.getProfesor() : null;
    }
}