package br.com.everis.entradaraco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.everis.entradaraco.daofactory.ConexaoRACO;
import br.com.everis.entradaraco.modelo.EntradaRaco;

public class RacoDAO extends ConexaoRACO{

	private static final int queryTimeout = 3;

	public List<EntradaRaco> getEntradas() throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<EntradaRaco> entradas = new ArrayList<>();

		try {
			connection = getConnection();
			
			//connection = getConnectionAcessoLocal();
			
			
			String query = "SELECT t.ani, t.numeroAtendimento, t.nomeCliente, t.protocolo, "
					+ "t.cpf_cnpj, t.cpf_anioitv, t.numeroContratotv, "
					+ "t.segmento, t.produto, t.no_plano, t.ura_retencao, "
					+ "t.ura_entrada, t.ura_produto, t.ura_mailing, "
					+ "t.ura_contratacao90dias, t.ura_cancelamentoPrecoce, "
					+ "t.valor_ultimaConta, t.tipo_bloqueio, t.falha, "
					+ "t.uui, ROWIDTOCHAR(t.rowid) as id  FROM TB_DADOS_ENTRADA t";

			statement = connection.prepareStatement(query);
			statement.setQueryTimeout(queryTimeout);

			result = statement.executeQuery();

			while (result.next()) {
				EntradaRaco entradaRaco = new EntradaRaco();
				entradaRaco.setAni(result.getString("ANI"));
				entradaRaco.setCpfAniOiTv(result.getString("CPF_ANIOITV"));
				entradaRaco.setCpfCnpj(result.getString("CPF_CNPJ"));
				entradaRaco.setId(result.getString("ID"));
				entradaRaco.setNomeCliente(result.getString("NomeCliente"));
				entradaRaco.setNumeroContratoTv(result.getString("NUMEROCONTRATOTV"));
				entradaRaco.setNumeroTratado(result.getString("NUMEROATENDIMENTO"));
				entradaRaco.setProduto(result.getString("PRODUTO"));
				entradaRaco.setProtocolo(result.getString("PROTOCOLO"));
				entradaRaco.setSegmento(result.getString("SEGMENTO"));
				entradaRaco.setTipobloqueio(result.getString("TIPO_BLOQUEIO"));
				entradaRaco.setUraCancelamentoPrecoce(result.getString("URA_CANCELAMENTOPRECOCE"));
				entradaRaco.setUraContratacao90Dias(result.getString("URA_CONTRATACAO90DIAS"));
				entradaRaco.setUraEntrada(result.getString("URA_ENTRADA"));
				entradaRaco.setUraMailing(result.getString("URA_MAILING"));
				entradaRaco.setUraProduto(result.getString("URA_PRODUTO"));
				entradaRaco.setUraRetencao(result.getString("URA_RETENCAO"));
				entradaRaco.setUui(result.getString("UUI"));
				entradaRaco.setValorUltimaConta(result.getString("VALOR_ULTIMACONTA"));
				entradaRaco.setNoPlano(result.getString("NO_PLANO"));
				entradaRaco.setFalha(result.getString("FALHA"));
				
				entradas.add(entradaRaco);
			}

		} catch (Exception exception) {
			throw exception;
		} finally {
			closeResultSet(result);
			closePreparedStatement(statement);
			closeConnection(connection);
		}

