package com.produto.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.produto.dto.produtoDto;
import com.produto.produto.model.produtoModel;
import com.produto.produto.model.produtoRepository;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("produtos")
public class pordutoController {

	
	@Autowired
	produtoRepository repository;
	
	@PostMapping("/postar")
	@Transactional 
	public ResponseEntity postar(@RequestBody produtoDto receber_dto) {
		var produto = new produtoModel(receber_dto);
		repository.save(produto);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Long id) {
		var produto = repository.getReferenceById(id);
		repository.delete(produto);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody produtoDto receber_dto) {
		var produto = repository.getReferenceById(id);	
		produto.atualizarInfos(receber_dto);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping
	public ResponseEntity detalhesProdutos() {
		return ResponseEntity.ok(repository.findAll());
	}
	

}
