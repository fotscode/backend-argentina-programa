package com.fots.backendap.api;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fots.backendap.model.Project;
import com.fots.backendap.model.Response;
import com.fots.backendap.service.implementations.ProjectServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
@CrossOrigin
public class ProjectController {
    private final ProjectServiceImpl projectService;

    @GetMapping("/list")
    public ResponseEntity<Response> getProjects() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("projects", projectService.list(30)))
                        .message("Project retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("project", projectService.get(id)))
                        .message("Project retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveProject(@RequestBody Project project) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("project", projectService.create(project)))
                        .message("Project created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("project", projectService.delete(id)))
                        .message("Project deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateProject(@RequestBody Project project) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("project", projectService.update(project)))
                        .message("Project updated")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

}
