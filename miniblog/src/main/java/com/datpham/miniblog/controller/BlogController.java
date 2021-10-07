package com.datpham.miniblog.controller;

import io.tej.SwaggerCodgen.api.BlogsApi;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import org.springframework.http.ResponseEntity;

public class BlogController implements BlogsApi {
//

    @Override
    public ResponseEntity<BlogList> getAllBlog() {
        return null;
    }

    @Override
    public ResponseEntity<Blog> getBlogById(String blogId) {
        return null;
    }
}
