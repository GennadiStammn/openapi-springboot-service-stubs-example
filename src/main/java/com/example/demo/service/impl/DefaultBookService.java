package com.example.demo.service.impl;

import com.example.springreactiveopenapicodegen.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultBookService implements com.example.demo.service.BookService {


    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        return bookDTO;
    }

    @Override
    public BookDTO deleteBook(String id) {
        return null;
    }

    @Override
    public List<BookDTO> getAllBook() {
        return Collections.emptyList();
    }

    @Override
    public BookDTO getOneBook(String id) {
        return new BookDTO("some title", "ISBN111111").id(id);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        return bookDTO;
    }
}
