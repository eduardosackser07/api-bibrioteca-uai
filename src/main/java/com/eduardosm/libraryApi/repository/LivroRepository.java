package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.model.Autor;
import com.eduardosm.libraryApi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    //Query Method
    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    List<Livro> findByIsbn(String isbn);

    Livro findByTituloAndIsbn(String titulo, String isbn);


    //JPQL -> referencia as entidades e as propriedades
    //ou seja referenciar nas querys as entidades e nao as tabelas sql
    // no sql essa query seria select l.* from livro as l order by l.titulo
    @Query(" select l from Livro as l order by l.titulo ")
    List<Livro> listarTodosOrdenadoPorTitulo();

    /**
     * select a.*
     * from livro l
     * join autor a on a.id = l.id_autor
     */
    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutoresDosLivros();

    }

