package com.dnanh01.backend.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "cart_items")
public class CartItem extends BaseClazz {

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "display_price", nullable = false)
    private Double displayPrice;

    @Column(name = "warehouse_price", nullable = false)
    private Double warehousePrice;

    @Column(name = "discounted_price", nullable = false)
    private Double discountedPrice;
    /**
     * relationship
     * n-1 [carts]
     * n-1 [shoes]
     *
     * @author DNAnh01[Do Nguyen Anh]
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "shoe_id")
    private Shoe shoe;
}
