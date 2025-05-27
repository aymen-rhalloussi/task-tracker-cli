package com.prjcts.app.core.model;

import java.util.Date;
import java.util.UUID;

public class Task {

    private Long id;
    private String description;
    private Status status;
    private Date createdAt;
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

    public void setStatus(String status) {
        if (status == "in-progress") {
            this.status = Status.IN_PROGRESS;
            updateModificationDate();
        }
        else if (status == "done") {
            this.status = Status.DONE;
            updateModificationDate();
        }
        else {

        }
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
}
