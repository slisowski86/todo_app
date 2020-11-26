package io.github.slisowski.todo_app.model.event;

import io.github.slisowski.todo_app.model.Task;

import java.time.Clock;

public class TaskUndone extends TaskEvent {
    TaskUndone(Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
