package com.cjava.demodao.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import com.cjava.demodao.modelo.entidad.Persona;

public interface PersonaDAO extends CrudRepository<Persona, Long> {
}