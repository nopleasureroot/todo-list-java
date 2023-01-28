import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Serializable {
    private String name;
    private Integer priority;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private TaskStatus status;

    public Task(String name, Integer priority, LocalDateTime createdAt, LocalDateTime deadline, TaskStatus status) {
        this.name = name;
        this.priority = priority;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }


    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name)
                && Objects.equals(priority, task.priority)
                && Objects.equals(createdAt, task.createdAt)
                && Objects.equals(deadline, task.deadline)
                && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority, createdAt, deadline, status);
    }
}
