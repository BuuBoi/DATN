package com.dnanh01.backend.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "sizes")
public class Size extends BaseClazz {
	@Column(name = "size_number", nullable = false)
	private Integer sizeNumber;
	/**
	 * relationship
	 * 1-n [shoes]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@OneToMany(mappedBy = "size", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "shoes")
	private Set<Shoe> shoes;
}
