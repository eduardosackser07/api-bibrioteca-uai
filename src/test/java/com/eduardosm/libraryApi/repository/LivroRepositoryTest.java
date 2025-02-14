package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.model.Autor;
import com.eduardosm.libraryApi.model.GeneroLivro;
import com.eduardosm.libraryApi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest(){
        Livro livro = new Livro();

        livro.setTitulo("harry penis e o caraio secreto");
        livro.setData_publicacao(LocalDate.of(1997, 10, 31));
        livro.setPreco(59.99);
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setIsbn("1234568");

        Autor autor = autorRepository.findById(
                UUID.fromString("6de7c2cc-eb50-4459-9427-571fc7dc5368"))
                .orElse(null);

        livro.setAutor(autor);

        repository.save(livro);


    }

    @Test
    void salvarCascadeTest(){
        //pra essa funcao funcionar tem q ter a opçao cascade no manyToOne da classe livro.
        Livro livro = new Livro();

        livro.setTitulo("harry cock and the order of phoenix");
        livro.setData_publicacao(LocalDate.of(1999, 12, 31));
        livro.setPreco(59.99);
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setIsbn("1234569");

        Autor autor = new Autor();
        autor.setNome("jk sucking");
        autor.setNacionalidade("portuguesa");
        autor.setData(LocalDate.of(1970, 7,31));

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void salvarLivroEautorSemCascade(){
        Livro livro = new Livro();

        livro.setTitulo("harry cock and the order of penis");
        livro.setData_publicacao(LocalDate.of(1998, 9, 30));
        livro.setPreco(59.99);
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setIsbn("1234570");

        Autor autor = new Autor();
        autor.setNome("jk fucking");
        autor.setNacionalidade("portuguesa");
        autor.setData(LocalDate.of(1970, 7,31));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void atualizarAutorDoLivro(){
        UUID id = UUID.fromString("e6a6732d-349f-4f2e-ac85-03460d24a36f");
        var livroParaAtualizar = repository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("8db7558a-6106-4d6e-a32d-d9fed4dc0716");
        Autor autorAtualizado = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(autorAtualizado);

        repository.save(livroParaAtualizar);
    }

    @Test
    void deletarLivro(){
        UUID id = UUID.fromString("bc862c3b-5401-471b-9d67-0b776d5b13c3");
        repository.deleteById(id);
    }

    @Test
    @Transactional
    void buscarLivroTest(){
        UUID id = UUID.fromString("d5055d72-637d-4383-9d31-256013d28464");

        Livro livro = repository.findById(id).orElse(null);

        System.out.print("Livro: "+ livro.getTitulo()+"\n");

        System.out.println("Autor: "+ livro.getAutor().getNome());
    }
}