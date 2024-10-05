package com.dnanh01.backend.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "orders")
public class Order extends BaseClazz {
	@Column(name = "order_date", nullable = false)
	private LocalDateTime orderDate;

	@Column(name = "delivery_date", nullable = false)
	private LocalDateTime deliveryDate;

	@Column(name = "status", nullable = false)
	private String status;

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
	 * n-1 [addresses]
	 * n-1 [users]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
