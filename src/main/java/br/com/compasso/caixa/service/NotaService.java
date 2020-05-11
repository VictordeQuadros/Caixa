package br.com.compasso.caixa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.compasso.caixa.model.Nota;

@Service
public class NotaService {

	private int[] notasDoMoeda = {2, 5,10, 20, 50, 100};

	public List<Nota> notasExistentes() {

		List<Nota> notas = new ArrayList<Nota>();

		for (int i = 0; i < notasDoMoeda.length; i++) {
			notas.add(new Nota(notasDoMoeda[i]));
		}

		return notas;
	}

	public int[] getNotasDaMoeda() {
		return notasDoMoeda;
	}

}
