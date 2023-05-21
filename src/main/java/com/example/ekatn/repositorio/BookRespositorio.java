package com.example.ekatn.repositorio;

import com.example.ekatn.modelo.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespositorio extends CrudRepository<Book, Integer> {
}
