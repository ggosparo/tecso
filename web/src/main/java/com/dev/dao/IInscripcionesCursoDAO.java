package com.dev.dao;

import com.dev.model.Curso;
import com.dev.model.InscripcionesCurso;
import com.dev.model.Persona;

import java.util.List;

public interface IInscripcionesCursoDAO {

    List<InscripcionesCurso> getListByAlumno(int identificador);

    List<InscripcionesCurso> getListByCurso(int identificador);

    void save(InscripcionesCurso obj);

}