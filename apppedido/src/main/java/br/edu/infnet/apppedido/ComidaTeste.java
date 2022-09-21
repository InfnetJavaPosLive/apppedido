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

import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.exceptions.PesoZeradoNegativoException;
import br.edu.infnet.apppedido.model.service.ComidaService;

@Component
@Order(4)
public class ComidaTeste implements ApplicationRunner {
	
	@Autowired
	private ComidaService comidaService;

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
					
					if("C".equalsIgnoreCase(campos[0])) {
						try {
							Comida c1 = new Comida();
							c1.setCodigo(Integer.valueOf(campos[1]));
							c1.setNome(campos[2]);
							c1.setValor(Float.valueOf(campos[3]));
							c1.setIngredientes(campos[4]);
							c1.setPeso(Float.valueOf(campos[5]));
							c1.setVegano(Boolean.valueOf(campos[6]));
							System.out.println("Cálculo de venda: " + c1.calcularVenda());
							comidaService.incluir(c1);		
						} catch (PesoZeradoNegativoException e) {
							System.out.println("[ERROR - COMIDA] " + e.getMessage());			
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