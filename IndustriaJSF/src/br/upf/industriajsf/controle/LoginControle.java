package br.upf.industriajsf.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.ads.industria.model.beans.rh.Funcionario;
import br.upf.ads.industria.model.uteis.FabricaConexao;

@ManagedBean
@SessionScoped
public class LoginControle {

	public LoginControle() {
		super();
	}

	private String login;
	private String senha;
	private Funcionario funcionarioLogado = null;

	public String entrar() {
		EntityManager em = FabricaConexao.getEntityManager();
		Query qry = em.createQuery("from Funcionario where login = :login and senha = :senha");
		qry.setParameter("login", login);
		qry.setParameter("senha", senha);
		List<Funcionario> list = qry.getResultList();
		em.close();
		if (list.size() <= 0) {
			funcionarioLogado = null;
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					                    "Login ou senha inválida!", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";
		} else {
			funcionarioLogado = list.get(0);
			return "/faces/Sistema/Home/Home.xhtml";
		}
	}

	
	public String sair() {
		funcionarioLogado = null;
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				                    "Sessão do usuário encerrada!", "");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		return "/faces/Login/LoginForm.xhtml";
	}
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

}
