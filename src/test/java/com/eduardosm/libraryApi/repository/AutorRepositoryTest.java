package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.model.Autor;
import com.eduardosm.libraryApi.model.GeneroLivro;
import com.eduardosm.libraryApi.model.Livro;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.eduardosm.libraryApi.repository.AutorRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    private HikariDataSource hikariDataSource;

    /*@Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;*/

    /*@Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("josefa");
        autor.setNacionalidade("russa");
        autor.setData(LocalDate.of(1959, 1,31));

        var autorSalvo = repository.save(autor);
        System.out.println("autor salvo: "+autorSalvo);
    }*/

   /* @Test
    public void atualizarTest(){
        var id = UUID.fromString("6de7c2cc-eb50-4459-9427-571fc7dc5368");

        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();

            System.out.println("Dados do autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setNacionalidade("porto alegre pae");

            repository.save(autorEncontrado);
        }

    }*/

    @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Contagem de autores: "+ repository.count());
    }

    @Test
    public void deletePorIdTest(){
        var id = UUID.fromString("6fec91ec-bd0b-490a-8456-77f22ccaf267");
        repository.deleteById(id);

        //metodo pra deletar por objeto:
        /*
        var autor = repository.findById(id).get();
        repository.delete(autor);
        */
    }

    @Test
    void salvarAutorComLivrosTest(){
        Autor autor = new Autor();
        autor.setNome("cleitao da padoca");
        autor.setNacionalidade("osasquense");
        autor.setData(LocalDate.of(1989, 1,31));

        Livro livro = new Livro();

        livro.setTitulo("como faser pao dahora");
        livro.setData_publicacao(LocalDate.of(2001, 3, 30));
        livro.setPreco(29.99);
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setIsbn("1234571");
        livro.setAutor(autor);

        Livro livro2 = new Livro();

        livro2.setTitulo("como faser pizza dahora");
        livro2.setData_publicacao(LocalDate.of(2002, 3, 30));
        livro2.setPreco(29.99);
        livro2.setGenero(GeneroLivro.CIENCIA);
        livro2.setIsbn("1234572");
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);

        livroRepository.saveAll(autor.getLivros());


    }
}

