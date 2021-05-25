package com.wilembergson.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PRODUTO")
public class Investimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoAtivo;
	private Double valorCota;
	private Integer quantidadeCotas;
	private	 LocalDate dataCompra;
	
	@ManyToOne
	@JoinColumn(name="fk_codigo_categoria")
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoAtivo() {
		return codigoAtivo;
	}
	public void setCodigoAtivo(String codigoAtivo) {
		this.codigoAtivo = codigoAtivo;
	}
	public Double getValorCota() {
		return valorCota;
	}
	public void setValorCota(Double valorCota) {
		this.valorCota = valorCota;
	}
	public Integer getQuantidadeCotas() {
		return quantidadeCotas;
	}
	public void setQuantidadeCotas(Integer quantidadeCotas) {
		this.quantidadeCotas = quantidadeCotas;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((codigoAtivo == null) ? 0 : codigoAtivo.hashCode());
		result = prime * result + ((dataCompra == null) ? 0 : dataCompra.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantidadeCotas == null) ? 0 : quantidadeCotas.hashCode());
		result = prime * result + ((valorCota == null) ? 0 : valorCota.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investimento other = (Investimento) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigoAtivo == null) {
			if (other.codigoAtivo != null)
				return false;
		} else if (!codigoAtivo.equals(other.codigoAtivo))
			return false;
		if (dataCompra == null) {
			if (other.dataCompra != null)
				return false;
		} else if (!dataCompra.equals(other.dataCompra))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidadeCotas == null) {
			if (other.quantidadeCotas != null)
				return false;
		} else if (!quantidadeCotas.equals(other.quantidadeCotas))
			return false;
		if (valorCota == null) {
			if (other.valorCota != null)
				return false;
		} else if (!valorCota.equals(other.valorCota))
			return false;
		return true;
	}
		
}
