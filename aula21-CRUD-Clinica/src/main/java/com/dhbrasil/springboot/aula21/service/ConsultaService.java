package com.dhbrasil.springboot.aula21.service;

import com.dhbrasil.springboot.aula21.model.Consulta;
import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.model.Paciente;
import com.dhbrasil.springboot.aula21.model.Usuario;
import com.dhbrasil.springboot.aula21.model.dto.NovaConsultaDTO;
import resources.IDao;

import java.util.List;
import java.util.Optional;

public class ConsultaService {

    private IDao<Consulta> consultaIDao;
    private IDao<Dentista> dentistaIDao;
    private IDao<Usuario> usuarioIDao;
    private IDao<Paciente> pacienteIDao;

    public ConsultaService(IDao<Consulta> consultaIDao, IDao<Dentista> dentistaIDao, IDao<Usuario> usuarioIDao, IDao<Paciente> pacienteIDao) {
        this.consultaIDao = consultaIDao;
        this.dentistaIDao = dentistaIDao;
        this.usuarioIDao = usuarioIDao;
        this.pacienteIDao = pacienteIDao;
    }


    public Consulta salvar(Consulta consulta){
        consultaIDao.salvar(consulta);
        return consulta;
    }
    public Consulta salvar2(NovaConsultaDTO novaConsultaDTO){


        Consulta consulta = new Consulta(new Paciente(novaConsultaDTO.getId_paciente()),
                new Dentista(novaConsultaDTO.getId_dentista()),
                new Usuario(novaConsultaDTO.getId_usuario()),
                novaConsultaDTO.getDataCad(),
                novaConsultaDTO.getDataAtend());


        consultaIDao.salvar(consulta);
        return consulta;
    }

    public Optional<Consulta> buscar(Integer id) {
        return consultaIDao.buscar(id);
    }

    public void excluir(Integer id) {
        consultaIDao.excluir(id);
    }

    public List<Consulta> buscarTodos() {
        return consultaIDao.buscarTodos();
    }

    public Consulta atualizar(Consulta consulta) {
        return consultaIDao.atualizar(consulta);
    }

}
