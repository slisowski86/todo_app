package io.github.slisowski.todo_app.model.projection;

import io.github.slisowski.todo_app.model.Task;
import io.github.slisowski.todo_app.model.TaskGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GroupReadModelTest {
    @Test
    @DisplayName("should create no deadline for group when no task deadlines")
    void constructor_noDeadlines_createsNullDeadline(){

        var source = new TaskGroup();
        source.setDescription("foo");
        source.setTasks(Set.of(new Task("bar", null)));

        //when

        var result = new GroupReadModel(source);

        //thent

        assertThat(result).hasFieldOrPropertyWithValue("deadline", null);

    }

}