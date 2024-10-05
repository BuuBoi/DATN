package com.dnanh01.backend.model.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "reviews")
public class Review extends BaseClazz {

	@Column(name = "rating", nullable = false)
	private Integer rating;

	@Column(name = "comment", nullable = false)
	private String comment;

	@Column(name = "heart_count", nullable = false)
	private Integer heartCount;

	/**
	 * relationship
	 * n-1 [shoes]
	 * n-1 [users]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "shoe_id", nullable = false)
	private Shoe shoe;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
