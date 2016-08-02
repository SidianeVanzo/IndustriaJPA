package br.upf.ads.industria.model.beans.estoque;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.upf.ads.industria.model.beans.geral.Pessoa;
import br.upf.ads.industria.model.beans.producao.ProducaoLote;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: Entrega
 *
 */
@Entity
@Table(schema = "estoque") 
public class Entrega implements Serializable {
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "EntregaId")
	@SequenceGenerator(name = "EntregaId", sequenceName = "EntregaId", allocationSize = 1, schema="estoque")
	private Integer id;
	@NotNull(message="A data deve ser informada!")
	@Temporal(DATE)
	private Date data;
	@NotEmpty(message="O número da nota deve ser informado!")
	@Length(max=10)
	private String numeroNota;
	@NotNull(message="A quantidade deve ser informada!")
	@DecimalMin(value="0", inclusive=false, message="A quantidade deve ser superior a zero!")
	private Float quantidade;
	@NotNull(message="O cliente deve ser informado!")
	@ManyToOne(optional = false)
	private Pessoa cliente;
	@ManyToOne(optional = false)
	@NotNull(message="O produto deve ser informado!")
	private ProdutoAcabado produtoAcabado;
	@ManyToOne(optional = false)
	@NotNull(message="O lote deve ser informado!")
	private ProducaoLote lote;
	private static final long serialVersionUID = 1L;

	public Entrega() {
		super();
		data = new Date();
	}
	
	
	
	public Entrega(Integer id, Date data, String numeroNota, Float quantidade, Pessoa cliente,
			ProdutoAcabado produtoAcabado, ProducaoLote lote) {
		super();
		this.id = id;
		this.data = data;
		this.numeroNota = numeroNota;
		this.quantidade = quantidade;
		this.cliente = cliente;
		this.produtoAcabado = produtoAcabado;
		this.lote = lote;
	}



	public Entrega(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}   
	public String getNumeroNota() {
		return this.numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}   
	public Float getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}   
	public Pessoa getCliente() {
		return this.cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}   
	public ProdutoAcabado getProdutoAcabado() {
		return this.produtoAcabado;
	}

	public void setProdutoAcabado(ProdutoAcabado produtoAcabado) {
		this.produtoAcabado = produtoAcabado;
	}   
	public ProducaoLote getLote() {
		return this.lote;
	}

	public void setLote(ProducaoLote lote) {
		this.lote = lote;
	}
   
}
