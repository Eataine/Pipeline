package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ParcelSize {
	public ParcelSize() {}
	
	private String length;
	private String width;
	private String height;
	private String parcelSize;
	
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getParcelSize() {
		return parcelSize;
	}
	public void setParcelSize(String parcelSize) {
		this.parcelSize = parcelSize;
	}
	
	public String calculateParcelSize() {
		ParcelSize parcel = new ParcelSize();
		
		int size = Integer.parseInt(this.length) + (2*Integer.parseInt(this.width)) + (2*Integer.parseInt(this.height));
	    
	    
	    String query = "select * from PaketFormat where minGurtmass <= " + size + " and  maxGurtmass > " + size;
		
	    try {
	        ResultSet result = this.setResult(query);
	        while(result.next()) {
	          parcel.setParcelSize(result.getString("Paketgroesse"));
	        }
	        
	      } catch (SQLException e) {
	        System.out.println("[ERROR] undable to execute database query!");
	        e.printStackTrace();
	      }
	    
		//int size = Integer.parseInt(thi) Formel-Gurtmass
		return parcel.getParcelSize();
	}
	
	public ResultSet setResult(String query) {	
		ResultSet resultSet = null;
    
    	try {
    		//load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //setup the connection with the DB
            //REMEMBER: server timezone needs to be set here! 
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Paket?serverTimezone=UTC", 
                "root",
                "root");
            //create statement
            Statement statement = connection.createStatement();
            //execute the query, and get a java resultset
            resultSet = statement.executeQuery(query);
      
    	} catch(Exception ex) {
    		System.out.println("[ERROR] a problem occured while executing database query \n");
    		ex.printStackTrace();
    	}
    	
    	return resultSet;
	}
}
