package com.eduardosm.libraryApi.controller;

import com.eduardosm.libraryApi.model.Autor;

import java.time.LocalDate;

public record AutorDTO(String nome, LocalDate data, String nacionalidade) {

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setData(this.data);
        autor.setNacionalidade(this.nacionalidade);

        return autor;
    }

}
