package com.ricardo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardo.cursomc.domain.Categoria;
import com.ricardo.cursomc.domain.Cidade;
import com.ricardo.cursomc.domain.Estado;
import com.ricardo.cursomc.domain.Produto;
import com.ricardo.cursomc.repositories.CategoriaRepository;
import com.ricardo.cursomc.repositories.CidadeRepository;
import com.ricardo.cursomc.repositories.EstadoRepository;
import com.ricardo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	// Nossas dependências
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepositoy;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	// inicio p/ rodar aplicação
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// Alimenta nossa BD online,
	@Override
	public void run(String... args) throws Exception {
		
		// --- Inicio ---
		
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
			
		// --- FIM ---
		
		// --- Inicio ---
		
			// Cria os Estados
			Estado est1 = new Estado(null, "Minas Gerais");
			Estado est2 = new Estado(null, "São Paulo");
			
			// Cria as Cidades e associa os Estados
			Cidade c1 = new Cidade(null, "Uberlândia", est1);
			Cidade c2 = new Cidade(null, "São Paulo", est2);
			Cidade c3 = new Cidade(null, "Campinas", est2);
			
			// Associa Estado a cidade
			est1.getCidades().addAll(Arrays.asList(c1));
			est2.getCidades().addAll(Arrays.asList(c2, c3));
				
			// Manda Salvar Estado, respeitar dependencia estado não depende de cidade
			estadoRepository.saveAll(Arrays.asList(est1, est2));
			
			// Manda Salvar Cidade, depende de um estado
			cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		// --- FIM ---
		
	}

}
