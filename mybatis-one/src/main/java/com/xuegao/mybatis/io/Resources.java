package com.xuegao.mybatis.io;

import java.io.InputStream;
import java.net.URL;

public class Resources {
    Resources() {
    }

    public static InputStream getResourceAsStream(String fileName) {
        InputStream inputStream = Resources.class.getResourceAsStream(fileName);
        System.out.println("inputStream 1 " + inputStream);
        if (inputStream == null) {
            inputStream = Resources.class.getResourceAsStream("/" + fileName);
        }
        System.out.println("inputStream 2 " + inputStream);
        return inputStream;
    }

    public static URL getResource(String fileName) {
        URL url = Resources.class.getResource(fileName);
        System.out.println("url 1 " + url);
        if (url == null) {
            url = Resources.class.getResource("/" + fileName);
        }
        System.out.println("url 2 " + url);
        return url;
    }

}
