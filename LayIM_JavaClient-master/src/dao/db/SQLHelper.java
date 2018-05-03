package dao.db;



import java.sql.*;
import java.util.Map;

/**
 * SQL连接类
 */
public class SQLHelper {

    private String _connectionString;
    private String _dbUserName;
    private String _dbUserPwd;
    private String DRIVER_NAME="net.sourceforge.jtds.jdbc.Driver";//

    //无参构造函数
    public SQLHelper(){
        //ip:port/dbname
        _connectionString = "jdbc:jtds:sqlserver://*.*.*.*:1433/layim";
        _dbUserName = "sa";
        _dbUserPwd = "*********";

    }

    /**
     *获取连接
     */
    private Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(_connectionString,_dbUserName,_dbUserPwd);
            System.out.println("connection succeed");
            return connection;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行sql语句 UPDATE  INSERT DELETE
     */
    public boolean ExecuteNonquery(String sql,Map<Integer,Object> params){
        //获取连接
        Connection connection = getConnection();
        if(connection == null) {
            return false;
        }
        PreparedStatement statement = Prepare(connection,sql,params);
        int result = 0;
        try {
            //
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            System.out.println("关闭连接");
            closeAll(connection,statement);
        }
        return result > 0;
    }

    /**
     *
     * @param sql
     * @return
     */
    public boolean ExecuteNonquery(String sql){
        return ExecuteNonquery(sql,null);
    }

    /**
     * 查询ResultSet  结果集
     * @param sql SQL
     * @param params 参数
     * @param operate 结果集的操作
     * @return
     */
    public Object QueryResult(String sql, Map<Integer,Object> params,IResultSetOperate operate){
        Connection connection = getConnection();
        PreparedStatement statement = Prepare(connection,sql,params);
        try {
            ResultSet resultSet = statement.executeQuery();
            //想要获取相应的结果，需要实现IResultOperate接口
            Object object =  operate.getObject(resultSet);
            closeAll(connection,statement);
            return object;

        }catch (SQLException ex) {
            ex.printStackTrace();
            closeAll(connection, statement);
            return null;
        }
    }

    /**
     * 执行存储过程
     * @param sql SQL语句
     * @param params 传入的参数
     * @param operate 操作
     * @return
     */
    public Object QueryManyResultWithProcedure(String sql, Map<Integer,Object> params, IResultSetOperate operate){
        return QueryManyResult("{call "+sql+"}",params,operate);
    }

    public Object QueryManyResult(String sql, Map<Integer,Object> params, IResultSetOperate operate){
        Connection connection = getConnection();
        PreparedStatement statement = Prepare(connection,sql,params);
        try {
            //想要获取相应的结果，需要实现IResultOperate接口
            Object object =  operate.getObject(statement);
            closeAll(connection,statement);
            return object;

        }catch (Exception ex){
            ex.printStackTrace();
            closeAll(connection,statement);
            return null;
        }
    }


    /**
     * 存储过程的statement处理，
     * @param connection 连接
     * @param procedureSql 预处理的SQL
     * @param params 参数
     * @return
     */
    private CallableStatement PrepareByStoreProcedure(Connection connection,String procedureSql,Map<Integer,Object> params){

        try {
            CallableStatement statement =  connection.prepareCall(procedureSql);
            if(params != null){
                for(int i = 0;i<params.size();i++){
                    statement.setObject(i+1, params.get(i+1));
                }
            }
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement Prepare(Connection connection,String sql,Map<Integer,Object> params){
        try {
            //
            PreparedStatement statement = connection.prepareStatement(sql);

            if(params != null){
                for(int i = 0;i<params.size();i++){
                    //get(key)
                    statement.setObject(i+1, params.get(i+1));
                }
            }
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *关闭
     */
    private void closeAll(Connection connection,PreparedStatement statement){
        try {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

