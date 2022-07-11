package com.xuegao.mybatis.mapping;

public enum StatementType {

// 1、STATEMENT:直接操作sql，不进行预编译，获取数据：$—Statement
// 2、PREPARED:预处理，参数，进行预编译，获取数据：#—–PreparedStatement:默认
// 3、CALLABLE:执行存储过程————CallableStatement
// <update id="update4" statementType="STATEMENT">
// update tb_car set price=${price} where id=${id}
// </update>
// <update id="update5" statementType="PREPARED">
// update tb_car set xh=#{xh} where id=#{id}
// </update>

    STATEMENT, PREPARED, CALLABLE
}
