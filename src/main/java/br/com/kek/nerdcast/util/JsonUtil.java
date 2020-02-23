package br.com.kek.nerdcast.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author Kelinguiça
 *
 */
public class JsonUtil {

	/**
	 * @param conteudoRequisicao
	 * @return
	 * @throws Exception
	 */
	public static Boolean contemInformacaoJsonRetorno(String conteudoRequisicao) throws IOException {
		JsonElement jsonElement = JsonParser.parseString(conteudoRequisicao);
		return jsonElement.getAsJsonArray().size() > 0;
	}
	
	public static String extrairConteudoRequisicao(InputStream openStream) throws IOException {
		return IOUtils.toString(openStream, StandardCharsets.UTF_8);
	}
	
	public static List<String> recuperarLinksNerdCast(String conteudoRequisicao) throws IOException {
		List<String> retorno = new ArrayList<String>();
		JsonArray asJsonArray = JsonParser.parseString(conteudoRequisicao).getAsJsonArray();
		for (JsonElement jsonElement : asJsonArray) {
			JsonObject asJsonObject = jsonElement.getAsJsonObject();
			System.out.println(asJsonObject.get(Constants.TAG_URL_HIGH_QUALITY));
		}
		return retorno;
	}

}
