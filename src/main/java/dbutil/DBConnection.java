package dbutil;




    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



    //@Slf4j
    public class DBConnection {
//private static final Logger logger= LoggerFactory.getLogger(DBConnection.class);

        private static Connection conn;

        public static Connection getConnection() {
            try {
                 conn = DriverManager.getConnection(
                        "jdbc:postgresql://127.0.0.1:5353/bd_for_test", "postgres", "12345");
          //      log.info("connection created.");
               //  conn.close();
            } catch (Exception e) {
          //      log.error("Connection error: " + e.getMessage());
            }
            return conn;
        }
        public static void closeAll(ResultSet rs, PreparedStatement stmt, Connection conn) {
            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                //    log.error("The result set cannot be closed.", e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
               //     log.error("The statement cannot be closed.", e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                //    log.error("The data source connection cannot be closed.", e);
                }
            }
        }
    }

