package com.dnanh01.backend.model.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseClazz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public static String toSnakeCase(String str) {
        /**
         * Convert camel case to snake case
         *
         * @author DNAnh01[Do Nguyen Anh]
         */
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return str.replaceAll(regex, replacement).toLowerCase();
    }

    public static String getTableName(Class<?> clazz) {
        /**
         * Get table name from class name
         *
         * @author DNAnh01[Do Nguyen Anh]
         */
        return toSnakeCase(clazz.getSimpleName());
    }
}