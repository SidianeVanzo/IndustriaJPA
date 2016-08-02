package br.upf.ads.industria.model.beans.estoque;

import java.io.Serializable;
import java.lang.Float;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.upf.ads.industria.model.beans.estoque.Produto;

/**
 * Entity implementation class for Entity: ProdutoAcabado
 *
 */
@Entity
@Table(schema = "estoque")
public class ProdutoAcabado extends Produto implements Serializable {

	@NotNull(message="É preciso inicializar a quantidade em produção!")
	@Min(value=0, message="É preciso inicializar a quantidade em produção igual ou superior a zero!")
	@Column(updatable = false)
	private Float quantidadeEmProducao;
	
	@NotNull(message="É preciso inicializar a quantidade para entrega!")
	@Min(value=0, message="É preciso inicializar a quantidade para entrega igual ou superior a zero!")
	@Column(updatable = false)
	private Float quantidadeParaEntrega;
	private static final long serialVersionUID = 1L;

	public ProdutoAcabado() {
		super();
		quantidadeEmProducao = 0F;
		quantidadeParaEntrega = 0F;
	}   
	public Float getQuantidadeEmProducao() {
		return this.quantidadeEmProducao;
	}

	public void setQuantidadeEmProducao(Float quantidadeEmProducao) {
		this.quantidadeEmProducao = quantidadeEmProducao;
	}   
	public Float getQuantidadeParaEntrega() {
		return this.quantidadeParaEntrega;
	}

	public void setQuantidadeParaEntrega(Float quantidadeParaEntrega) {
		this.quantidadeParaEntrega = quantidadeParaEntrega;
	}
   
}
