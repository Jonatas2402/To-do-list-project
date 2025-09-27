package com.projeto.jonatas.To_do_list.controller;

import com.projeto.jonatas.To_do_list.DTOS.TaskRequestDTO;
import com.projeto.jonatas.To_do_list.DTOS.TaskResponseDTO;
import com.projeto.jonatas.To_do_list.model.Task;
import com.projeto.jonatas.To_do_list.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> salvar(@RequestBody @Valid Task task) {
        TaskResponseDTO responseDTO = service.salvar(task);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> buscarPorId(@PathVariable("id") Long id) {
        TaskResponseDTO responseDTO = service.buscarPorId(id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TaskRequestDTO requestDTO) {
        TaskResponseDTO responseDTO = service.atualizar(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}


