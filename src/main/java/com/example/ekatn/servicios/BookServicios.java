package com.example.ekatn.servicios;


import com.example.ekatn.modelo.Book;
import com.example.ekatn.repositorio.BookRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServicios {

    @Autowired
    private BookRespositorio repositorio;

    public BookServicios(){
    }

    public List<Book> buscarTodo(){
        return (List<Book>) repositorio.findAll();
    }

    public Book actualizar(Book bookActualizar) {

        Book bookActual = repositorio.findById(bookActualizar.getIdBooks()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        bookActual.setNombre(bookActualizar.getNombre());
        bookActual.setAutor(bookActualizar.getAutor());

        Book bookActualizado = repositorio.save(bookActual); // registra en base de datos
        return bookActualizado;
    }

    public Book crear(Book book) {
        return repositorio.save(book);
    }

    public Book buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }


    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);

    }

}
