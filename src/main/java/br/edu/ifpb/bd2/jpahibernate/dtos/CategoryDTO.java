package br.edu.ifpb.bd2.jpahibernate.dtos;

import br.edu.ifpb.bd2.jpahibernate.entities.Category;

public record CategoryDTO(Long id, String name) {
    public CategoryDTO(Category category) {
        this(category.getId(), category.getName());
    }
}
