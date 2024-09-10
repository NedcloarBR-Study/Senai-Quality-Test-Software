package aps1;

public class DataMatrix {
	private String code;
	private boolean isValid;
	private String code_med;
	private int dt_producao;
	private String serial;
	private int lote;
	
	public DataMatrix(String code) {
		if(code == null || code.length() == 31) {
		this.setCode(code);
		this.setIsValid(code);
		this.setCode_med(code.substring(0,13));
		this.setDt_producao(code.substring(14,19));
		this.setSerial(code.substring(20,24));
		this.setLote(code.substring(25,30));
		}else {
			this.isValid =false;
		}
	}

	public boolean validateLength(String code) {
//		System.out.println(code.length() == 31);
		return code.length() == 31;
	}
	
	public boolean isNumber(String code) {
		try {
			Double.parseDouble(code);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean getIsValid() {
		return this.isValid;
	}
	
	public void setIsValid(String code) {
		this.isValid = this.validateLength(code);
	}
	
	public String getCode_med() {
		return code_med;
	}

	public void setCode_med(String code_med) {
		this.code_med = code_med;
	}

	public int getDt_producao() {
		return dt_producao;
	}

	public void setDt_producao(String dt_producao) {
		if(this.isNumber(dt_producao)) {
			this.dt_producao = Integer.parseInt(dt_producao);
		} 
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public int getLote() {
		return this.lote;
	}

	public void setLote(String lote) {
		if(this.isNumber(lote)) {
			this.lote = Integer.parseInt(lote);
		} 
	}

	@Override
	public String toString() {
		return "DataMatrix [code=" + this.getCode() + ", isValid=" + this.getIsValid() + ", code_med=" + this.getCode_med() + ", dt_producao=" + this.getDt_producao()+ ", serial="
				+ this.getSerial() + ", lote=" + this.getLote() + "]";
	}
	
	
}
