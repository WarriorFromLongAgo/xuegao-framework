package com.xuegao.mybatis.config.xml;

import com.xuegao.mybatis.config.ConfigBuilder;
import com.xuegao.mybatis.parsing.XPathParser;
import com.xuegao.mybatis.session.Configuration;

import java.io.InputStream;
import java.util.Properties;

public class XMLConfigBuilder extends ConfigBuilder {
    // 解析器
    private final XPathParser parser;
    // 要读取哪一个Environment节点，这里存储节点名
    private String environment;

    public XMLConfigBuilder(InputStream inputStream) {
        this(inputStream, null, null);
    }

    public XMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
        this(new XPathParser(inputStream), environment, props);
    }

    private XMLConfigBuilder(XPathParser parser, String environment, Properties props) {
        super(new Configuration());
        this.parser = parser;
        this.configuration.setVariables(props);
        this.environment = environment;
    }

    /**
     * 初始化配置文件信息
     *
     * @since 0.0.1
     */
    public void parse() {
        parser.evalNode("/configuration")

    }


}
