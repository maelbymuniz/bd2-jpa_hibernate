package br.edu.ifpb.bd2.jpahibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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

    //private Set<Product> products = new HashSet<>();

}
