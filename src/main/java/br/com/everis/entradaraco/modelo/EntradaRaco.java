package br.com.everis.entradaraco.modelo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EntradaRaco implements Serializable{
	
	private String id;
	
	@NotNull(message = "Informe o ANI")
	@NotEmpty(message = "Informe o ANI")
	private String ani;
	
	@NotNull(message = "Informe o Número tratado")
	@NotEmpty(message = "Informe o Número tratado")
	private String numeroTratado;
	
	@NotNull(message = "Informe o Nome do cliente")
	@NotEmpty(message = "Informe o Nome do cliente")
	private String nomeCliente;
	
	@NotNull(message = "Informe o Protocolo")
	@NotEmpty(message = "Informe o Protocolo")
	private String protocolo;
	
	@NotNull(message = "Informe o Cpf ou Cnpj")
	@NotEmpty(message = "Informe o Cpf ou Cnpj")
	private String cpfCnpj;
	
	private String cpfAniOiTv;
	private String numeroContratoTv;
	
	@NotNull(message = "Informe o Segmento")
	@NotEmpty(message = "Informe o Segmento")
	private String segmento;
	
	@NotNull(message = "Informe o Produto")
	@NotEmpty(message = "Informe o Produto")
	private String produto;
	
	@NotNull(message = "Informe a Ura retenção")
	@NotEmpty(message = "Informe a Ura retenção")
	private String uraRetencao;
	
	@NotNull(message = "Informe a Ura de entrada")
	@NotEmpty(message = "Informe a Ura de entrada")
	private String uraEntrada;
	
	@NotNull(message = "Informe a Ura produto")
	@NotEmpty(message = "Informe a Ura produto")
	private String uraProduto;
	
	
	@NotNull(message = "Informe se contratação 90 dias")
	@NotEmpty(message = "Informe se contratação 90 dias")
	private String uraContratacao90Dias;
	
	
	private String uraMailing;
	
	@NotNull(message = "Informe se cancelamento precoce")
	@NotEmpty(message = "Informe se cancelamento precoce")
	private String uraCancelamentoPrecoce;
	
	@NotNull(message = "Informe o valor da última conta")
	@NotEmpty(message = "Informe o valor da última conta")
	private String valorUltimaConta;
	
	private String tipobloqueio;
	
	@NotNull(message = "Informe o UUI")
	@NotEmpty(message = "Informe o UUI")
	private String uui;
	
	@NotNull(message = "Informe o campo NoPlano")
	@NotEmpty(message = "Informe o campo NoPlano")
	private String noPlano;
	
	@NotNull(message = "Informe se houve falha na entrada true/false")
	@NotEmpty(message = "Informe se houve falha na entrada true/false\"")
	private String falha;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getNumeroTratado() {
		return numeroTratado;
	}
	public void setNumeroTratado(String numeroTratado) {
		this.numeroTratado = numeroTratado;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getCpfAniOiTv() {
		return cpfAniOiTv;
	}
	public void setCpfAniOiTv(String cpfAniOiTv) {
		this.cpfAniOiTv = cpfAniOiTv;
	}
	public String getNumeroContratoTv() {
		return numeroContratoTv;
	}
	public void setNumeroContratoTv(String numeroContratoTv) {
		this.numeroContratoTv = numeroContratoTv;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getUraRetencao() {
		return uraRetencao;
	}
	public void setUraRetencao(String uraRetencao) {
		this.uraRetencao = uraRetencao;
	}
	public String getUraEntrada() {
		return uraEntrada;
	}
	public void setUraEntrada(String uraEntrada) {
		this.uraEntrada = uraEntrada;
	}
	public String getUraProduto() {
		return uraProduto;
	}
	public void setUraProduto(String uraProduto) {
		this.uraProduto = uraProduto;
	}
	public String getUraContratacao90Dias() {
		return uraContratacao90Dias;
	}
	public void setUraContratacao90Dias(String uraContratacao90Dias) {
		this.uraContratacao90Dias = uraContratacao90Dias;
	}
	public String getUraMailing() {
		return uraMailing;
	}
	public void setUraMailing(String uraMailing) {
		this.uraMailing = uraMailing;
	}
	public String getUraCancelamentoPrecoce() {
		return uraCancelamentoPrecoce;
	}
	public void setUraCancelamentoPrecoce(String uraCancelamentoPrecoce) {
		this.uraCancelamentoPrecoce = uraCancelamentoPrecoce;
	}
	public String getValorUltimaConta() {
		return valorUltimaConta;
	}
	public void setValorUltimaConta(String valorUltimaConta) {
		this.valorUltimaConta = valorUltimaConta;
	}
	public String getTipobloqueio() {
		return tipobloqueio;
	}
	public void setTipobloqueio(String tipobloqueio) {
		this.tipobloqueio = tipobloqueio;
	}
	public String getUui() {
		return uui;
	}
	public void setUui(String uui) {
		this.uui = uui;
	}
	public String getNoPlano() {
		return noPlano;
	}
	public void setNoPlano(String noPlano) {
		this.noPlano = noPlano;
	}
	public String getFalha() {
		return falha;
	}
	public void setFalha(String falha) {
		this.falha = falha;
	}
	
	
	
}
