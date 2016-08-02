package br.upf.ads.industria.model.beans.rh;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

import br.upf.ads.industria.model.beans.geral.PessoaFisica;
import br.upf.ads.industria.model.constraints.SexoValido;

/**
 * Entity implementation class for Entity: Funcionario
 *
 */
@Entity
@Table(schema = "rh")
public class Funcionario extends PessoaFisica implements Serializable {
	private String login;
	private String senha;
	private Boolean ativo;
	private Date dataAdmissao;
	private Date dataDemissao;
	@SexoValido(message="O sexo deve ser válido!")
	private Character sexo;
	private String estadoCivil;
	private String numeroCtps;
	private String serieCtps;
	private static final long serialVersionUID = 1L;

	public Funcionario() {
		super();
		ativo = true;
		sexo = 'M';
		estadoCivil = "Solteiro(a)";
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}   
	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}   
	public Date getDataAdmissao() {
		return this.dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}   
	public Date getDataDemissao() {
		return this.dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}   
	public Character getSexo() {
		return this.sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}   
	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}   
	public String getNumeroCtps() {
		return this.numeroCtps;
	}

	public void setNumeroCtps(String numeroCtps) {
		this.numeroCtps = numeroCtps;
	}   
	public String getSerieCtps() {
		return this.serieCtps;
	}

	public void setSerieCtps(String serieCtps) {
		this.serieCtps = serieCtps;
	}
   
}
