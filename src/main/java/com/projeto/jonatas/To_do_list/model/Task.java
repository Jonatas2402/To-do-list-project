package com.projeto.jonatas.To_do_list.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "task")
@Data
public class Task {
   @Id
   @Column(name = "id")
   @GeneratedValue
   private Long id;

   @Column(name = "title", nullable = false)
   private String title;

   @Column(name = "description", nullable = false)
   private String description;

   @Column(name = "status")
   private Status status;
}
