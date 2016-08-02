package br.upf.ads.industria.model.beans.estoque;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Produto
 *
 */
@Entity
@Table(schema = "estoque")
@Inheritance(strategy = JOINED)
public abstract class Produto implements Serializable {

	   
	@Id
	@GeneratedValue(generator = "ProdutoId", strategy = SEQUENCE)
	@SequenceGenerator(name = "ProdutoId", sequenceName = "ProdutoId", allocationSize = 1, schema="estoque")
	private Integer id;
	@Length(min=2, max=60, message="O nome deve ter entre {min} e {max} caracteres!")
	@NotEmpty(message="O nome deve ser informado!")
	private String nome;
	@Length(max=10)
	@NotEmpty(message="A unidade de estoque deve ser informada!")
	private String unidadeEstoque;
	
	@NotNull(message="É preciso inicializar a quantidade em estoque!")
	@Min(value=0)
	@Column(updatable = false)
	private Float quantidadeEstoque;
	@ManyToOne(optional = false)
	@NotNull(message="É preciso informar o grupo!")
	private Grupo grupo;
	private static final long serialVersionUID = 1L;

	public Produto() {
		super();
		quantidadeEstoque = 0F;
	}   
	
	
	
	public Produto(Integer id, String nome, String unidadeEstoque, Float quantidadeEstoque, Grupo grupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.unidadeEstoque = unidadeEstoque;
		this.quantidadeEstoque = quantidadeEstoque;
		this.grupo = grupo;
	}



	public Produto(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getUnidadeEstoque() {
		return this.unidadeEstoque;
	}

	public void setUnidadeEstoque(String unidadeEstoque) {
		this.unidadeEstoque = unidadeEstoque;
	}   
	public Float getQuantidadeEstoque() {
		return this.quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Float quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
   
}
