package br.com.capco.util;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class HelpUtil {
	
    /**
     * Converte object em json
     * @param object - Object que será convertido em JSON
     * @return - string com JSON convertido
     */
    public static String convertObjectForJson(Object object) {

        ObjectMapper mapper = new ObjectMapper();

        String jsonArray = "{}";
        
        try {
            jsonArray = mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        return jsonArray;
    }


    /**
     * Remove caracteres especiais 
     * @param object - string com os caracteres 
     * @return - string com apenas numero
     */
    public static String somenteNumeros(String object) {
        if(StringUtils.isEmpty(object)) {
            return "";
        }
        return object.replaceAll("\\D", "");
    }

}
