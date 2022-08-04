package br.edu.infnet.apppedido;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Pedido;

@Component
@Order(1)
public class PedidoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("#pedido");
		
		Pedido p1 = new Pedido();
		p1.setDescricao("Pedido 1");
		p1.setData(LocalDateTime.now());
		p1.setWeb(false);		
		System.out.println(p1);

		Pedido p2 = new Pedido();
		p2.setDescricao("Pedido 2");
		p2.setData(LocalDateTime.now());
		p2.setWeb(true);		
		System.out.println(p2);

		Pedido p3 = new Pedido();
		p3.setDescricao("Pedido 3");
		p3.setData(LocalDateTime.now());
		p3.setWeb(false);		
		System.out.println(p3);
	}
}