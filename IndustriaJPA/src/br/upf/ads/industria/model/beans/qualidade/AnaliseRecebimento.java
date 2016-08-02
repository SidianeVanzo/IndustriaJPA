package br.upf.ads.industria.model.beans.qualidade;

import br.upf.ads.industria.model.beans.estoque.RecebimentoItem;
import br.upf.ads.industria.model.beans.rh.Funcionario;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Character;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AnaliseRecebimento
 *
 */
@Entity
@Table(schema = "qualidade")
public class AnaliseRecebimento implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AnaliseRecebimentoId")
	@SequenceGenerator(name = "AnaliseRecebimentoId", sequenceName = "AnaliseRecebimentoId", allocationSize = 1, schema="qualidade")
	private Integer id;
	private Date data;
	private Character aprovadoReprovado;
	private String observacoes;
	@ManyToOne
	private Funcionario funcionario;
	@OneToOne(optional = false)
	private RecebimentoItem recebimentoItem;
	private static final long serialVersionUID = 1L;

	public AnaliseRecebimento() {
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
	public RecebimentoItem getRecebimentoItem() {
		return this.recebimentoItem;
	}

	public void setRecebimentoItem(RecebimentoItem recebimentoItem) {
		this.recebimentoItem = recebimentoItem;
	}
   
}
