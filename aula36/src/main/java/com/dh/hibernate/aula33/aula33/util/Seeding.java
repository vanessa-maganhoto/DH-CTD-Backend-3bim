package com.dh.hibernate.aula33.aula33.util;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.model.Time;
import com.dh.hibernate.aula33.aula33.repository.JogadorRepository;
import com.dh.hibernate.aula33.aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Seeding implements ApplicationRunner {

    private JogadorRepository jogadorRepository;
    private TimeRepository timeRepository;

    @Autowired
    public Seeding(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    public void run(ApplicationArguments args) {

        Time t1 = new Time("América Futebol Clube", "Belo Horizonte", "MG");
        Time t2 = new Time("Club Athletico Paranaense", "Curitiba", "PR");
        Time t3 = new Time("Atlético Clube Goianiense", "Goiânia", "GO");
        Time t4 = new Time("Clube Atlético Mineiro", "Belo Horizonte", "MG");
        Time t5 = new Time("Avaí Futebol Clube", "Florinópolis", "SC");
        Time t6 = new Time("Botafogo de Futebol e Regatas", "Rio de Janeiro", "RJ");
        Time t7 = new Time("Red Bull Bragantino", "Bragança Paulista", "SP");
        Time t8 = new Time("Ceará Sporting Clube", "Fortaleza", "CE");
        Time t9 = new Time("Sport Club Corinthians Paulista", "São Paulo", "SP");
        Time t10 = new Time("Coritiba Foot Ball Club", "Curitiba", "PR");
        Time t11 = new Time("Cuiabá Esporte Clube", "Cuiabá", "MT");
        Time t12 = new Time("Clube de Regatas do Flamengo", "Rio de Janeiro", "RJ");
        Time t13 = new Time("Fluminense Football Club", "Rio de Janeiro", "RJ");
        Time t14 = new Time("Fortaleza Esporte Clube", "Fortaleza", "CE");
        Time t15 = new Time("Goiás Esporte Clube", "Goiânia", "GO");
        Time t16 = new Time("Esporte Clube Juventude", "Caxias do Sul", "RS");
        Time t17 = new Time("Sport Club Internacional", "Porto Alegre", "RS");
        Time t18 = new Time("Sociedade Esportiva Palmeiras", "São Paulo", "SP");
        Time t19 = new Time("Santos Futebol Clube", "Santos", "SP");
        Time t20 = new Time("São Paulo Futebol Clube", "São Paulo", "SP");

        timeRepository.save(t1); timeRepository.save(t2); timeRepository.save(t3);
        timeRepository.save(t4); timeRepository.save(t5); timeRepository.save(t6);
        timeRepository.save(t7); timeRepository.save(t8); timeRepository.save(t9);
        timeRepository.save(t10); timeRepository.save(t11); timeRepository.save(t12);
        timeRepository.save(t13); timeRepository.save(t14); timeRepository.save(t15);
        timeRepository.save(t16); timeRepository.save(t17); timeRepository.save(t18);
        timeRepository.save(t19); timeRepository.save(t20);

        Jogador j1 = new Jogador("Carlos Alberto Gomes da Silva Filho", "Atacante", 78.5 , 1.82, t1);
        Jogador j2 = new Jogador("Nicolás Hernández", "Zagueiro", 79.3 , 1.84, t2);
        Jogador j3 = new Jogador("Brian Montenegro", "Atacante", 81.2 , 1.78, t3);
        Jogador j4 = new Jogador("Edson Felipe da Cruz", "Volante", 83.8 , 1.85, t4);
        Jogador j5 = new Jogador("Bruno César Pereira da Silva", "Volante", 89.9 , 1.77, t5);
        Jogador j6 = new Jogador("Matheus Nascimento de Paula", "Atacante", 83.7 , 1.84, t6);
        Jogador j7 = new Jogador("Júlio César", "Goleiro", 80.8 , 1.87, t7);
        Jogador j8 = new Jogador("Messias Rodrigues da Silva Júnior", "Zagueiro", 78.2 , 1.89, t8);
        Jogador j9 = new Jogador("Cássio", "Goleiro", 75.4 , 1.96, t9);
        Jogador j10 = new Jogador("Gustavo Costa da Silva Machado", "Meio-campista", 88.5 , 1.81, t10);
        Jogador j11 = new Jogador("Gustavo Mantuan", "Volante", 77.1 , 1.80, t11);
        Jogador j12 = new Jogador("Rodrigo Caio", "Zagueiro", 78.4 , 1.74, t12);
        Jogador j13 = new Jogador("Pedro Rangel", "Goleiro", 90.7 , 1.89, t13);
        Jogador j14 = new Jogador("Ángelo Henríquez", "Atacante", 85.5 , 1.91, t14);
        Jogador j15 = new Jogador("Henrique Lordelo", "Volante", 78.8 , 1.79, t15);
        Jogador j16 = new Jogador("Paulo Henrique de Oliveira Alves", "Lateral", 77.4 , 1.83, t16);
        Jogador j17 = new Jogador("Andrés Nicolás D'Alessandro", "Meio-campista", 81.1 , 1.89, t17);
        Jogador j18 = new Jogador("Gabriel Veron", "Atacante", 83.9 , 1.86, t18);
        Jogador j19 = new Jogador("Lucas Braga", "Ponta esquerda", 87.5 , 1.78, t19);
        Jogador j20 = new Jogador("Igor Gomes", "Meio-campista", 81.2 , 1.80, t20);

        jogadorRepository.save(j1); jogadorRepository.save(j2); jogadorRepository.save(j3);
        jogadorRepository.save(j4); jogadorRepository.save(j5); jogadorRepository.save(j6);
        jogadorRepository.save(j7); jogadorRepository.save(j8); jogadorRepository.save(j9);
        jogadorRepository.save(j10); jogadorRepository.save(j11); jogadorRepository.save(j12);
        jogadorRepository.save(j13); jogadorRepository.save(j14); jogadorRepository.save(j15);
        jogadorRepository.save(j16); jogadorRepository.save(j17); jogadorRepository.save(j18);
        jogadorRepository.save(j19); jogadorRepository.save(j20);

    }
}

