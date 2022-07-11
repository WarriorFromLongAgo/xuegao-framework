package com.xuegao.mybatis.config;

import com.xuegao.mybatis.session.Configuration;

public abstract class ConfigBuilder {
    protected final Configuration configuration;

    public ConfigBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
