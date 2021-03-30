package br.com.everis.entradaraco.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.everis.entradaraco.dao.RacoDAO;
import br.com.everis.entradaraco.modelo.EntradaRaco;

public class EntradaRacoConverter implements Converter<String, EntradaRaco>{
	
	private RacoDAO racoDao = new RacoDAO();
	
	@Override
	public EntradaRaco convert(String source) {
		if(!StringUtils.isEmpty(source)) {
			
			EntradaRaco entrada = null;
			try {
				entrada = racoDao.getEntradaByRowId(source);
			} catch (Exception e) {
				System.out.println("Erro na conversão");
				e.printStackTrace();
			}
			
			return entrada;
		}
		
		return null;
	}

}
