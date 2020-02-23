package br.com.kek.nerdcast.crawler;

import java.io.IOException;
import java.net.URL;

import br.com.kek.nerdcast.util.Constants;
import br.com.kek.nerdcast.util.JsonUtil;
import br.com.kek.nerdcast.util.StringUtil;

/**
 * @author Kelisson
 *
 */
public class NerdcastCrawler {

	public void extrairInformacao(Integer paginaAtual) throws IOException {
		String urlRequisicao = StringUtil.formatar(Constants.URL_REQUISICAO_BASE, Constants.TAMANHO_PAGINA,
				paginaAtual);
		String conteudoRequisicao = JsonUtil.extrairConteudoRequisicao(new URL(urlRequisicao).openStream());
		if (JsonUtil.contemInformacaoJsonRetorno(conteudoRequisicao)) {
			for (String link : JsonUtil.recuperarLinksNerdCast(conteudoRequisicao)) {
				System.out.println(link);
			}
			extrairInformacao(paginaAtual += 1);
		}
	}

	public static void main(String[] args) throws IOException {
		new NerdcastCrawler().extrairInformacao(1);
	}

}
