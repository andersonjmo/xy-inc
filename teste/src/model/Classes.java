package model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbClasses")
@SequenceGenerator(name="tbClasses_sq", initialValue=1, allocationSize=9999)
public class Classes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="tbClasses_sq")
	private Integer id;
	
	private String nomeClasse;

	@OneToMany(mappedBy="classe",cascade={CascadeType.ALL})
	private Collection<Atributos> atributos;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	public Collection<Atributos> getAtributos() {
		return atributos;
	}

	public void setAtributos(Collection<Atributos> atributos) {
		this.atributos = atributos;
	}
	
	
}
