package com.datpham.miniblog.controller;


import io.tej.SwaggerCodgen.api.AuthorsApi;
import io.tej.SwaggerCodgen.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController implements AuthorsApi {
    @Override
    public ResponseEntity<Author> createAuthor(AuthorRequest authorRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Blog> createBlogByAuthorId(String authorId, BlogRequest blogRequestByAuthorId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> createContact(String authorId, ContactRequest contactRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Author> getAllAuthor() {
        return null;
    }

    @Override
    public ResponseEntity<BlogList> getAllBlogByAuthorId(String authorId) {
        return null;
    }

    @Override
    public ResponseEntity<ContactList> getAllContact(String authorId) {
        return null;
    }

    @Override
    public ResponseEntity<Author> getAuthorById(String authorId) {
        return null;
    }

    @Override
    public ResponseEntity<Blog> getBlogByAuthorId(String authorId, String blogId) {
        return null;
    }
}
