package br.upf.industriajsf.relatorios;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import br.upf.ads.industria.model.beans.geral.Cidade;
import br.upf.ads.industria.model.uteis.FabricaConexao;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@RequestScoped
public class PessoaJuridicaRel {

	private Cidade cidade;
	
	public void executaRelatorio(){
        try { 
            HashMap parameters = new HashMap(); 
            // passar a cidade por parâmetro para o relatório
            parameters.put("cidade_id", cidade.getId()); 
            
            FacesContext facesContext = FacesContext.getCurrentInstance(); 
            facesContext.responseComplete(); 
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext(); 
            Connection con = FabricaConexao.getEntityManagerJDBCConnection(); 
            JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath( 
                       "/WEB-INF/Relatorios/PessoaJuridica/PessoaJuridica.jasper"), parameters, con); 
            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint); 
            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            res.setContentType("application/pdf"); 
            res.setHeader("Content-disposition", "inline;filename=arquivo.pdf"); // diretamente na página    
            //res.setHeader("Content-disposition", "attachment;filename=arquivo.pdf");// baixar ou salvar 
            res.getOutputStream().write(b); 
            res.getCharacterEncoding(); 
            FacesContext.getCurrentInstance().responseComplete(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 		
		
	}
	
	 public List<Cidade> completeCidade(String query) {
		 EntityManager em = FabricaConexao.getEntityManager();
		  List<Cidade> results = em.createQuery(
		  "from Cidade where upper(nome) like "+
		 "'"+query.trim().toUpperCase()+"%' "+
		  "order by nome").getResultList();
		  em.close();
		  return results;
	 }

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
