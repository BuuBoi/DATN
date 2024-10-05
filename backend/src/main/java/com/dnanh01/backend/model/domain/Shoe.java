package com.dnanh01.backend.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "shoes")
public class Shoe extends BaseClazz {

	@Column(name = "image_url", nullable = false)
	private String imageUrl;

	@Column(name = "shoe_name", nullable = false)
	private String shoeName;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity_in_stock", nullable = false)
	private Integer quantityInStock;

	@Column(name = "display_price", nullable = false)
	private Double displayPrice;

	@Column(name = "warehouse_price", nullable = false)
	private Double warehousePrice;

	@Column(name = "discounted_price")
	private Double discountedPrice;

	/**
	 * relationship
	 * 1-n [reviews, cart_items, order_items, shoes_promotions]
	 * n-1 [sizes, colors, brands]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */

	@OneToMany(mappedBy = "shoe", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "reviews")
	private Set<Review> reviews;

	@OneToMany(mappedBy = "shoe", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "cart_items")
	private List<CartItem> cartItems;

	@OneToMany(mappedBy = "shoe", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "order_items")
	private List<OrderItem> orderItems;

	@OneToMany(mappedBy = "shoe", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "shoes_promotions")
	private Set<ShoePromotion> shoePromotions;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "size_id", nullable = false)
	private Size size;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "color_id", nullable = false)
	private Color color;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
}
