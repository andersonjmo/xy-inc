package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbAtributos")
@SequenceGenerator(name="tbAtributos_sq",initialValue=1,allocationSize=9999)
public class Atributos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="tbAtributos_sq")
	private Integer idAtributo;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Classes classe;
	
	private String tipoAtributo;
	
	private String nomeAtributo;
	
	

	
	
	public Atributos(Classes classe, String tipoAtributo,
			String nomeAtributo) {
		super();
		this.classe = classe;
		this.tipoAtributo = tipoAtributo;
		this.nomeAtributo = nomeAtributo;
	}

	
	public Atributos() {
		super();
	}


	public Integer getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(Integer id) {
		this.idAtributo = id;
	}

	public Classes getClasse() {
		return classe;
	}

	public void setClasse(Classes classe) {
		this.classe = classe;
	}

	public String getTipoAtributo() {
		return tipoAtributo;
	}

	public void setTipoAtributo(String tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
	}

	public String getNomeAtributo() {
		return nomeAtributo;
	}

	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}
	

}
