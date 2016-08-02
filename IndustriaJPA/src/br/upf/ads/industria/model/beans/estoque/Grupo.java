package br.upf.ads.industria.model.beans.estoque;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity
@Table(schema = "estoque")
public class Grupo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "GrupoId")
	@SequenceGenerator(name = "GrupoId", sequenceName = "GrupoId", allocationSize = 1, schema="estoque")
	private Integer id;
	@Length(min=2, max=60, message="O nome deve ter entre {min} e {max} caracteres!")
	@NotEmpty(message="O nome deve ser informado!")
	private String nome;
	private static final long serialVersionUID = 1L;

	public Grupo() {
		super();
	}   

	public Grupo(Integer id) {
		super();
		this.id = id;
	}
	
	public Grupo(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
   
}
