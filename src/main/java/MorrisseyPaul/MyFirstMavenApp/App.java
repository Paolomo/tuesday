package MorrisseyPaul.MyFirstMavenApp;

import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;//What r these?
import org.apache.logging.log4j.core.config.Configurator;//What r these?

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
    	actionCommandlineInput(args);
    	/*getSQLiteConnection();*/  
    	getData();
    }
    
	//define attributes
   	private	Scanner someInput;
   	private Date today;
   	private static Logger LOG;
   	private static String username="";
   	
  // constructor
 	public App()
 	{
 		LOG = LogManager.getLogger(App.class);
 		Configurator.setLevel(LOG.getName(), Level.DEBUG);
 		this.someInput = new Scanner(System.in);
 	    System.out.println(LOG.getName());
 		
 	    //do something here:
 		LOG.info( "Login check" );
 	     System.out.println("Please enter username:");
         Scanner user = new Scanner(System.in);
		
         //user 
         username = user.next();
         System.out.println(username+" is best!!");
         
      	
 	}
 	
    private static void actionCommandlineInput( String args[] )
    {
    	 App anApp = new App();
    }
    
	private static void getData() {
		// TODO Auto-generated method stub
    	String url = "jdbc:sqlite:C://SQLiteStudio/Paololite.db";
    	String sql="";
    	String teacherId = "456";//hardcoded teacher id
    	if(username.matches(teacherId)) {
    	 sql  = "select pid, parent, SongId, SongTitle from users, music"
    			+" where pid = Pid and SongTitle not null";// Null rows in musiC table
    	}else {
    	 sql  = "select pid, parent, SongId, SongTitle from users, music"
    	    	+" where pid = Pid and SongTitle not null and pid="+username+"";
    	}
    
    	try{
    		
    		Connection conn = DriverManager.getConnection(url);
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    	
    			while(rs.next()) {
    				System.out.println(rs.getInt("pid") + "\t" + rs.getString("parent") + "\t"+ rs.getInt("SongId") + "\t"+ rs.getString("Songtitle") +"\t");
    		}
    		
    	}catch (SQLException e) {
    		
    		System.out.println(e.getMessage());
    	}
		
	}
}

