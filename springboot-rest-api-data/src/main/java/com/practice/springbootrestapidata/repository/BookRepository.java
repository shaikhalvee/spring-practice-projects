package com.practice.springbootrestapidata.repository;

import com.practice.springbootrestapidata.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "book-path", collectionResourceRel = "book-resource")
public interface BookRepository extends JpaRepository<Book, Long> {
}
