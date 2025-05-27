package com.prjcts.app.core.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private final Task task = new Task("Test this task");

    @Test
    void allGood_Constructor() {
        Task t = new Task("A todo task");

        assertInstanceOf(Long.class, t.getId());
        assertEquals("A todo task", t.getDescription());
        assertEquals(Status.TO_DO, t.getStatus());
        assertInstanceOf(Date.class, t.getCreatedAt());
        assertInstanceOf(Date.class, t.getModifiedAt());
    }

    @Test
    void allGood_SetDescription() {
        task.setDescription("Test this task's description");

        assertEquals("Test this task's description", task.getDescription());
        assertNotSame(task.getCreatedAt(), task.getModifiedAt());
    }

    @Test
    void inProgress_SetStatus() {
        try {
            task.setStatus("in-progress");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(Status.IN_PROGRESS, task.getStatus());
        assertNotSame(task.getCreatedAt(), task.getModifiedAt());
    }

    @Test
    void done_SetStatus() {
        try {
            task.setStatus("done");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(Status.DONE, task.getStatus());
        assertNotSame(task.getCreatedAt(), task.getModifiedAt());
    }

    @Test
    void invalidStatus_SetStatus() {
        Exception exception =
                assertThrows(Exception.class, () -> {
                    task.setStatus("invalid-status");
                });

        assertEquals("INVALID STATUS!", exception.getMessage());
        assertEquals(task.getCreatedAt(), task.getModifiedAt());
    }
}
