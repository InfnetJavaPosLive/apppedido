package br.edu.infnet.apppedido.model.test;

import br.edu.infnet.apppedido.model.domain.Solicitante;

public class SolicitanteTeste {

	public static void main(String[] args) {

		Solicitante s1 = new Solicitante("123123123123", "elberth@elberth.com", "elberth");		
		System.out.println(s1);

		Solicitante s2 = new Solicitante("987987987987", "maria@maria.com", "maria");
		System.out.println(s2);

		Solicitante s3 = new Solicitante("234234234234", "ana@ana.com", "ana");
		System.out.println(s3);
	}
}