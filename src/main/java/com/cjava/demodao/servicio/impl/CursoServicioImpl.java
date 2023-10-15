package com.cjava.demodao.servicio.impl;

import com.cjava.demodao.comunes.impl.GenericoServicioImpl;
import com.cjava.demodao.modelo.dao.CursoDAO;
import com.cjava.demodao.modelo.entidad.Curso;
import com.cjava.demodao.servicio.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServicioImpl extends GenericoServicioImpl<Curso, Long> implements CursoServicio {

    @Autowired
    private CursoDAO cursoDAO;

    @Override
    public CrudRepository<Curso, Long> getDao() {
        return cursoDAO;
    }
}
