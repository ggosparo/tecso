package com.dev.dao;

import com.dev.model.Curso;
import com.dev.model.InscripcionesCurso;

import java.util.List;

public interface ICursoDAO {

    List<Curso> getList();

    List<Curso> getListByCarrera(int identificador);
}