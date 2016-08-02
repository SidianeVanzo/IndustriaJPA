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

import br.upf.ads.industria.model.beans.estoque.Grupo;
import br.upf.ads.industria.model.uteis.FabricaConexao;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@RequestScoped
public class ProdutoAcabadoRel {

	
private Grupo grupo;
	
	public void executaRelatorio(){
        try { 
            HashMap parameters = new HashMap(); 
            // passar a grupo por parâmetro para o relatório
            parameters.put("GRUPO", grupo.getId()); 
            
            FacesContext facesContext = FacesContext.getCurrentInstance(); 
            facesContext.responseComplete(); 
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext(); 
            Connection con = FabricaConexao.getEntityManagerJDBCConnection(); 
            JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath( 
                       "/WEB-INF/Relatorios/ProdutoAcabado/ProdutoAcabado.jasper"), parameters, con); 
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
	
	 public List<Grupo> completeGrupo(String query) {
		 EntityManager em = FabricaConexao.getEntityManager();
		  List<Grupo> results = em.createQuery(
		  "from Grupo where upper(nome) like "+
		 "'"+query.trim().toUpperCase()+"%' "+
		  "order by nome").getResultList();
		  em.close();
		  return results;
	 }

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	 
	 

}
