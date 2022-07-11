package com.xuegao.mybatis.session;

import com.xuegao.mybatis.config.xml.XMLConfigBuilder;

import java.io.InputStream;
import java.util.Properties;

public class SqlSessionFactory {

    public SqlSessionFactory build(InputStream inputStream) {
        return build(inputStream, null, null);
    }

    public SqlSessionFactory build(InputStream inputStream,
                                   String environment,
                                   Properties properties) {
        // 传入配置文件，创建一个XMLConfigBuilder类
        XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);

    }

}
