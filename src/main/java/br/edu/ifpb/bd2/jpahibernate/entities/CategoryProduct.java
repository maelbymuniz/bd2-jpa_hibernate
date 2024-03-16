package br.edu.ifpb.bd2.jpahibernate.entities;

import br.edu.ifpb.bd2.jpahibernate.entities.pk.CategoryProductPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_categories_products")
@Data
@NoArgsConstructor
public class CategoryProduct {

    @EmbeddedId
    private CategoryProductPK id = new CategoryProductPK();

    public CategoryProduct(Category category, Product product) {
        id.setCategory(category);
        id.setProduct(product);
    }

}
