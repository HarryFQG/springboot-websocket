package dao.db;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * SQL操作
 */
public interface IResultSetOperate {

    /**
     * 操作resultSet返回相应的数据
     */
    Object getObject(ResultSet resultSet);

    Object getObject(Statement statement);
}
