package com.cjava.demodao.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjava.demodao.modelo.entidad.Persona;
import com.cjava.demodao.servicio.PersonaServicio;

@Controller
public class PersonaControlador {

    @Autowired
    private PersonaServicio personaServicio;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", personaServicio.getAll());
        return "index";
    }

    @GetMapping("/grabar/{id}")
    public String showSave(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("persona", personaServicio.get(id));
        } else {
            model.addAttribute("persona", new Persona());
        }
        return "grabar";
    }

    @PostMapping("/grabar")
    public String save(Persona persona, Model model) {
        personaServicio.save(persona);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id, Model model) {
        personaServicio.delete(id);

        return "redirect:/";
    }

}
