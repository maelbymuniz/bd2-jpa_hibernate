package br.edu.ifpb.bd2.jpahibernate.services;

import br.edu.ifpb.bd2.jpahibernate.dtos.CategoryDTO;
import br.edu.ifpb.bd2.jpahibernate.dtos.ProductDTO;
import br.edu.ifpb.bd2.jpahibernate.entities.Category;
import br.edu.ifpb.bd2.jpahibernate.entities.Product;
import br.edu.ifpb.bd2.jpahibernate.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Optional<CategoryDTO> create(CategoryDTO request) {
        var product = new Category(request);
        repository.saveAndFlush(product);

        CategoryDTO response = new CategoryDTO(product.getId(), product.getName());

        return Optional.of(response);
    }

    public List<CategoryDTO> findAll() {
        List<Category> categories = repository.findAll();
        List<CategoryDTO> responses = new ArrayList<>();

        // Isso equivale a um ForEach "normal"
        categories.forEach(category -> {
            CategoryDTO response = new CategoryDTO(category);
            responses.add(response);
        });

        return responses;
    }

    public Optional<CategoryDTO> findById(Long id) {
        Optional<Category> category = repository.findById(id);
        CategoryDTO categoryDTO = new CategoryDTO(category.get());
        return Optional.of(categoryDTO);
    }

    public Optional<CategoryDTO> update(Long id, CategoryDTO request) {
        Optional<Category> category = repository.findById(id);

        if (category.isPresent()) {
            category.get().setName(request.name());
            repository.saveAndFlush(category.get());
            CategoryDTO CategoryDTO = new CategoryDTO(category.get());
            return Optional.of(CategoryDTO);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        Optional<Category> category = repository.findById(id);

        if (category.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;

    }
}
