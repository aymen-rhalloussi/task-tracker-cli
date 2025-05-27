package com.prjcts.app.core.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Task {

    private final Long id;
    private String description;
    private Status status;
    private final Date createdAt;
    private Date modifiedAt;

    public Task(String description) {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.description = description;
        this.status = Status.TO_DO;
        this.createdAt = new Date();
        this.modifiedAt = new Date();
    }

    public void setDescription(String description) {
        this.description = description;
        updateModificationDate();
    }

    public void setStatus(String status) throws Exception {
        if (Objects.equals(status, "in-progress")) {
            this.status = Status.IN_PROGRESS;
            updateModificationDate();
        }
        else if (Objects.equals(status, "done")) {
            this.status = Status.DONE;
            updateModificationDate();
        }
        else {
            throw new Exception("INVALID STATUS!");
        }
    }

    public void updateModificationDate() {
        this.modifiedAt = new Date();
    }

    @Override
    public String toString() {
        return "ID => " + getId() +
                "\nDescription => " + getDescription() +
                "\nStatus => " + getStatus() +
                "\nCreated at => " + getCreatedAt() +
                "\nModified at => " + getModifiedAt();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }
}
