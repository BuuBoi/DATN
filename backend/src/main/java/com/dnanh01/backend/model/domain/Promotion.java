package com.dnanh01.backend.model.domain;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
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
@Table(name = "promotions")
public class Promotion extends BaseClazz {

	@Column(name = "promotion_name", nullable = false)
	private String promotionName;

	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDateTime endDate;

	@Column(name = "discount_percent", nullable = false)
	private Integer discountPercent;

	/**
	 * relationship
	 * 1-n [shoes_promotions]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */

	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "shoes_promotions")
	private Set<ShoePromotion> shoePromotions;
}
