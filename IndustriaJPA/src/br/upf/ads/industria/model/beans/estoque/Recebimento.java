package br.upf.ads.industria.model.beans.estoque;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.upf.ads.industria.model.beans.geral.PessoaJuridica;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Entity implementation class for Entity: Recebimento
 *
 */
@Entity
@Table(schema = "estoque")
public class Recebimento implements Serializable {
   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "RecebimentoId")
	@SequenceGenerator(name = "RecebimentoId", sequenceName = "RecebimentoId", allocationSize = 1, schema="estoque")
	private Integer id;
	@Past(message="A data de recebimento deve estar no passado!")
	@NotNull(message="A data de recebimento deve ser informada!")
	@Temporal(TIMESTAMP)
	private Date data;
	@Length(max=10)
	@NotEmpty(message="O número da nota deve ser informado!")
	private String numeroNota;
	
	@DecimalMin(value="0", inclusive=false, message="O total de produtos deve ser superior a zero!")
	@NotNull(message="O total de produtos deve ser inicializado!")
	private Float totalProdutos;
	@Min(value=0, message="O valor do frete deve ser igual ou superior a zero!")
	@NotNull(message="O valor do frete deve ser informado!")
	private Float valorFrete;
	@DecimalMin(value="0", inclusive=false, message="O total da compra deve ser superior a zero!")
	@NotNull(message="O total da compra deve ser inicializado!")
	private Float totalCompra;
	@ManyToOne(optional = false)
	@NotNull(message="O fornecedor deve ser informado!")
	private PessoaJuridica fornecedor;
	@NotNull(message="Os itens recebidos devem ser inicializados!")
	@Size(min=1, message="Deve ter pelo menos um ítem recebido!")
	@Valid
	@OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "recebimento", fetch=FetchType.EAGER)
	private List<RecebimentoItem> itensRecebidos;
	private static final long serialVersionUID = 1L;

	public Recebimento() {
		super();
		itensRecebidos = new ArrayList();
		data = new Date();
		totalCompra = 0F;
		totalProdutos = 0F;
		valorFrete = 0F;
	}   
	
	
	
	public Recebimento(Integer id, Date data, String numeroNota, Float totalProdutos, Float valorFrete,
			Float totalCompra, PessoaJuridica fornecedor, List<RecebimentoItem> itensRecebidos) {
		super();
		this.id = id;
		this.data = data;
		this.numeroNota = numeroNota;
		this.totalProdutos = totalProdutos;
		this.valorFrete = valorFrete;
		this.totalCompra = totalCompra;
		this.fornecedor = fornecedor;
		this.itensRecebidos = itensRecebidos;
	}



	public Recebimento(Integer id) {
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
	public Float getTotalProdutos() {
		return this.totalProdutos;
	}

	public void setTotalProdutos(Float totalProdutos) {
		this.totalProdutos = totalProdutos;
	}   
	public Float getValorFrete() {
		return this.valorFrete;
	}

	public void setValorFrete(Float valorFrete) {
		this.valorFrete = valorFrete;
	}   
	public Float getTotalCompra() {
		
		return this.totalCompra;
	}

	public void setTotalCompra(Float totalCompra) {
		this.totalCompra = totalCompra;
	}   
	public PessoaJuridica getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(PessoaJuridica fornecedor) {
		this.fornecedor = fornecedor;
	}   
	public List<RecebimentoItem> getItensRecebidos() {
		return this.itensRecebidos;
	}

	public void setItensRecebidos(List<RecebimentoItem> itensRecebidos) {
		this.itensRecebidos = itensRecebidos;
	}
   
}
