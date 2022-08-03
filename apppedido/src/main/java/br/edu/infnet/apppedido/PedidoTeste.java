package br.edu.infnet.apppedido;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Pedido;

@Component
public class PedidoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("#pedido");
		
		Pedido p1 = new Pedido();
		p1.descricao = "Pedido 1";
		p1.data = LocalDateTime.now();
		p1.web = false;		
		System.out.println(p1);

		Pedido p2 = new Pedido();
		p2.descricao = "Pedido 2";
		p2.data = LocalDateTime.now();
		p2.web = true;		
		System.out.println(p2);

		Pedido p3 = new Pedido();
		p3.descricao = "Pedido 3";
		p3.data = LocalDateTime.now();
		p3.web = false;		
		System.out.println(p3);
	}
}