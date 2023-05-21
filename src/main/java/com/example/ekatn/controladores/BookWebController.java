package com.example.ekatn.controladores;


import com.example.ekatn.modelo.Book;
import com.example.ekatn.servicios.BookServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookWebController {
    @Autowired // Inyección de Depencia
    private BookServicios servicio;

    @RequestMapping("/listarTodo")
    public String listarBooks (Model model) {

        List<Book> listaBooks = servicio.buscarTodo();
        System.out.println("LISTA DE books : " + listaBooks);
        model.addAttribute("listaBooks", listaBooks);
        return "/moduloBooks/listarTodo";
    }

    @RequestMapping("/nuevo")
    public String nuevaBook(Model model) {
        Book book = new Book ();
        model.addAttribute("book",book);
        return "/moduloBooks/nuevaBook";
    }


    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String crearBook(@ModelAttribute("book") Book book) {
        servicio.crear(book);
        return "redirect:/books/listarTodo";
    }

    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editarBook(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/moduloBooks/editarBook");
        Book book = servicio.buscarPorId(id);
        mav.addObject("book",book);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String elimnarBook(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/books/listarTodo";
    }


}
