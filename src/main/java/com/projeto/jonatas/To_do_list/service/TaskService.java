package com.projeto.jonatas.To_do_list.service;

import com.projeto.jonatas.To_do_list.DTOS.TaskRequestDTO;
import com.projeto.jonatas.To_do_list.DTOS.TaskResponseDTO;
import com.projeto.jonatas.To_do_list.model.Task;
import com.projeto.jonatas.To_do_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //Cria construtor em tudo que for instanciado com final
public class TaskService {

    private final TaskRepository repository;

    public TaskResponseDTO salvar(Task task) {
        var tarefaSalva = repository.save(task);
        return new TaskResponseDTO(
                tarefaSalva.getId(),
                tarefaSalva.getTitle(),
                tarefaSalva.getDescription(),
                tarefaSalva.getStatus()
        );
    }

    public List<Task> listar() {
        return repository.findAll();
    }

    public TaskResponseDTO buscarPorId(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return toResponse(task);
    }
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }

    public TaskResponseDTO atualizar(Long id, TaskRequestDTO requestDTO) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        task.setTitle(requestDTO.title());
        task.setDescription(requestDTO.description());
        task.setStatus(requestDTO.status());

        Task updatedTask = repository.save(task);
        return toResponse(updatedTask);
    }
    private TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
}