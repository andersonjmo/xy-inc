package enumType;

public enum Tipos {
	Inteiro("java.lang.Integer", "Integer"),
	String("java.lang.String","character varying"),
	Date("java.util.Date","timestamp"),
	Double("java.lang.Double","float");

	private String tipoJava;
	private String tipoBanco;
	
	Tipos(String tipoJava,String tipoBanco) {
		this.tipoJava = tipoJava;
		this.tipoBanco = tipoBanco;
	}

	public String getTipoJava() {
		return tipoJava;
	}

	public void setTipoJava(String tipoJava) {
		this.tipoJava = tipoJava;
	}

	public String getTipoBanco() {
		return tipoBanco;
	}

	public void setTipoBanco(String tipoBanco) {
		this.tipoBanco = tipoBanco;
	}
	
	

	
	
	
}
