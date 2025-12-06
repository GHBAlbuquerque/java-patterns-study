package com.patterns.external.database.orm;

import com.patterns.external.database.id.CustomLockId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity(name = "Lock")
public class LockORM {

    @Id
    @CustomLockId
    @GeneratedValue
    private String id;

    @NotNull
    private String userId;

    @NotNull
    private String entityId;

    @NotNull
    private LocalDateTime expiresAt;

    public LockORM(String id, String userId, String entityId, LocalDateTime expiresAt) {
        this.id = id;
        this.userId = userId;
        this.entityId = entityId;
        this.expiresAt = expiresAt;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEntityId() {
        return entityId;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}
