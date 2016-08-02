package br.upf.ads.industria.model.beans.producao;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import br.upf.ads.industria.model.beans.estoque.ProdutoAcabado;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: ProducaoLote
 *
 */
@Entity
@Table(schema = "producao")
public class ProducaoLote implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ProducaoLoteId")
	@SequenceGenerator(name = "ProducaoLoteId", sequenceName = "ProducaoLoteId", allocationSize = 1, schema="producao")
	private Integer id;
	private Date dataInicioProducao;
	private Float custoMateriaPrima;
	private Date dataFinalProducao;
	private Float quantidadeProduzida;
	private Float custoUnitario;
	@ManyToOne(optional = false)
	private ProdutoAcabado produtoAcabado;
	@OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "producaoLote")
	private List<MateriaPrimaUsada> materiaPrimaUsada;
	private static final long serialVersionUID = 1L;

	public ProducaoLote() {
		super();
		dataInicioProducao = new Date();
		quantidadeProduzida = 0F;
		custoUnitario = 0F;
	}

	
	
	public ProducaoLote(Integer id, Date dataInicioProducao, Float custoMateriaPrima, Date dataFinalProducao,
			Float quantidadeProduzida, Float custoUnitario, ProdutoAcabado produtoAcabado,
			List<MateriaPrimaUsada> materiaPrimaUsada) {
		super();
		this.id = id;
		this.dataInicioProducao = dataInicioProducao;
		this.custoMateriaPrima = custoMateriaPrima;
		this.dataFinalProducao = dataFinalProducao;
		this.quantidadeProduzida = quantidadeProduzida;
		this.custoUnitario = custoUnitario;
		this.produtoAcabado = produtoAcabado;
		this.materiaPrimaUsada = materiaPrimaUsada;
	}



	public ProducaoLote(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInicioProducao() {
		return dataInicioProducao;
	}

	public void setDataInicioProducao(Date dataInicioProducao) {
		this.dataInicioProducao = dataInicioProducao;
	}

	public Float getCustoMateriaPrima() {
		return custoMateriaPrima;
	}

	public void setCustoMateriaPrima(Float custoMateriaPrima) {
		this.custoMateriaPrima = custoMateriaPrima;
	}

	public Date getDataFinalProducao() {
		return dataFinalProducao;
	}

	public void setDataFinalProducao(Date dataFinalProducao) {
		this.dataFinalProducao = dataFinalProducao;
	}

	public Float getQuantidadeProduzida() {
		return quantidadeProduzida;
	}

	public void setQuantidadeProduzida(Float quantidadeProduzida) {
		this.quantidadeProduzida = quantidadeProduzida;
	}

	public Float getCustoUnitario() {
		return custoUnitario;
	}

	public void setCustoUnitario(Float custoUnitario) {
		this.custoUnitario = custoUnitario;
	}

	public ProdutoAcabado getProdutoAcabado() {
		return produtoAcabado;
	}

	public void setProdutoAcabado(ProdutoAcabado produtoAcabado) {
		this.produtoAcabado = produtoAcabado;
	}

	public List<MateriaPrimaUsada> getMateriaPrimaUsada() {
		return materiaPrimaUsada;
	}

	public void setMateriaPrimaUsada(List<MateriaPrimaUsada> materiaPrimaUsada) {
		this.materiaPrimaUsada = materiaPrimaUsada;
	}   
   
}
