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
@Table(name = "conversations")
public class Conversation extends BaseClazz {

	@Column(name = "conversation_name", nullable = false)
	private String conversationName;

	private LocalDateTime startedAt;

	private LocalDateTime endedAt;

	private Double ratingScore;

	/**
	 * relationship
	 * n-1 [chatbots]
	 * n-1 [users]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "chatbot_id", nullable = false)
	private Chatbot chatbot;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
