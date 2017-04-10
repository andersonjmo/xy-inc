package model;

public class GenericAtribute {
	
	private String nome;
	private Class tipo;
	private Object valor;
	
	public GenericAtribute(String nome, Class tipo, Object valor) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}

	public GenericAtribute(String nome, Class tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Class getTipo() {
		return tipo;
	}

	public void setTipo(Class tipo) {
		this.tipo = tipo;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
	
		if(tipo.isAssignableFrom(valor.getClass())){
		this.valor = valor;
		}else{
			throw new ClassCastException("Tipos incompativeis de dados");
		}
		
	}
	
	

}
