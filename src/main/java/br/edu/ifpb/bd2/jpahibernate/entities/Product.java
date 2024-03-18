package br.edu.ifpb.bd2.jpahibernate.entities;

import br.edu.ifpb.bd2.jpahibernate.dtos.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "tb_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer quantity;
    private Double price;
    private String description;
    private boolean available;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.quantity = productDTO.quantity();
        this.price = productDTO.price();
        this.description = productDTO.description();
        this.category = productDTO.category();
        this.available = productDTO.available();
    }

}
