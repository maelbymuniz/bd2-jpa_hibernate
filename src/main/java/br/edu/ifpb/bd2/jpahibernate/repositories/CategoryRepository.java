package br.edu.ifpb.bd2.jpahibernate.repositories;

import br.edu.ifpb.bd2.jpahibernate.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
