package br.com.compasso.caixa.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.compasso.caixa.model.Nota;

class NotaServiceTest {

	@Test
	void testaRetornoDosValoresDasNotas() {
		NotaService notaService = new NotaService();

		List<Nota> notasExistentes = notaService.notasExistentes();
		int[] notasDaMoeda = notaService.getNotasDaMoeda();

		boolean flag = true;

		for (int i = 0; i < notasExistentes.size(); i++) {
			if (notasExistentes.get(i).getValor() != notasDaMoeda[i]) {
				flag = false;
			}
		}
		
		assertTrue(flag);
		
	}

}
