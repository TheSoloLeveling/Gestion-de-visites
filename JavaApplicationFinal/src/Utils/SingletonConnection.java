

package Utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class SingletonConnection {
    
     private static Connection connection;
    
    static{
        try{
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
 
        }
        catch(java.sql.SQLException e ){
            e.printStackTrace(); 
        }
    }
    public static Connection getconn(){
        
   return connection ; 
    }
}
