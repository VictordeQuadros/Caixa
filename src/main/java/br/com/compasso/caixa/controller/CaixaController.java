package br.com.compasso.caixa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.caixa.controller.dto.NotaDto;
import br.com.compasso.caixa.exception.SemValorException;
import br.com.compasso.caixa.exception.ValorImpossivelDeSacarException;
import br.com.compasso.caixa.model.Nota;
import br.com.compasso.caixa.service.CaixaEletronico;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

	@GetMapping
	public List<NotaDto> sacar(String saque) throws SemValorException, ValorImpossivelDeSacarException {

		if (saque == null || Integer.parseInt(saque) == 0  ) {
			throw new SemValorException("Valor de saque não informado ou igual a zero");
		} else {
			List<NotaDto> listaDasNotas = new ArrayList<NotaDto>();
			List<Nota> saida;
			try {
				saida = new CaixaEletronico().opera(Integer.parseInt(saque));
			} catch (NumberFormatException e) {
				throw new ValorImpossivelDeSacarException("Valor: " + saque + "possui ponto flutuante");
			} catch (ValorImpossivelDeSacarException e) {
				throw new ValorImpossivelDeSacarException(
						"Valor: " + saque + " é impossivel de sacar com as notas disponiveis.");
			}

			for (Nota nota : saida) {
				listaDasNotas.add(new NotaDto(nota));
			}

			return listaDasNotas;
		}
	}

}
