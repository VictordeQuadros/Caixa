package br.com.compasso.caixa.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.compasso.caixa.exception.ValorImpossivelDeSacarException;
import br.com.compasso.caixa.model.Nota;

class CaixaEletronicoTest {

	@Test
	public void testaValorDeSaqueInvalido() {

		List<Nota> notas = new NotaService().notasExistentes();
		boolean flag = true;

		for (Nota nota : notas) {
			if (nota.getValor() == 1) {
				flag = false;
			}
		}

		if (!flag) {
			Assertions.assertThrows(ValorImpossivelDeSacarException.class, () -> {
				new CaixaEletronico().opera(3);
				new CaixaEletronico().opera(1);
			});
		} else { 
			assertTrue(flag);
		}

	}

	@Test
	public void testaValorDeSaqueValido() throws ValorImpossivelDeSacarException {

		List<Nota> notas = new NotaService().notasExistentes();
		boolean flag = true;

		for (Nota nota : notas) {
			if (new CaixaEletronico().opera(nota.getValor()).size() != 1) {
				flag = false;
			}

		}

		assertTrue(flag);

	}

}
