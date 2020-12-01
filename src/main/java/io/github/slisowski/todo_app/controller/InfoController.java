package io.github.slisowski.todo_app.controller;


import io.github.slisowski.todo_app.TaskConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/info")
class InfoController {
    private DataSourceProperties dataSource;
    private TaskConfigurationProperties myProp;

    InfoController(final DataSourceProperties dataSource, final TaskConfigurationProperties myProp) {
        this.dataSource = dataSource;
        this.myProp = myProp;
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/url")
    String url() {
        return dataSource.getUrl();
    }

    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/prop")
    boolean myProp() {
        return myProp.getTemplate().isAllowMultipleTasks();
    }
}
