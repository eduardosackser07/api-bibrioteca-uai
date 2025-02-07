package com.eduardosm.libraryApi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Getter
@Setter
public class Livro {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String isbn;

    @Column
    private String titulo;

    @Column
    private LocalDate data_publicacao;

    @Enumerated(EnumType.STRING)
    @Column
    private GeneroLivro genero;

    @Column
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
}
