package com.projeto.jonatas.To_do_list.service;

import com.projeto.jonatas.To_do_list.model.Task;
import com.projeto.jonatas.To_do_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //Cria construtor em tudo que for instanciado com final
public class TaskService {

    private final TaskRepository repository;

    public Task salvar (Task task){
        return  repository.save(task);
    }

}
