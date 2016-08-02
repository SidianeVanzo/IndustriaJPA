package br.upf.ads.industria.model.beans.qualidade;

import br.upf.ads.industria.model.beans.producao.ProducaoLote;
import br.upf.ads.industria.model.beans.rh.Funcionario;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Character;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AnaliseLoteProduzido
 *
 */
@Entity
@Table(schema = "qualidade")
public class AnaliseLoteProduzido implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AnaliseLoteProduzidoId")
	@SequenceGenerator(name = "AnaliseLoteProduzidoId", sequenceName = "AnaliseLoteProduzidoId", allocationSize = 1, schema="qualidade")
	private Integer id;
	private Date data;
	private Character aprovadoReprovado;
	private String observacoes;
	@OneToOne(optional = false)
	private Funcionario funcionario;
	@OneToOne(optional = false)
	private ProducaoLote producaoLote;
	private static final long serialVersionUID = 1L;

	public AnaliseLoteProduzido() {
		super();
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
	public Character getAprovadoReprovado() {
		return this.aprovadoReprovado;
	}

	public void setAprovadoReprovado(Character aprovadoReprovado) {
		this.aprovadoReprovado = aprovadoReprovado;
	}   
	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}   
	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}   
	public ProducaoLote getProducaoLote() {
		return this.producaoLote;
	}

	public void setProducaoLote(ProducaoLote producaoLote) {
		this.producaoLote = producaoLote;
	}
   
}
