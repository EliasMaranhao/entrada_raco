package br.com.everis.entradaraco.service;

import java.util.List;

import br.com.everis.entradaraco.dao.RacoDAO;
import br.com.everis.entradaraco.modelo.EntradaRaco;

public class RacoService {
	
	private RacoDAO racoDao = new RacoDAO();
	
	public void salvar(EntradaRaco entradaRaco) throws Exception{
		if(!"".equals(entradaRaco.getId()) && entradaRaco.getId() != null) 
			racoDao.atualizarDadosDeEntrada(entradaRaco);
		
		else
			racoDao.inserirNovaEntrada(entradaRaco);
	}
	
	public List<EntradaRaco> getEntradas()throws Exception{
		return racoDao.getEntradas();
	}
	
	public EntradaRaco getEntradaByRowId(String rowId) throws Exception{
		return racoDao.getEntradaByRowId(rowId);
	}
}
