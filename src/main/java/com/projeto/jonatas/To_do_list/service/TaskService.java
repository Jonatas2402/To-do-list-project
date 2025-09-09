package com.projeto.jonatas.To_do_list.service;

import com.projeto.jonatas.To_do_list.model.Task;
import com.projeto.jonatas.To_do_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor //Cria construtor em tudo que for instanciado com final
public class TaskService {

    private final TaskRepository repository;
    // SALVA TASK
    public Task salvar (Task task){
        return  repository.save(task);
    }

    //DELETA TASK
    public void deletar(UUID id){
        repository.deleteById(id);
    }
    // BUSCA TODAS AS LISTAS
    public List<Task> findAll(){
        return repository.findAll();
    }
    public Task findById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void update(Task task){
        repository.save(task);
    }
}
