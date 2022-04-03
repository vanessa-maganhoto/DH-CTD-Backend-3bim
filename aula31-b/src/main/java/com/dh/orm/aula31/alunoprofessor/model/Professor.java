package com.dh.orm.aula31.alunoprofessor.model;

import javax.persistence.*;
import java.util.*;



@Entity
@Table
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String curso;
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private Set<Aluno> alunos = new HashSet<>();

    public Professor(){}


}
