package br.com.kek.nerdcast.util;

import java.text.MessageFormat;

public class StringUtil {

	/**
	 * Formata a mensagem juntamente com os parametros informados.
	 * 
	 * @param mensagem
	 * @param aParametros
	 * @return
	 */
	public static String formatar(String mensagem, Object... aParametros) {
		return MessageFormat.format(mensagem, aParametros);
	}

}
