package br.edu.ifpb.bd2.jpahibernate.entities;

import br.edu.ifpb.bd2.jpahibernate.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.quantity = productDTO.quantity();
        this.price = productDTO.price();
        this.available = productDTO.available();
    }

}
