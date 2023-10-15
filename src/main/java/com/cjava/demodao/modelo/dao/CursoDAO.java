package com.cjava.demodao.modelo.dao;

import com.cjava.demodao.modelo.entidad.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoDAO extends CrudRepository<Curso, Long> {
}
