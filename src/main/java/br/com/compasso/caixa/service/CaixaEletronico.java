package br.com.compasso.caixa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.compasso.caixa.exception.ValorImpossivelDeSacarException;
import br.com.compasso.caixa.model.Nota;

@Service
public class CaixaEletronico {

	private List<Nota> notas = new ArrayList<Nota>();

	public CaixaEletronico() {
		notas = new NotaService().notasExistentes();
//		System.out.println(notas);
	}

	public List<Nota> opera(int valor) throws ValorImpossivelDeSacarException {

		List<Nota> notasSacadas = new ArrayList<Nota>();
		int resto = valor;
		int numeroDeNotas = 0;

		resto = fazCalculoDoResto(notasSacadas, resto, numeroDeNotas, valor);

		
		if (resto != 0 || valor == 1 || valor == 3) {
			throw new ValorImpossivelDeSacarException("Valor: " + valor + "e impossivel de sacar");
		}

		return notasSacadas;
	}

	private int fazCalculoDoResto(List<Nota> notasSacadas, int resto, int numeroDeNotas, int valor) {
		for (int i = notas.size(); i > 0; i--) {
//			System.out.println(resto);
			while (resto > 0) {
				resto -= notas.get(i - 1).getValor();
				numeroDeNotas++;
			}
			if (resto != 0) {
				resto += notas.get(i - 1).getValor();
				numeroDeNotas--;
			}
			if (resto == 1 || resto == 3) {
				resto += notas.get(i - 1).getValor();
				numeroDeNotas--;
			}
			if (numeroDeNotas > 0) {
				notasSacadas.add(new Nota(notas.get(i - 1).getValor(), numeroDeNotas));
				numeroDeNotas = 0;
			}
		}
//		if (resto != 0) {
//			if (notas.size() != 0) {
//				resto = valor;
//				notasSacadas.removeAll(notasSacadas);
//				resto = extracted(notasSacadas, resto, numeroDeNotas, valor);
//			}
//		}

		return resto;
	}

}
