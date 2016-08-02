package br.upf.ads.industria.model.beans.estoque;

import java.io.Serializable;
import java.lang.Float;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.upf.ads.industria.model.beans.estoque.Produto;

/**
 * Entity implementation class for Entity: MateriaPrima
 *
 */
@Entity
@Table(schema = "estoque")
public class MateriaPrima extends Produto implements Serializable {

	@NotNull(message="� preciso informar o estoque m�nimo!")
	@Min(value=0, message="� preciso informar o estoque m�nimo igual ou superior a zero!")
	private Float estoqueMinimo;
	@NotNull(message="� preciso inicializar o �ltimo custo!")
	@Min(value=0, message="� preciso inicializar o �ltimo custo igual ou superior a zero!")
	private Float ultimoCusto;
	@NotNull(message="� preciso inicializar o custo m�dio!")
	@Min(value=0, message="� preciso inicializar o custo m�dio igual ou superior a zero!")
	private Float custoMedio;
	private static final long serialVersionUID = 1L;

	public MateriaPrima() {
		super();
		estoqueMinimo = 0F;
		ultimoCusto = 0F;
		custoMedio = 0F;
	}   
	public Float getEstoqueMinimo() {
		return this.estoqueMinimo;
	}

	public void setEstoqueMinimo(Float estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}   
	public Float getUltimoCusto() {
		return this.ultimoCusto;
	}

	public void setUltimoCusto(Float ultimoCusto) {
		this.ultimoCusto = ultimoCusto;
	}   
	public Float getCustoMedio() {
		return this.custoMedio;
	}

	public void setCustoMedio(Float custoMedio) {
		this.custoMedio = custoMedio;
	}
   
}
