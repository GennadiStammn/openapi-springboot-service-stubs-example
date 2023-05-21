package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@Validated
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BookController implements com.example.springreactiveopenapicodegen.api.v1.BookApi {

    private BookService bookService;

    @Override
    public Mono<ResponseEntity<SuccessResponseDTO>> createBook(
            @Parameter(name = "BookDTO", description = "", required = true, schema = @Schema(description = ""))
            @Valid @RequestBody Mono<com.example.springreactiveopenapicodegen.dto.BookDTO> bookDTO,
            @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return bookDTO
                .map(
                        b -> ResponseEntity.created(URI.create("/api/v1/book/" + b.getId()))
                                .body(new SuccessResponseDTO().data(bookService.createBook(b)).message("book created Successfully"))
                );
    }

    @Override
    public Mono<ResponseEntity<SuccessResponseDTO>> deleteBook(
            @Parameter(name = "id", description = "", required = true, schema = @Schema(description = ""))
            @PathVariable("id") String id,
            @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return Mono.just(ResponseEntity
                .ok()
                .body(new SuccessResponseDTO().data(bookService.deleteBook(id)).message("Book deleted Successfully")));
    }

    @Override
    public Mono<ResponseEntity<SuccessResponseDTO>> getAllBook(
            @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return Mono.just(ResponseEntity
                .ok()
                .body(new SuccessResponseDTO().data(bookService.getAllBook()).message("result found")));
    }

    @Override
    public Mono<ResponseEntity<SuccessResponseDTO>> getOneBook(
            @Parameter(name = "id", description = "", required = true, schema = @Schema(description = ""))
            @PathVariable("id") String id,
            @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return Mono.just(ResponseEntity
                .ok()
                .body(new SuccessResponseDTO().data(bookService.getOneBook(id)).message("result found")));
    }

    @Override
    public Mono<ResponseEntity<SuccessResponseDTO>> updateBook(
            @Parameter(name = "id", description = "", required = true, schema = @Schema(description = ""))
            @PathVariable("id") String id,
            @Parameter(name = "BookDTO", description = "", required = true, schema = @Schema(description = ""))
            @Valid @RequestBody Mono<com.example.springreactiveopenapicodegen.dto.BookDTO> bookDTO,
            @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return bookDTO
                .map(b -> ResponseEntity.created(URI.create("/api/v1/book/" + b.getId()))
                        .body(new SuccessResponseDTO().data(bookService.updateBook(b)).message("book updated Successfully")));
    }

}
