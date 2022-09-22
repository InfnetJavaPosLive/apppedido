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

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.apppedido.model.service.BebidaService;

@Component
@Order(3)
public class BebidaTeste implements ApplicationRunner {
	
	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		String dir = "c:/dev/";
		String arq = "produtos.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha = leitura.readLine();
				while(linha != null) {
					
					String[] campos = linha.split(";");
					
					if("B".equalsIgnoreCase(campos[0])) {
						try {
							Bebida bebida = new Bebida();
							bebida.setCodigo(Integer.valueOf(campos[1]));
							bebida.setNome(campos[2]);
							bebida.setValor(Float.valueOf(campos[3]));
							bebida.setGelada(Boolean.valueOf(campos[4]));
							bebida.setMarca(campos[5]);
							bebida.setTamanho(Float.valueOf(campos[6]));
							bebida.setUsuario(usuario);
							System.out.println("Cálculo de venda: " + bebida.calcularVenda());
							bebidaService.incluir(bebida);
						} catch (TamanhoBebidaInvalidoException e) {
							System.out.println("[ERROR - BEBIDA] " + e.getMessage());
						}
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