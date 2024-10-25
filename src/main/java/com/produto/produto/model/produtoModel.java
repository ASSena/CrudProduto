package com.produto.produto.model;

import com.produto.produto.dto.produtoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name="produtos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class produtoModel {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double preco;
	
	public produtoModel(produtoDto receber_dto) {
		this.nome = receber_dto.nome();
		this.preco = receber_dto.preco();
	}
	
	
	public produtoModel() {}
	
	
	public void atualizarInfos(produtoDto produto) {
		if(produto.nome() != null) {
			this.nome = produto.nome();
		}
		if(produto.preco() != 0) {
			this.preco = produto.preco();
		}
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

	
	
	
}

