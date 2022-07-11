package com.xuegao.mybatis.session;

import com.xuegao.mybatis.mapping.Environment;
import com.xuegao.mybatis.mapping.MappedStatement;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Properties;

@Getter
@Setter
public class Configuration {

    // <environment>节点的信息
    protected Environment environment;
    // <properties>节点信息
    protected Properties variables = new Properties();
    // xxMapper.xml
    private Map<String, MappedStatement> mapperStatementMap;

    public void addMappedStatement(MappedStatement ms) {
        mapperStatementMap.put(ms.getId(), ms);
    }

}
