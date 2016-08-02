package br.upf.ads.industria.model.beans.estoque;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: RecebimentoItem
 *
 */
@Entity
@Table(schema = "estoque")
public class RecebimentoItem implements Serializable {
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "RecebimentoItemId")
	@SequenceGenerator(name = "RecebimentoItemId", sequenceName = "RecebimentoItemId", allocationSize = 1, schema="estoque")
	private Integer id;
	@DecimalMin(value="0", inclusive=false, message="A quantidade deve ser superior a zero!")
	@NotNull(message="A quantidade deve ser inicializada!")
	private Float quantidade;
	@DecimalMin(value="0", inclusive=false, message="O valor unitário deve ser superior a zero!")
	@NotNull(message="O valor unitário deve ser inicializado!")
	private Float valorUnitario;
	//@DecimalMin(value="0", inclusive=false, message="O total deve ser superior a zero!")
	//@NotNull(message="O total deve ser inicializado!")
	@Transient
	private Float total;
	@ManyToOne(optional = false)
	@NotNull(message="O recebimento deve ser inicializado!")
	private Recebimento recebimento;
	@ManyToOne(optional = false)
	@NotNull(message="A matéria prima deve ser informada!")
	private MateriaPrima materiaPrima;
	private static final long serialVersionUID = 1L;

	public RecebimentoItem() {
		super();
		quantidade = 1F;
		valorUnitario = 0F;
	}   
	
	
	
	public RecebimentoItem(Integer id, Float quantidade, Float valorUnitario, Float total, Recebimento recebimento,
			MateriaPrima materiaPrima) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.total = total;
		this.recebimento = recebimento;
		this.materiaPrima = materiaPrima;
	}



	public RecebimentoItem(Integer id) {
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
	public Float getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}   
	public Float getTotal() {
		total = valorUnitario * quantidade;
		return this.total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}   
	public Recebimento getRecebimento() {
		return this.recebimento;
	}

	public void setRecebimento(Recebimento recebimento) {
		this.recebimento = recebimento;
	}   
	public MateriaPrima getMateriaPrima() {
		return this.materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
   
}
