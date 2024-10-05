package com.dnanh01.backend.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "carts")
public class Cart extends BaseClazz {

    @Column(name = "total_item", nullable = false)
    private Integer totalItem;

    @Column(name = "total_display_price", nullable = false)
    private Double totalDisplayPrice;

    @Column(name = "total_warehouse_price", nullable = false)
    private Double totalWarehousePrice;

    @Column(name = "total_discounted_price", nullable = false)
    private Double totalDiscountedPrice;

    /**
     * relationship
     * 1-n [cart_items]
     * 1-1 [users]
     * 
     * @author DNAnh01[Do Nguyen Anh]
     */
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "cart_items")
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
