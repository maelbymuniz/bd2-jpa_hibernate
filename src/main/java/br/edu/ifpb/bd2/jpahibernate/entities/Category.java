package br.edu.ifpb.bd2.jpahibernate.entities;

import br.edu.ifpb.bd2.jpahibernate.dtos.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * OBS: Criei a Categoria como classe e não como Enum,
 * para que possamos usar a anotation '@ManyToMany' com Product
 */

@Entity
@Table(name = "tb_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(CategoryDTO categoryDTO) {
        this.name = categoryDTO.name();
    }
}
