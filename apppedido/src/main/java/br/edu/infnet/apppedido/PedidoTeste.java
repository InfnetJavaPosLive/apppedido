package br.edu.infnet.apppedido;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Solicitante;
import br.edu.infnet.apppedido.model.exceptions.CpfInvalidoException;
import br.edu.infnet.apppedido.model.exceptions.PedidoSemProdutoException;
import br.edu.infnet.apppedido.model.exceptions.SolicitanteNuloException;
import br.edu.infnet.apppedido.model.service.PedidoService;

@Component
@Order(1)
public class PedidoTeste implements ApplicationRunner {
	
	@Autowired
	private PedidoService pedidoService;

	@Override
	public void run(ApplicationArguments args) {

		String dir = "c:/dev/";
		String arq = "pedidos.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				Set<Produto> produtos = null;
				List<Pedido> pedidos = new ArrayList<Pedido>();
				
				String linha = leitura.readLine();
				while(linha != null) {

					String[] campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "P":
						try {						
							produtos = new HashSet<Produto>();		
							
							Solicitante solicitante1 = new Solicitante(campos[3], campos[4], campos[5]);

							Pedido pedido = new Pedido(solicitante1, produtos);
							pedido.setDescricao(campos[1]);
							pedido.setWeb(Boolean.valueOf(campos[2]));
							
							pedidos.add(pedido);
							
						} catch (CpfInvalidoException | SolicitanteNuloException | PedidoSemProdutoException e) {
							System.out.println("[ERROR] - PEDIDO" + e.getMessage());
						}
						break;

					case "B":					
						Bebida bebida = new Bebida();
						bebida.setCodigo(Integer.valueOf(campos[1]));
						bebida.setNome(campos[2]);
						bebida.setValor(Float.valueOf(campos[3]));
						bebida.setGelada(Boolean.valueOf(campos[4]));
						bebida.setMarca(campos[5]);
						bebida.setTamanho(Float.valueOf(campos[6]));

						produtos.add(bebida);
						
						break;

					case "C":						
						Comida comida = new Comida();
						comida.setCodigo(Integer.valueOf(campos[1]));
						comida.setNome(campos[2]);
						comida.setValor(Float.valueOf(campos[3]));
						comida.setIngredientes(campos[4]);
						comida.setPeso(Float.valueOf(campos[5]));
						comida.setVegano(Boolean.valueOf(campos[6]));

						produtos.add(comida);
						
						break;

					case "S":						
						break;
						
					default:
						break;
					}
					
					linha = leitura.readLine();
				}
				
				for(Pedido p : pedidos) {
					pedidoService.incluir(p);
					
					System.out.println(">>>>>>>>>>>>> " + p.getId());
					System.out.println(">>>>>>>>>>> " + p.getSolicitante().getNome());
					System.out.println(">>>>>>>>> " + p.getProdutos().size());
					
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