package br.edu.infnet.apppedido;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Solicitante;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.exceptions.CpfInvalidoException;
import br.edu.infnet.apppedido.model.service.SolicitanteService;

@Component
@Order(2)
public class SolicitanteTeste implements ApplicationRunner {

	@Autowired
	private SolicitanteService solicitanteService;
	
	@Override
	public void run(ApplicationArguments args) {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		String dir = "c:/dev/";
		String arq = "solicitantes.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha = leitura.readLine();
				while(linha != null) {
					
					String[] campos = linha.split(";");

					try {
						Solicitante solicitante = new Solicitante(campos[0], campos[1], campos[2]);
						solicitante.setUsuario(usuario);
						solicitanteService.incluir(solicitante);		
					} catch (CpfInvalidoException e) {
						System.out.println("[ERROR] " + e.getMessage());
					}		
					
					linha = leitura.readLine();
				}

				leitura.close();
				fileReader.close();				
			} catch (FileNotFoundException e) {
				System.out.println("[ERRO] O arquivo não existe!!!");
				
			} catch (IOException e) {
				System.out.println("[ERRO] Problema no fechamento do arquivo!!!");
			}			
		} finally {
			System.out.println("Terminou!!!");
		}		
	}
}