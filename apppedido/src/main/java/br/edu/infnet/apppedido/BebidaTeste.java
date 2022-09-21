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
import br.edu.infnet.apppedido.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.apppedido.model.service.BebidaService;

@Component
@Order(3)
public class BebidaTeste implements ApplicationRunner {
	
	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) {
		
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
							Bebida b1 = new Bebida();
							b1.setCodigo(Integer.valueOf(campos[1]));
							b1.setNome(campos[2]);
							b1.setValor(Float.valueOf(campos[3]));
							b1.setGelada(Boolean.valueOf(campos[4]));
							b1.setMarca(campos[5]);
							b1.setTamanho(Float.valueOf(campos[6]));
							System.out.println("Cálculo de venda: " + b1.calcularVenda());
							bebidaService.incluir(b1);
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