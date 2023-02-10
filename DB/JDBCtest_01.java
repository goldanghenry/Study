import java.sql.*;

public class JDBCtest_01 {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driber");
            System.out.println("OK!");
        } catch(ClassNotFoundException ee){
            System.exit(0);
        }
        Connection conn = null;
        String url = "jdbc:mysql://localhost/academicDB?serverTimezone=UTC";
        String id = "root";
        String pass = "wptkwkd0329-";
        CallableStatement  stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pass);
            // stmt = conn.createStatement();
            // rs = stmt.executeQuery(query);
            // qeury 대신 Stored Procedure 사용하기
            stmt = conn.prepareCall("call studentProc()");
            rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1)+", "+rs.getString(2)+","
                + rs.getString(3)+ ", " +rs.getString(4));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException ee) {
            System.err.println("error = " + ee.toString());
        }
    }    
}
