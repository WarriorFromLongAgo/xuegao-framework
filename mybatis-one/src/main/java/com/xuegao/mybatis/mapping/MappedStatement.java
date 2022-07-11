package com.xuegao.mybatis.mapping;

import com.xuegao.mybatis.session.Configuration;

public class MappedStatement {

    // Mapper文件的磁盘路径
    private String resource;
    // Configuration对象
    private Configuration configuration;
    // 查询语句的完整包名加方法名，例如：com.github.yeecode.mybatisdemo.dao.UserMapper.addUser
    private String id;

    private StatementType statementType;
    private ResultSetType resultSetType;
    //SQL源码，对应于我们所写在配置文件中的SQL语句。包含占位符，无法直接执行。可以展开分析就是分行的sql语句text。
    private String sql;
    // 输出的resultMap放在这里，我们在设置resultMap="UserBean" 时可以设置多个，即resultMap="UserBean，RoleBean"。

    MappedStatement() {
        // constructor disabled
    }

    public static class Builder {
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration,
                       String id) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.statementType = StatementType.PREPARED;
            mappedStatement.resultSetType = ResultSetType.DEFAULT;
        }

        public Builder resource(String resource) {
            mappedStatement.resource = resource;
            return this;
        }

        public String id() {
            return mappedStatement.id;
        }

        public Builder statementType(StatementType statementType) {
            mappedStatement.statementType = statementType;
            return this;
        }

        public Builder resultSetType(ResultSetType resultSetType) {
            mappedStatement.resultSetType = resultSetType == null ? ResultSetType.DEFAULT : resultSetType;
            return this;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }

    public String getResource() {
        return resource;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getId() {
        return id;
    }

    public StatementType getStatementType() {
        return statementType;
    }

    public ResultSetType getResultSetType() {
        return resultSetType;
    }

}
