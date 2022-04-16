package com.dhbrasil.aula36Mesa.aula36mesa.dto;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Consulta;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Usuario;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class ConsultaDto {

    private Integer id;
    @NotBlank
    private Date dataCad;
    @NotBlank
    private Date dataAtend;

    @NotNull
    @Valid
    private PacienteDto paciente;

    @NotNull
    @Valid
    private DentistaDto dentista;

    @NotNull
    @Valid
    private UsuarioDto usuario;

    public ConsultaDto(){}

    public ConsultaDto(Integer id, Date dataCad, Date dataAtend) {
        this.id = id;
        this.dataCad = dataCad;
        this.dataAtend = dataAtend;

    }

    public ConsultaDto(Consulta consulta){
        id = consulta.getId();
        dataCad = consulta.getDataCad();
        dataAtend = consulta.getDataAtend();

        if(consulta.getPaciente() != null){
            paciente = new PacienteDto(consulta.getPaciente());
        }

        if(consulta.getDentista() != null){
            dentista = new DentistaDto(consulta.getDentista());
        }

        if(consulta.getUsuario() != null){
            usuario = new UsuarioDto(consulta.getUsuario());
        }
    }

    public Consulta toEntity(){
        return new Consulta(
                this.id,
                this.dataCad,
                this.dataAtend,
                this.paciente == null ? null : this.paciente.toEntity(),
                this.dentista == null ? null : this.dentista.toEntity(),
                this.usuario == null ? null : this.usuario.toEntity());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public DentistaDto getDentista() {
        return dentista;
    }

    public void setDentista(DentistaDto dentista) {
        this.dentista = dentista;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
