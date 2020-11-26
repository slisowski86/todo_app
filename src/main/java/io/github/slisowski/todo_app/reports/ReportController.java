package io.github.slisowski.todo_app.reports;


import io.github.slisowski.todo_app.model.Task;
import io.github.slisowski.todo_app.model.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final TaskRepository taskRepository;
    private final PersistedTaskEventRepository eventRepository;

    public ReportController(TaskRepository taskRepository, PersistedTaskEventRepository eventRepository) {
        this.taskRepository = taskRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/count/{id}")
    ResponseEntity<TaskWithChangedCount> readTaskWithCount(@PathVariable int id){
        return taskRepository.findById(id)
                .map(task -> new TaskWithChangedCount(task, eventRepository.findByTaskId(id)))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    private static class TaskWithChangedCount {
        public String description;
        public boolean done;
        public int changesCount;
         TaskWithChangedCount(Task task, List<PersistedTaskEvent> events) {
             description = task.getDescription();
             done = task.isDone();
             changesCount = events.size();
        }
    }
}
