package br.upf.ads.industria.model.beans.producao;

import br.upf.ads.industria.model.beans.estoque.MateriaPrima;
import br.upf.ads.industria.model.beans.producao.ProducaoLote;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: MateriaPrimaUsada
 *
 */
@Entity
@Table(schema = "producao")
public class MateriaPrimaUsada implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "MateriaPrimaUsadaId")
	@SequenceGenerator(name = "MateriaPrimaUsadaId", sequenceName = "MateriaPrimaUsadaId", allocationSize = 1, schema="producao")
	private Integer id;
	private Float quantidade;
	private Float custoUnitario;
	private Date dataUso;
	private Float custoTotal;
	@ManyToOne(optional = false)
	private ProducaoLote producaoLote;
	@ManyToOne(optional = false)
	private MateriaPrima materiaPrima;
	private static final long serialVersionUID = 1L;

	public MateriaPrimaUsada() {
		super();
		quantidade = 1F;
		dataUso = new Date();
	}   
	
	
	
	public MateriaPrimaUsada(Integer id, Float quantidade, Float custoUnitario, Date dataUso, Float custoTotal,
			ProducaoLote producaoLote, MateriaPrima materiaPrima) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.custoUnitario = custoUnitario;
		this.dataUso = dataUso;
		this.custoTotal = custoTotal;
		this.producaoLote = producaoLote;
		this.materiaPrima = materiaPrima;
	}



	public MateriaPrimaUsada(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Float getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}   
	public Float getCustoUnitario() {
		return this.custoUnitario;
	}

	public void setCustoUnitario(Float custoUnitario) {
		this.custoUnitario = custoUnitario;
	}   
	public Date getDataUso() {
		return this.dataUso;
	}

	public void setDataUso(Date dataUso) {
		this.dataUso = dataUso;
	}   
	public Float getCustoTotal() {
		return this.custoTotal;
	}

	public void setCustoTotal(Float custoTotal) {
		this.custoTotal = custoTotal;
	}   
	public ProducaoLote getProducaoLote() {
		return this.producaoLote;
	}

	public void setProducaoLote(ProducaoLote producaoLote) {
		this.producaoLote = producaoLote;
	}   
	public MateriaPrima getMateriaPrima() {
		return this.materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
   
}
