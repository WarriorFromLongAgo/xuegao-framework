package com.xuegao.mybatis.config.xml;

import com.xuegao.mybatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

public class XMLConfigBuilderTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(inputStream);
        xmlConfigBuilder.parse();
    }
}
