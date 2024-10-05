package com.dnanh01.backend.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "shoe_promotions")
public class ShoePromotion extends BaseClazz{
	/**
	 * relationship
	 * n-1 [shoes]
	 * n-1 [promotions]
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "shoe_id", nullable = false)
	private Shoe shoe;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "promotion_id", nullable = false)
	private Promotion promotion;
}
