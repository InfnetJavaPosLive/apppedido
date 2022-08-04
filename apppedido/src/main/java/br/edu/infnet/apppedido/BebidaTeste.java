package br.edu.infnet.apppedido;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Bebida;

@Component
@Order(2)
public class BebidaTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("#bebida");
		
		Bebida b1 = new Bebida();
		b1.codigo = 123;
		b1.nome = "energ";
		b1.valor = 10;
		b1.gelada = true;
		b1.marca = "power";
		b1.tamanho = 500;
		System.out.println(b1);

		Bebida b2 = new Bebida();
		b2.codigo = 234;
		b2.nome = "coooooffff";
		b2.valor = 5;
		b2.gelada = false;
		b2.marca = "cafezin";
		b2.tamanho = 100;
		System.out.println(b2);

		Bebida b3 = new Bebida();
		b3.codigo = 345;
		b3.nome = "brahma";
		b3.valor = 100;
		b3.gelada = true;
		b3.marca = "chope";
		b3.tamanho = 1000;
		System.out.println(b3);
	}
}