package com.dnanh01.backend.model.domain;

import java.time.LocalDateTime;

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
@Table(name = "users_sessions")
public class UserSession extends BaseClazz {
	@Column(name = "token", nullable = false, unique = true)
	private String token;

	@Column(name = "expires_at", nullable = false)
	private LocalDateTime expiresAt;
	/**
	 * relationship
	 * n-1 [users]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
