package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.BlogEntity;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.repository.BlogRepository;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }

    public Blog createBlogByAuthorId(String authorId, BlogRequest request) {
        AuthorEntity authorEntity = authorRepository.getById(authorId);
        BlogEntity blogEntity =
    }



}
