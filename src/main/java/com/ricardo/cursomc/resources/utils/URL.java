package com.ricardo.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL { 
	
	// Retira espaço em branco da nossa URI  
	public static String decodeParam(String s) {
		
		try {	// Tente fazer
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {	// se nao conseguir, faça 
			return "";
		}
	}

	// Ela recebe uma String e retorna uma lista de  numeros
	public static List<Integer> decodeIntList(String s) {
		String[] vet = s.split(","); 			// Recorta uma String com base no caracter q passa ","
		List<Integer> list = new ArrayList<>();	// Instancia uma lista
		for (int i=0; i<vet.length; i++) { 		// percorre o vetor
			list.add(Integer.parseInt(vet[i])); 			// converte cada posição do vetor para int, e adiciona na lista
		}
		return list;	// retorna a lista de numeros
		
		// Faz a mesma coisa da logica de cima + em lambida só p/ saber que existe outras formas de fazer
		// retrun Arrays.asList(s.split(",").stream().map(x -> Integer.parseInt(x)).Collectors.toList());
	}
}
