package com.cjava.demodao.controlador;

import com.cjava.demodao.modelo.entidad.Curso;
import com.cjava.demodao.servicio.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CursoControlador {

    @Autowired
    private CursoServicio cursoServicio;

    @RequestMapping("/curso")
    public String index(Model model){
        model.addAttribute("list",cursoServicio.getAll());
        return "curso/index";
    }

    @GetMapping("/curso/grabar/{id}")
    public String showSave(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("curso", cursoServicio.get(id));
        } else {
            model.addAttribute("curso", new Curso());
        }
        return "curso/grabar";
    }

    @PostMapping("/curso/grabar")
    public String save(Curso curso, Model model) {
        cursoServicio.save(curso);
        return "redirect:/curso/";
    }

    @GetMapping("/curso/eliminar/{id}")
    public String delete(@PathVariable Long id, Model model) {
        cursoServicio.delete(id);

        return "redirect:/curso/";
    }
}
