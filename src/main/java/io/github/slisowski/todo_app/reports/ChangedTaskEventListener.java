package io.github.slisowski.todo_app.reports;

import io.github.slisowski.todo_app.model.event.TaskDone;
import io.github.slisowski.todo_app.model.event.TaskEvent;
import io.github.slisowski.todo_app.model.event.TaskUndone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ChangedTaskEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ChangedTaskEventListener.class);

    private final PersistedTaskEventRepository repository;

    public ChangedTaskEventListener(PersistedTaskEventRepository repository) {
        this.repository = repository;
    }


    @EventListener
    public void on(TaskDone event) {
        logger.info("Got " + event);
        repository.save(new PersistedTaskEvent(event));

    }



    @EventListener
    public void on(TaskUndone event) {
        logger.info("Got " + event);

    }

    private void onChanged(final TaskEvent event){
        logger.info("Got " + event);
        repository.save(new PersistedTaskEvent(event));
    }


}
