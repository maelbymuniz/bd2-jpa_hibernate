package br.edu.ifpb.bd2.jpahibernate.controllers;

import br.edu.ifpb.bd2.jpahibernate.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    // FindAll

    // FindById
}
