package com.projeto.jonatas.To_do_list.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "task")
@Data
public class Task {

   @Id
   @Column(name = "id")
   @GeneratedValue
   private UUID id;

   @Column(name = "title")
   private String title;

   @Column(name = "description")
   private String descriptiom;

   @Column(name = "status")
   private Status status;


}
