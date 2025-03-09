package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.model.Autor;
import com.eduardosm.libraryApi.model.GeneroLivro;
import com.eduardosm.libraryApi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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


    //named parameters -> parametros nomeados
    @Query("select l from Livro l where l.genero = :generoParametro order by :paramOrdenacao")
    List<Livro> findByGenero(
            @Param("generoParametro") GeneroLivro generoLivro,
            @Param("paramOrdenacao") String nomePropriedade );


    @Query("select l from Livro l where l.genero = ?1 order by ?2")
    List<Livro> findByGeneroPositionalParam(
            GeneroLivro generoLivro,
            String nomePropriedade);

    @Modifying
    @Transactional
    @Query("delete from Livro where genero = ?1")
    void deleteByGenero(GeneroLivro genero);

    @Modifying
    @Transactional
    @Query("update Livro set data_publicacao = ?1")
    void updateData_publicacao(LocalDate novaData);

    }


