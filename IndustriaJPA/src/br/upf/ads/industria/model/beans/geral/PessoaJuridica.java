package br.upf.ads.industria.model.beans.geral;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import br.upf.ads.industria.model.beans.geral.Pessoa;

import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: PessoaJuridica
 *
 */
@Entity
@Table(schema = "geral")
public class PessoaJuridica extends Pessoa implements Serializable {

	@Length(min=18, max=18, message="O CNPJ deve ter entre {min} e {max} caracteres!")
	@NotEmpty(message="Deve informar o CNPJ!")
	@CNPJ(message="O CNPJ é inválido!")
	private String cnpj;
	@Length(max=20)
	@NotEmpty(message="Deve informar a inscrição estadual!")
	private String ie;
	@Past(message="A data de constituição deve estar no passado!")
	@NotNull(message="A data de constituição deve ser informada!")
	@Temporal(DATE)
	private Date dataConstituicao;
	private static final long serialVersionUID = 1L;

	public PessoaJuridica() {
		super();
	}   
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}   
	public String getIe() {
		return this.ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}   
	public Date getDataConstituicao() {
		return this.dataConstituicao;
	}

	public void setDataConstituicao(Date dataconstituicao) {
		this.dataConstituicao = dataconstituicao;
	}
   
}
