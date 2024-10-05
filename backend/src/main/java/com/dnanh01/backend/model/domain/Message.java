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
@Table(name = "messages")
public class Message extends BaseClazz{

	@Column(name = "sender_type", nullable = false)
	private String senderType;

	@Column(name = "message_text", nullable = false)
	private String messageText;
	/**
	 * relationship
	 * n-1 [conversations]
	 * n-1 [users]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "conversation_id", nullable = false)
	private Conversation conversation;


	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
