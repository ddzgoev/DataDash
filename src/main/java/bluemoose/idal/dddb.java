package bluemoose.idal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class dddb {

	// **This class was adapted from Karl Meissner's
	// (karl@meissnersd.com) JDBC Client Example
	// (http://www.hsqldb.org/doc/1.8/guide/apb.html)**

	Connection conn; // our connnection to the db - presist for life of program

	public dddb(String db_file_name_prefix) throws Exception { 
																									
		// Load the HSQL Database Engine JDBC driver
		// hsqldb.jar should be in the class path or made part of the current
		// jar
		Class.forName("org.hsqldb.jdbcDriver");

		// connect to the database. This will load the db files and start the
		// database if it is not alread running.
		// db_file_name_prefix is used to open or create files that hold the
		// state
		// of the db.
		// It can contain directory names relative to the
		// current working directory
		conn = DriverManager.getConnection(
				"jdbc:hsqldb:" + db_file_name_prefix, // filenames
				"sa", // username
				""); // password
	}

	public void shutdown() throws SQLException {

		Statement st = conn.createStatement();

		// db writes out to files and performs clean shuts down
		// otherwise there will be an unclean shutdown
		// when program ends
		st.execute("SHUTDOWN");
		conn.close(); // if there are no other open connection
	}

	// use for SQL command SELECT
	public synchronized void query(String expression) throws SQLException {

		Statement st = null;
		ResultSet rs = null;

		st = conn.createStatement(); // statement objects can be reused with

		// repeated calls to execute but we
		// choose to make a new one each time
		rs = st.executeQuery(expression); // run the query

		// do something with the result set.
		dump(rs);
		st.close(); // NOTE!! if you close a statement the associated ResultSet
					// is

		// closed too
		// so you should copy the contents to some other object.
		// the result set is invalidated also if you recycle an Statement
		// and try to execute some other query before the result set has been
		// completely examined.
	}

	// use for SQL commands CREATE, DROP, INSERT and UPDATE
	public synchronized void update(String expression) throws SQLException {

		Statement st = null;

		st = conn.createStatement(); // statements

		int i = st.executeUpdate(expression); // run the query

		if (i == -1) {
			System.out.println("db error : " + expression);
		}

		st.close();
	} // void update()

	public static void dump(ResultSet rs) throws SQLException {

		// the order of the rows in a cursor
		// are implementation dependent unless you use the SQL ORDER statement
		ResultSetMetaData meta = rs.getMetaData();
		int colmax = meta.getColumnCount();
		int i;
		Object o = null;

		// the result set is a cursor into the data. You can only
		// point to one row at a time
		// assume we are pointing to BEFORE the first row
		// rs.next() points to next row and returns true
		// or false if there is no next row, which breaks the loop
		for (; rs.next();) {
			for (i = 0; i < colmax; ++i) {
				o = rs.getObject(i + 1); // Is SQL the first column is indexed

				// with 1 not 0
				System.out.print(o.toString() + " ");
			}

			System.out.println(" ");
		}
	} // void dump( ResultSet rs )

	public static dddb StartDB() {
		dddb db = null; 

		try {
			db = new dddb("our_db");
		} catch (Exception ex1) {
			ex1.printStackTrace();

			return db;
		}

		try {
           //libdal table create statements 
			db.update("CREATE TABLE C_APP_RUN_DEPENDENCY( Run_App_Dependency_ID VARCHAR(30)  NOT NULL PRIMARY KEY ,APP_Name VARCHAR(30),Run_Name VARCHAR(30) ,Dependant_APP_Name VARCHAR(30),Dependant_Run_Name VARCHAR(30),Create_Date_Time VARCHAR(30) ,Last_Modified_Date_Time DATETIME ,APP_Run_ID VARCHAR(30) ,Dependant_APP_Run_ID VARCHAR(30) );");
			db.update("CREATE TABLE C_DRIVER_SCHEDULE(Audit_ID VARCHAR(30) PRIMARY KEY,App_Name VARCHAR(30),Run_Name VARCHAR(30),Run_Number VARCHAR(30),Re_Run_Number VARCHAR(30),Scheduled_Start_Date_Time VARCHAR(30) ,Status_Code VARCHAR(30),Valuation_Start_Date_Time VARCHAR(30) ,Valuation_End_Date_Time VARCHAR(30) ,Run_Start_Date_Time VARCHAR(30) ,Run_End_Date_Time VARCHAR(30) ,Create_Date_Time VARCHAR(30) ,Last_Modified_Date_Time VARCHAR(30) ,APP_Run_ID VARCHAR(30),SLA_DATE VARCHAR(30) ,SLA_TIME VARCHAR(30));");
		    db.update("CREATE TABLE C_DRIVER_STEP_DETAIL_H(Driver_Step_Detail_ID VARCHAR(30) NOT NULL PRIMARY KEY ,Audit_ID  VARCHAR(30),Driver_Step_ID  VARCHAR(30),APP_Name VARCHAR(30),Run_Name VARCHAR(30),Group_Number VARCHAR(30),Run_Order_Number VARCHAR(30),Run_Status_Code VARCHAR(30),Error_Process_Number VARCHAR(30),SESSION_START_DATE_TIME VARCHAR(30),SESSION_END_DATE_TIME VARCHAR(30),Run_Start_Date_Time VARCHAR(30),Run_End_Date_Time VARCHAR(30),Create_Date_Time VARCHAR(30),Last_Modified_Date_Time VARCHAR(30),History_Date_Time VARCHAR(30));");
			db.update("CREATE TABLE C_DRIVER_STEP_DETAIL(Driver_Step_Detail_ID   VARCHAR(30)  NOT NULL PRIMARY KEY ,Audit_ID VARCHAR(30) ,Driver_Step_ID  VARCHAR(30) ,APP_Name  VARCHAR(30),Run_Name    VARCHAR(30),Group_Number   VARCHAR(30) ,Run_Order_Number VARCHAR(30) ,Run_Status_Code         VARCHAR(30),Error_Process_Number VARCHAR(30) ,SESSION_START_DATE_TIME VARCHAR(30),SESSION_END_DATE_TIME  VARCHAR(30) ,Run_Start_Date_Time VARCHAR(30) ,Run_End_Date_Time  VARCHAR(30) ,Create_Date_Time VARCHAR(30),Last_Modified_Date_Time VARCHAR(30));");
		    db.update("CREATE TABLE C_DRIVER_STEP(Driver_Step_ID  VARCHAR2(43) NOT NULL PRIMARY KEY,APP_Name  VARCHAR(30),Run_Name VARCHAR(25),Group_Number VARCHAR(30),Group_Name  VARCHAR(68),Run_Order_Number VARCHAR(20),Path_Text VARCHAR(53),Command_Text  VARCHAR(62),Parameter_Text      VARCHAR(241),Group_Concurrency_Indicator VARCHAR(48),Step_Concurrency_Indicator  VARCHAR(32),Notify_Text  VARCHAR(32),Step_Type_Code   VARCHAR(30),Step_Name   VARCHAR(68),Error_Process_Number VARCHAR(30),Create_Date_Time VARCHAR(30),Last_Modified_Date_Time VARCHAR(30),APP_Run_ID VARCHAR(30),Active_Step_Indicator VARCHAR(30));");
		   
		    //idal table create statements parameters and originalParameters will have to be joined with Macros on uniqueID in practice
		    db.update("CREATE TABLE Macros( uniqueID VARCHAR(30), creatorFname VARCHAR(30), creatorLname VARCHAR(30), reviewerFname VARCHAR(30), reviewerLname VARCHAR(30), wasPeerReviewed VARCHAR(30), runDate VARCHAR(30), creationDate VARCHAR(30),macroType VARCHAR(30), PRIMARY KEY(uniqueID) );");
		    db.update("CREATE TABLE originalParameters( uniqueID VARCHAR(30), originalParameters VARCHAR(30));");
		    db.update("CREATE TABLE parameters( uniqueID VARCHAR(30), parameters VARCHAR(30) );");
		    
		    
			} catch (SQLException ex2) {
		}

		try {
			db.update("INSERT INTO C_APP_RUN_DEPENDENCY(Run_App_Dependency_ID,APP_Name,Run_Name,Dependant_APP_Name,Dependant_Run_Name,Create_Date_Time,Last_Modified_Date_Time,APP_Run_ID,Dependant_APP_Run_ID) VALUES (5700004,'CLAIMS','CLM_ACS_EXTR','CLAIMS','CLM_REPORTING_HUB','1900-01-01 00:00:00','1900-01-01 00:00:00','?','?');");
            db.update("INSERT INTO C_DRIVER_SCHEDULE(Audit_ID,App_Name,Run_Name,Run_Number,Re_Run_Number,Scheduled_Start_Date_Time,Status_Code,Valuation_Start_Date_Time,Valuation_End_Date_Time,Run_Start_Date_Time,Run_End_Date_Time,Create_Date_Time,Last_Modified_Date_Time,APP_Run_ID,SLA_DATE,SLA_TIME) VALUES ('1799120014','CLAIMS','CLM_ACS_EXTR','1023','0','03:14.0','S','30:05.0','00:14.0','15:16.2','21:47.7','15:09.0','21:47.7','?','?','?');");
		    //db.update("INSERT INTO C_DRIVER_STEP_DETAIL (Driver_Step_Detail_ID,Audit_ID,Driver_Step_ID,APP_Name,Run_Name,Group_Number,Run_Order_Number,Run_Status_Code,Error_Process_Number,SESSION_START_DATE_TIME,SESSION_END_DATE_TIME,Run_Start_Date_Time,Run_End_Date_Time,Create_Date_Time,Last_Modified_Date_Time) VALUES ('16035010043','332185','26500001','EDW','CDI_2_O','50','10','S','2','?','?','00:45.2','00:46.1','00:38.4','00:38.4');");
		    //db.update("INSERT INTO C_DRIVER_STEP(Driver_Step_ID,APP_Name,Run_Name,Group_Number,Group_Name,Run_Order_Number,Path_Text,Command_Text,Parameter_Text,Group_Concurrency_Indicator,Step_Concurrency_Indicator,Notify_Text,Step_Type_Code,Step_Name,Error_Process_Number,Create_Date_Time,Last_Modified_Date_Time,APP_Run_ID,Active_Step_Indicator) VALUES ('26100003','CLAIMS','CLM_AIB_RPT_REQUEST_EXTR','100','DRIVER_ENTRIES_INSERT','10','$UTILITY_SCRIPTS','edwPMCMD','PM_CL_EXTR_COBRA wf_UPSERT_DRIVER_STEP_RUNNING 100 10','n','n','$APP_ERROR_MAIL_RECIP','INF','DRIVER_STEPS_INSERT','2','00:00.0','00:00.0','?','Y');");
		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
		return db;
	}

	public static void main(String[] args) {
		dddb db = null;
		db = StartDB();

		try {

			db.query("SELECT * FROM C_APP_RUN_DEPENDENCY");
			db.query("SELECT * FROM C_DRIVER_SCHEDULE");
			//db.query("SELECT * FROM C_DRIVER_STEP_DETAIL_H");
			//db.query("SELECT * FROM C_DRIVER_STEP_DETAIL");
			//db.query("SELECT * FROM C_DRIVER_STEP");
			// at end of program
			db.query("drop table C_APP_RUN_DEPENDENCY");
			db.query("drop table C_DRIVER_SCHEDULE");
			//db.query("drop table C_DRIVER_STEP_DETAIL_H");
			//db.query("drop table C_DRIVER_STEP_DETAIL");
			//db.query("drop table C_DRIVER_STEP");
			
			//db.query("drop table Macros");
			//db.query("drop table originalParameters");
			//db.query("drop table parameters");
			db.shutdown();
		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
	} // main()
} // class Testdb
