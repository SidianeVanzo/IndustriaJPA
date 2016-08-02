package br.upf.ads.industria.model.beans.geral;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Table(schema = "geral")
@Inheritance(strategy = JOINED)
public abstract class Pessoa implements Serializable {
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "PessoaId")
	@SequenceGenerator(name = "PessoaId", sequenceName = "PessoaId", allocationSize = 1, schema="geral")
	private Integer id;
	@NotEmpty
	@Length(min=2, max=60, message="O nome deve ter entre {min} e {max} caracteres!")
	private String nome;
	@NotEmpty(message="É preciso informar o endereço!")
	@Length(max=60)
	private String endereco;
	@Length(max=10)
	private String numero;
	@Length(max=40)
	private String complemento;
	@Length(max=40)
	private String bairro;
	@Length(max=10)
	private String cep;
	@Email(message="O e-mail não é válido!")
	@Length(max=80)
	private String email;
	@Length(max=20)
	private String telefone;
	@ManyToOne(optional = false)
	@NotNull(message="Deve informar a cidade!")
	private Cidade cidade;
	private static final long serialVersionUID = 1L;

	public Pessoa() {
		super();
	}
	
	public Pessoa(Integer id, String nome, String endereco, String numero, String complemento, String bairro,
			String cep, String email, String telefone, Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.email = email;
		this.telefone = telefone;
		this.cidade = cidade;
	}



	public Pessoa(Integer id) {
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
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}   
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}   
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}   
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}   
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}   
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
   
}
