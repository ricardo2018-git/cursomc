package com.ricardo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardo.cursomc.domain.Categoria;
import com.ricardo.cursomc.domain.Produto;
import com.ricardo.cursomc.repositories.CategoriaRepository;
import com.ricardo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepositoy;
	
	// inicio p/ rodar aplicação
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// Alimenta nossa BD online,
	@Override
	public void run(String... args) throws Exception {
		
		// Cria as Categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		// Cria os Produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		// Associa Categorias aos Produtos
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		// Associa Produtos as Categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// Manda salvar as Categorias
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		// Manda salvar os Produtos
		produtoRepositoy.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
