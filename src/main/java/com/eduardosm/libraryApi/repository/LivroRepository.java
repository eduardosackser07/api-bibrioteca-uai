package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
