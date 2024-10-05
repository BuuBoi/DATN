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
@Table(name = "users")
public class User extends BaseClazz {

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "display_name", nullable = false)
	private String displayName;

	@Column(name = "avatar_url")
	private String avatarUrl;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "payment_information")
	private String paymentInformation;

	@Column(name = "is_verified", nullable = false)
	private boolean isVerified;

	/**
	 * relationship
	 * 1-n [messages, chatbots, conversations, orders, addresses, reviews,
	 * users_sessions]
	 * 1-1 [carts]
	 * n-1 [roles]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "messages")
	private Set<Message> messages;


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "chatbots")
	private List<Chatbot> chatbots;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "conversations")
	private List<Conversation> conversations;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "orders")
	private List<Order> orders;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "addresses")
	private List<Address> addresses;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "reviews")
	private Set<Review> reviews;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "users_sessions")
	private List<UserSession> userSessions;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart cart;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
}
