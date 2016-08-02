package br.upf.ads.industria.model.beans.geral;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.upf.ads.industria.model.constraints.SexoValido;
import br.upf.ads.industria.model.constraints.StringOptionsValid;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: Cidade
 *
 */
@Entity
@Table(schema = "geral")
public class Cidade implements Serializable {
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "CidadeId")
	@SequenceGenerator(name = "CidadeId", sequenceName = "CidadeId", allocationSize = 1, schema="geral")
	private Integer id;
	@NotEmpty(message="A UF é obrigatória!")
	@Length(min=2, max=2, message="A UF deve ter dois caracteres!")
	@StringOptionsValid(message="Opção inválida na UF!", 
	                    opcoes={"RS", "SC", "PR", "SP", "MG"})
	private String uf;
	@Length(min=2, max=50, message="O nome deve ter entre {min} e {max} caracteres!")
	private String nome;
	private static final long serialVersionUID = 1L;

	public Cidade() {
		super();
		uf = "RS";
	}   
	
	public Cidade(Integer id) {
		super();
		this.id = id;
	}

	public Cidade(Integer id, String nome, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



   
}
