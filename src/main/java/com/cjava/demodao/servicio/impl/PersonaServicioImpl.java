package com.cjava.demodao.servicio.impl;

import com.cjava.demodao.comunes.impl.GenericoServicioImpl;
import com.cjava.demodao.modelo.dao.PersonaDAO;
import com.cjava.demodao.modelo.entidad.Persona;
import com.cjava.demodao.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicioImpl extends GenericoServicioImpl<Persona, Long> implements PersonaServicio {

    @Autowired
    private PersonaDAO personaDao;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaDao;
    }

}