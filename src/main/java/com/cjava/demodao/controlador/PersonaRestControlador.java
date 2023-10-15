package com.cjava.demodao.controlador;

import com.cjava.demodao.modelo.entidad.Persona;
import com.cjava.demodao.servicio.PersonaServicio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/persona/")
public class PersonaRestControlador {

    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping(value = "/all", produces = { "application/json" })
    public @ResponseBody List<Persona> all(Model model) {
        return personaServicio.getAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> buscarById(@PathVariable("id") long id) {
        Persona persona = personaServicio.get(id);

        if (persona != null) {
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @RequestMapping("/test")
    public ResponseEntity<JsonNode> get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree("{ \"nombre\": \"Ana María\", \"apellido\": \"Paz Sanz\",\"direccion\": \"Av. La Marina 321\",\"telefono\": \"999112233\"}");
        return ResponseEntity.ok(json);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarById(@PathVariable("id") long id) {
        Persona persona = personaServicio.get(id);

        if (persona != null) {
            personaServicio.delete(id);
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Persona("(no encontrado)", "", "", ""),
                    HttpStatus.NOT_FOUND);
        }
    }
    // Crear una persona Nueva
    @PostMapping("/grabar")
    public ResponseEntity<Persona> grabarPersona(@RequestBody Persona persona) {
        try {
            Persona grabado = personaServicio.save( persona );
            return new ResponseEntity<>(grabado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Actualizar datos de una persona que ya Existe en la tabla Persona de la BD
    @PutMapping("/grabar/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable("id") long id, @RequestBody Persona persona) {
        Persona personaData = personaServicio.get(id);

        if (personaData != null) {
            Persona _Persona = personaData;
            _Persona.setNombre(persona.getNombre());
            _Persona.setApellido(persona.getApellido());
            _Persona.setTelefono(persona.getTelefono());
            _Persona.setDireccion(persona.getDireccion());
            return new ResponseEntity<>(personaServicio.save(_Persona), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
