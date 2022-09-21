package br.edu.infnet.apppedido;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.exceptions.QuantidadeIncorretaException;
import br.edu.infnet.apppedido.model.test.AppImpressao;

@Component
@Order(5)
public class SobremesaTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("#####sobremesa");
		
		try {
			Sobremesa s1 = new Sobremesa();
			s1.setCodigo(234);
			s1.setNome("bolo");
			s1.setValor(20);
			s1.setDoce(true);
			s1.setInformacao("com morango");
			s1.setQuantidade(4);
			System.out.println("Cálculo de venda: " + s1.calcularVenda());
			AppImpressao.relatorio("Inclusão da sobremesa bolo!!!", s1);
		} catch (QuantidadeIncorretaException e) {
			System.out.println("[ERROR - SOBREMESA] " + e.getMessage());			
		}

		try {
			Sobremesa s2 = new Sobremesa();
			s2.setCodigo(567);
			s2.setNome("churros");
			s2.setValor(10);
			s2.setDoce(false);
			s2.setInformacao("com frango");
			s2.setQuantidade(1);
			System.out.println("Cálculo de venda: " + s2.calcularVenda());
			AppImpressao.relatorio("Inclusão da sobremesa churros!!!", s2);
		} catch (QuantidadeIncorretaException e) {
			System.out.println("[ERROR - SOBREMESA] " + e.getMessage());			
		}

		try {
			Sobremesa s3 = new Sobremesa();
			s3.setCodigo(678);
			s3.setNome("pamonha");
			s3.setValor(15);
			s3.setDoce(true);
			s3.setInformacao("doce de leite");
			s3.setQuantidade(2);
			System.out.println("Cálculo de venda: " + s3.calcularVenda());
			AppImpressao.relatorio("Inclusão da sobremesa pamonha!!!", s3);
		} catch (QuantidadeIncorretaException e) {
			System.out.println("[ERROR - SOBREMESA] " + e.getMessage());			
		}

		try {
			Sobremesa s4 = new Sobremesa();
			s4.setCodigo(678);
			s4.setNome("pamonha");
			s4.setValor(15);
			s4.setDoce(true);
			s4.setInformacao("doce de leite");
			s4.setQuantidade(-2);
			System.out.println("Cálculo de venda: " + s4.calcularVenda());
			AppImpressao.relatorio("Inclusão da sobremesa pamonha!!!", s4);
		} catch (QuantidadeIncorretaException e) {
			System.out.println("[ERROR - SOBREMESA] " + e.getMessage());			
		}

		try {
			Sobremesa s4 = new Sobremesa();
			s4.setCodigo(678);
			s4.setNome("pamonha");
			s4.setValor(15);
			s4.setDoce(true);
			s4.setInformacao("doce de leite");
			s4.setQuantidade(7);
			System.out.println("Cálculo de venda: " + s4.calcularVenda());
			AppImpressao.relatorio("Inclusão da sobremesa pamonha!!!", s4);
		} catch (QuantidadeIncorretaException e) {
			System.out.println("[ERROR - SOBREMESA] " + e.getMessage());			
		}
	}
}