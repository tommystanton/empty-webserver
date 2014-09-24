package com.blackhawks;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParameterDecode {

    public static Map<String, String> queryPairs = new LinkedHashMap<String, String>();

    public ParameterDecode( URL url) throws UnsupportedEncodingException {
        try {
            splitQuery(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void splitQuery(URL url) throws UnsupportedEncodingException {
        String query = url.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            queryPairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
    }

    public static String getNewQueryParam(String s) {
        return queryPairs.get(s);
    }
}
