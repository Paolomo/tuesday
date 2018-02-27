package MorrisseyPaul.MyFirstMavenApp;
import java.util.Date;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*****************************************************************
*
* Date: 2017
* @author COR
*
*
* The purpose of this application is to provide an example for the following:
*
* - Demonstrates the use of development tools : GIT, MAVEN, Eclipse
* - Demonstrates how to use Eclipse
* - Provides a refresher of OOP in Java
* - Provide an introduction to project file structure layout - MAVEN Archetype
* - Show how to setup Log4j2
*
*****************************************************************/
public class App
{
public static void main( String[] args )
{
// To view the arguments being entered
seeCommandlineInput(args);
// To instantiate App class based in the parameters entered at the commandline
actionCommandlineInput(args);

//do something here:
 LOG.info( "Login check" );//see login check on the output
 System.out.println("Please enter username:");
 Scanner user = new Scanner(System.in);

 //user 
 username = user.next();
 System.out.println(username+" is best!!");
 
/*getSQLiteConnection();*/  
getSQLiteData();

}
// DATA
//............................................................
//define attributes
private Scanner someInput;
private Date today;
private static String username="";
// This is added to every class that needs to log with one change
// The getLogger( ) part should contain the name of the class its in
private static Logger LOG;
// CONSTRUCTORS
//............................................................
public App()
{
//associate logging with this class so know the messages that came from objects of this class
LOG = LogManager.getLogger(App.class);
//test the logging
testLogOutput();
this.someInput = new Scanner(System.in);
//do something here
System.out.println(" \n Soon ... stuff will happen here");
//pause before exit (this is only useful if an error occurs)
/*System.out.println(" \n Press enter to exit the program");
this.someInput.nextLine();
//close the program without error
System.exit(0);*///had to comment this line out 25-02-2018
}
// METHODS used by main() or debug methods - note they are static methods
//............................................................
/**
* action the arguments presented at the command line
* instantiate the App class based on the arguments passed
*/
private static void actionCommandlineInput( String args[] )
{
// no special instantiation yet as don't pass args to it
App anApp = new App();
}
/**
* View the arguments presented at the commandline
* This is for debug and demo purposes
*/
private static void seeCommandlineInput( String args[] )
{
if (args.length == 0)
{
System.out.println("There were no commandline arguments passed!");
}
else
{
// display the command line entered
for(int i = 0; i < args.length; i++)
{
System.out.println(args[i]);
}
}
}//EOM

private static void getSQLiteData() {
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
/**
* Test the Log4J2 logging
*/
private static void testLogOutput()
{
LOG.debug("Log test: Test printed on debug");
LOG.info("Log test: Test printed on info");
LOG.warn("Log test: Test printed on warn");
LOG.error("Log test: Test printed on error");
LOG.fatal("Log test: Test printed on fatal");
LOG.info("Appending string: {}.", "Application log test message - Hi");
}//EOM
}//EOC