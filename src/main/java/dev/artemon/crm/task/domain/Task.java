package dev.artemon.crm.task.domain;

import dev.artemon.crm.contact.domain.Contact;
import dev.artemon.crm.manager.domain.Manager;
import dev.artemon.crm.shared.ID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Task {
    private final ID<Task> id;
    private final ID<Contact> contactId;
    private ID<Manager> managerId;
    private String title;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime dueDate;
    private LocalDateTime completedAt;
    private boolean completed;

    @NotNull
    @Contract("_, _, _, _ -> new")
    public static Task createNewTask(ID<Contact> contactId, ID<Manager> managerId, String title, String description) {
        return new Task(ID.newId(), contactId, managerId, title, description, LocalDateTime.now(),
                null, null, null, false);
    }

    @NotNull
    @Contract("_, _, _, _, _, _, _, _, _, _ -> new")
    public static Task restore(ID<Task> id, ID<Contact> contactId, ID<Manager> managerId, String title,
                               String description, LocalDateTime createdAt, LocalDateTime updatedAt,
                               LocalDateTime dueDate, LocalDateTime completedAt, boolean completed) {
        return new Task(id, contactId, managerId, title, description,
                createdAt, updatedAt, dueDate, completedAt, completed);
    }


}
