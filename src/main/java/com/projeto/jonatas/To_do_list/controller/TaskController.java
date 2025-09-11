package com.projeto.jonatas.To_do_list.controller;

import com.projeto.jonatas.To_do_list.model.Task;
import com.projeto.jonatas.To_do_list.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public Task salvar(@RequestBody @Valid Task task) {
        return service.salvar(task);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id) {
        var obterId = UUID.fromString(id);
        service.deletar(obterId);
    }

    @GetMapping
    public List<Task> lista(){
        return service.findAll();
    }

    @PutMapping("{id}")
    public Task update(@PathVariable("id") String id, @Valid  @RequestBody Task task){
        var obterId = UUID.fromString(id);
        return service.update(obterId, task);
    }
}
