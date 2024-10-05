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
@Table(name = "knowledge_bases")
public class KnowledgeBase extends BaseClazz{

	@Column(name = "knowledge_base_name", nullable = false)
	private String knowledgeBaseName;

	@Column(name = "content_type", nullable = false)
	private String contentType;

	@Column(name = "file_path", nullable = false)
	private String filePath;

	@Column(name = "character_count", nullable = false)
	private Integer characterCount;

	@Column(name = "file_size", nullable = false)
	private Integer fileSize;
	/**
	 * relationship
	 * n-1 [chatbots]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "chatbot_id", nullable = false)
	private Chatbot chatbot;
}
