package com.dev.dao;

import com.dev.model.InscripcionesCarrera;
import com.dev.model.InscripcionesCurso;

import java.util.List;

public interface IInscripcionesCarreraDAO {

    List<InscripcionesCarrera> getListByAlumno(int identificador);

}