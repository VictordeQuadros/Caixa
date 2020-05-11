package br.com.compasso.caixa.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.compasso.caixa.exception.SemValorException;
import br.com.compasso.caixa.exception.ValorImpossivelDeSacarException;
import br.com.compasso.caixa.model.Nota;
import br.com.compasso.caixa.service.NotaService;

class CaixaControllerTest {

	@Test
	void testaSaqueInvalidoNulo() {

		Assertions.assertThrows(SemValorException.class, () -> {
			new CaixaController().sacar(null);
		});
	}

	@Test
	void testaSaqueInvalidoZero() {

		Assertions.assertThrows(SemValorException.class, () -> {
			new CaixaController().sacar("0");
		});
	}

	@Test
	void testaSaqueInvalidoEspaco() {

		Assertions.assertThrows(NumberFormatException.class, () -> {
			new CaixaController().sacar("");
		});
	}

	@Test
	void testaSaqueInvalidoSimbolosEPalavra() {

		Assertions.assertThrows(NumberFormatException.class, () -> {
			new CaixaController().sacar("a");
			new CaixaController().sacar("A");
			new CaixaController().sacar("@");
			new CaixaController().sacar("test");
			new CaixaController().sacar("TEST");
			new CaixaController().sacar("T&s7");

		});
	}

	@Test
	void testaSaqueComPontoFlutuante() {

		Assertions.assertThrows(NumberFormatException.class, () -> {
			new CaixaController().sacar("10,5");
		});
	}

	@Test
	void testaSaqueSemOuComNotaDeUm() {
		// Se tem notas de 1 eh possivel sacar quaquer valor

		List<Nota> notas = new NotaService().notasExistentes();
		boolean flag = true;

		for (Nota nota : notas) {
			if (nota.getValor() == 1) {
				flag = false;
			}
		}

		if (!flag) {
			Assertions.assertThrows(NumberFormatException.class, () -> {
				new CaixaController().sacar("1");
			});
		} else {
			assertTrue(flag);
		}

	}

	@Test
	void testaSaidaMultiplos() throws SemValorException, ValorImpossivelDeSacarException {
		CaixaController caixaController = new CaixaController();

		int[] notasDaMoeda = new NotaService().getNotasDaMoeda();

		for (int i = 0; i < notasDaMoeda.length; i++) {

			for (int j = 0; j < notasDaMoeda.length; j++) {

				for (int count = 0; count < notasDaMoeda.length; count++) {

					Integer teste = notasDaMoeda[i] * notasDaMoeda[j] * notasDaMoeda[count];
//					System.out.println(teste.toString());
					caixaController.sacar(teste.toString());
				}
			}

		}

		assertTrue(true);

	}

	@Test
	void testaHard() throws SemValorException, ValorImpossivelDeSacarException {
		CaixaController caixaController = new CaixaController();

		for (int count = 0; count < 100000000; count++) {

			Integer teste = count;
//					System.out.println(teste.toString());
			try {
				caixaController.sacar(teste.toString());

			} catch (Exception e) {
				System.out.println(teste);
			}
		}

		assertTrue(true);

	}

}