		return entradas;
	}

	
	public boolean atualizarDadosDeEntrada(EntradaRaco entradaRaco) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean retorno = false;

		try {
			connection = getConnection();
			
			//connection = getConnectionAcessoLocal();
			
			String query = "UPDATE TB_DADOS_ENTRADA t SET t.ani = ?, t.numeroAtendimento = ?, t.nomeCliente = ?, t.protocolo = ?, "
					+ "t.cpf_cnpj = ?, t.cpf_anioitv = ?, t.numeroContratotv = ?, "
					+ "t.segmento = ?, t.produto = ?, t.no_plano = ?, t.ura_retencao = ?, "
					+ "t.ura_entrada = ?, t.ura_produto = ?, t.ura_mailing = ?, "
					+ "t.ura_contratacao90dias = ?, t.ura_cancelamentoPrecoce = ?, "
					+ "t.valor_ultimaConta = ?, t.tipo_bloqueio = ?, t.falha = ?, "
					+ "t.uui = ?  WHERE ROWIDTOCHAR(t.rowid) = CHARTOROWID(?)";

			statement = connection.prepareStatement(query);
			statement.setString(1, entradaRaco.getAni());
			statement.setString(2, entradaRaco.getNumeroTratado());
			statement.setString(3, entradaRaco.getNomeCliente());
			statement.setString(4, entradaRaco.getProtocolo());
			statement.setString(5, entradaRaco.getCpfCnpj());
			statement.setString(6, entradaRaco.getCpfAniOiTv());
			statement.setString(7, entradaRaco.getNumeroContratoTv());
			statement.setString(8, entradaRaco.getSegmento());
			statement.setString(9, entradaRaco.getProduto());
			statement.setString(10, entradaRaco.getNoPlano());
			statement.setString(11, entradaRaco.getUraRetencao());
			statement.setString(12, entradaRaco.getUraEntrada());
			statement.setString(13, entradaRaco.getUraProduto());
			statement.setString(14, entradaRaco.getUraMailing());
			statement.setString(15, entradaRaco.getUraContratacao90Dias());
			statement.setString(16, entradaRaco.getUraCancelamentoPrecoce());
			statement.setString(17, entradaRaco.getValorUltimaConta());
			statement.setString(18, entradaRaco.getTipobloqueio());
			statement.setString(19, entradaRaco.getFalha());
			statement.setString(20, entradaRaco.getUui());
			statement.setString(21, entradaRaco.getId());
			
			retorno = statement.executeUpdate() >= 0;

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			closePreparedStatement(statement);
			closeConnection(connection);
		}
		return retorno;
	}
	
	public EntradaRaco getEntradaByRowId(String id) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		EntradaRaco entradaRaco = null;

		try {
			connection = getConnection();
			
			//connection = getConnectionAcessoLocal();
			
			String query = "SELECT t.ani, t.numeroAtendimento, t.nomeCliente, t.protocolo, "
					+ "t.cpf_cnpj, t.cpf_anioitv, t.numeroContratotv, "
					+ "t.segmento, t.produto, t.no_plano, t.ura_retencao, "
					+ "t.ura_entrada, t.ura_produto, t.ura_mailing, "
					+ "t.ura_contratacao90dias, t.ura_cancelamentoPrecoce, "
					+ "t.valor_ultimaConta, t.tipo_bloqueio, t.falha, "
					+ "t.uui, ROWIDTOCHAR(t.rowid) as id  FROM TB_DADOS_ENTRADA t WHERE ROWIDTOCHAR(t.rowid) = CHARTOROWID(?)";

			statement = connection.prepareStatement(query);
			statement.setQueryTimeout(queryTimeout);
			
			statement.setString(1, id);
			result = statement.executeQuery();

			if (result.next()) {
				entradaRaco = new EntradaRaco();
				entradaRaco.setAni(result.getString("ANI"));
				entradaRaco.setCpfAniOiTv(result.getString("CPF_ANIOITV"));
				entradaRaco.setCpfCnpj(result.getString("CPF_CNPJ"));
				entradaRaco.setId(result.getString("ID"));
				entradaRaco.setNomeCliente(result.getString("NomeCliente"));
				entradaRaco.setNumeroContratoTv(result.getString("NUMEROCONTRATOTV"));
				entradaRaco.setNumeroTratado(result.getString("NUMEROATENDIMENTO"));
				entradaRaco.setProduto(result.getString("PRODUTO"));
				entradaRaco.setProtocolo(result.getString("PROTOCOLO"));
				entradaRaco.setSegmento(result.getString("SEGMENTO"));
				entradaRaco.setTipobloqueio(result.getString("TIPO_BLOQUEIO"));
				entradaRaco.setUraCancelamentoPrecoce(result.getString("URA_CANCELAMENTOPRECOCE"));
				entradaRaco.setUraContratacao90Dias(result.getString("URA_CONTRATACAO90DIAS"));
				entradaRaco.setUraEntrada(result.getString("URA_ENTRADA"));
				entradaRaco.setUraMailing(result.getString("URA_MAILING"));
				entradaRaco.setUraProduto(result.getString("URA_PRODUTO"));
				entradaRaco.setUraRetencao(result.getString("URA_RETENCAO"));
				entradaRaco.setUui(result.getString("UUI"));
				entradaRaco.setValorUltimaConta(result.getString("VALOR_ULTIMACONTA"));
				entradaRaco.setNoPlano(result.getString("NO_PLANO"));
				entradaRaco.setFalha(result.getString("FALHA"));
				
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			closeResultSet(result);
			closePreparedStatement(statement);
			closeConnection(connection);
		}

		return entradaRaco;
	}
	
	public void inserirNovaEntrada(EntradaRaco entradaRaco) throws Exception{
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			connection = getConnection();
			
			//connection = getConnectionAcessoLocal();
			
			String sql = "INSERT INTO TB_DADOS_ENTRADA  (ani, "
													  + "numeroAtendimento, nomeCliente, "
													  + "protocolo, cpf_cnpj, cpf_anioitv, "
													  + "numeroContratotv, segmento, produto, "
													  + "no_plano, ura_retencao, ura_entrada, "
													  + "ura_produto, ura_mailing, ura_contratacao90dias, "
													  + "ura_cancelamentoPrecoce, valor_ultimaConta, "
													  + "tipo_bloqueio, falha, uui) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, entradaRaco.getAni());
			statement.setString(2, entradaRaco.getNumeroTratado());
			statement.setString(3, entradaRaco.getNomeCliente());
			statement.setString(4, entradaRaco.getProtocolo());
			statement.setString(5, entradaRaco.getCpfCnpj());
			statement.setString(6, entradaRaco.getCpfAniOiTv());
			statement.setString(7, entradaRaco.getNumeroContratoTv());
			statement.setString(8, entradaRaco.getSegmento());
			statement.setString(9, entradaRaco.getProduto());
			statement.setString(10, entradaRaco.getNoPlano());
			statement.setString(11, entradaRaco.getUraRetencao());
			statement.setString(12, entradaRaco.getUraEntrada());
			statement.setString(13, entradaRaco.getUraProduto());
			statement.setString(14, entradaRaco.getUraMailing());
			statement.setString(15, entradaRaco.getUraContratacao90Dias());
			statement.setString(16, entradaRaco.getUraCancelamentoPrecoce());
			statement.setString(17, entradaRaco.getValorUltimaConta());
			statement.setString(18, entradaRaco.getTipobloqueio());
			statement.setString(19, entradaRaco.getFalha());
			statement.setString(20, entradaRaco.getUui());
			
			statement.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("ERROR: " + e.toString());
			throw e;
		}finally {
			statement.close();
			connection.close();
		}
	}
	
}
