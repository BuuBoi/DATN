package com.dnanh01.backend.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "chatbots")
public class Chatbot extends BaseClazz {

    @Column(name = "chatbot_name", nullable = false)
    private String chatbotName;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "is_public", nullable = false)
    private boolean isPublic;

    @Column(name = "description")
    private String description;

    @Column(name = "temperature", nullable = false)
    private Double temperature;

    @Column(name = "max_token", nullable = false)
    private Integer maxToken;

    @Column(name = "prompt", nullable = false)
    private String prompt;

    /**
     * relationship
     * 1-n [knowledge_bases, conversations]
     * n-1 [users]
     * 
     * @author DNAnh01[Do Nguyen Anh]
     */

    @OneToMany(mappedBy = "chatbot", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "knowledge_bases")
    private List<KnowledgeBase> knowledgeBases;

    @OneToMany(mappedBy = "chatbot", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "conversations")
    private List<Conversation> conversations;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
