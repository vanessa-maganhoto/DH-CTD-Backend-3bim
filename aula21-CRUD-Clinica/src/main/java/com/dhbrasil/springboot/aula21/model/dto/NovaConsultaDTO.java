package com.dhbrasil.springboot.aula21.model.dto;

import java.util.Date;

public class NovaConsultaDTO {

    private Integer id_paciente;
    private Integer id_dentista;
    private Integer id_usuario;
    private Date dataCad;
    private Date dataAtend;

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getId_dentista() {
        return id_dentista;
    }

    public void setId_dentista(Integer id_dentista) {
        this.id_dentista = id_dentista;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public Date getDataAtend() {
        return dataAtend;
    }

    public void setDataAtend(Date dataAtend) {
        this.dataAtend = dataAtend;
    }
}
