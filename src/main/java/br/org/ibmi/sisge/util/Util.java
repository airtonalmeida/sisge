package br.org.ibmi.sisge.util;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;


public class Util implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Double converteStringDouble (String valor){
		DecimalFormat formato = new DecimalFormat("");
		
		Double valorDouble = null;
		
		try {
			formato.applyLocalizedPattern("#.#00,0#");
			valorDouble = formato.parse(valor).doubleValue();
			
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
							
		return valorDouble;
			
	}
	
		
	public String converteDoubleString (Double valor){
		
		NumberFormat df = NumberFormat.getCurrencyInstance();
		
		String dx = df.format(valor);
							
		return dx.substring(3);	
		
	}
	
	
}
