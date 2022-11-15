package com.valdir.helpdesk.services;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.valdir.helpdesk.domain.Chamado;
import com.valdir.helpdesk.domain.Cliente;
import com.valdir.helpdesk.domain.Tecnico;
import com.valdir.helpdesk.domain.enums.Perfil;
import com.valdir.helpdesk.domain.enums.Prioridade;
import com.valdir.helpdesk.domain.enums.Status;
import com.valdir.helpdesk.repositories.ChamadoRepository;
import com.valdir.helpdesk.repositories.ClienteRepository;
import com.valdir.helpdesk.repositories.TecnicoRepository;

@Service //Vira um Bean Gerenciavel
public class DBService {
	//Proprio Spring Instancia a Classe
		@Autowired
		private TecnicoRepository tecnicoRepository;
		
		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		private ChamadoRepository chamadoRepository;
		
		
	public void instanciaDB() {
		//Executa sempre que der start na aplicacao
				Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "10303069740", "valdir@email.com", "123");
				tec1.addPerfil(Perfil.ADMIN);
				
				Cliente cli1 = new Cliente(null, "Linus Torvalds", "10391626736", "linus@email.com", "123");
				cli1.addPerfil(Perfil.CLIENTE);
				
				Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
				
				
				//Salvando no Banco pelo Repository
				tecnicoRepository.saveAll(Arrays.asList(tec1));
				clienteRepository.saveAll(Arrays.asList(cli1));
				chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
