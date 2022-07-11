package com.xuegao.mybatis.mapping;

/**
 * 一共有四个实现
 */
public interface SqlSource {

  /**
   * 获取一个BoundSql对象
   * @param parameterObject 参数对象
   * @return BoundSql对象
   */
  BoundSql getBoundSql(Object parameterObject);

}