package org.telegram.eo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadClass {
	
	/**
	 * 
	 * Instances variables
	 * 
	 */
	
	  String array[] = {"", ""};
	  String route;
	  Scanner obj;
	  String IP;
	  String PORT;

	/**
	 * 
	 * Constructor
	 * @param route of the file
	 */
	
		public ReadClass(String route) {
			
		    this.route= route;  
			File doc =new File(route);   //opens the config file
			boolean exists = doc.exists();
			
			if(exists== false) { //if it doesn't exist it creates it with default parameters. 
				
				try {
					
					doc.createNewFile();
					FileWriter myWriter = new FileWriter(route);
					myWriter.write("IP=localhost\r\n"
							+ "Port=23456");
					myWriter.close(); 	
					 
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}	
			
		    
			try {
				
				Scanner obj = new Scanner(doc); //Creates a Scanner object to read the file
				this.obj = obj;
				
	            for(int i = 0; i < 2 ; i++) {
	            	array[i] = obj.nextLine(); 
	            }
	            
	            String[] ip_string = array[0].split("=");  //First line is the IP
	            this.IP = ip_string[1];
	            
	            String[] port_string = array[1].split("=");  //Second line is the PORT
	            this.PORT = port_string[1];
	            
	            
			} catch (FileNotFoundException e) {

				System.out.println("File not found");
			}
		    
			
		}
		
		/**
		 * 
		 * @return the current IP
		 */
        
        public String getIP() { 
        	
        	return this.IP;
        	
        }
        
        /**
         * 
         * @return the current PORT
         */
        
        public String getPort() {
        	
        	return this.PORT;
        	
        }
        
        /**
         * Sets a new IP
         * @param a new IP
         */
        
        public void setIP(String IP) {
        	
			this.IP = IP;
			
			try {
				
				FileWriter myWriter = new FileWriter(route);
				myWriter.write("IP="+ IP + "\r\n"
						+ "Port="+ getPort());
				myWriter.close(); 
				
			} catch (IOException e) {

				e.printStackTrace();
			}
			
        	
        }
        
        /**
         * 
         * Sets a new PORT
         * @param the new PORT
         */
        
        public void setPort(String PORT) {
        	
        	this.PORT = PORT;
        	
			try {
				
				FileWriter myWriter = new FileWriter(route);
				myWriter.write("IP="+ getIP() + "\r\n"
						+ "Port="+ PORT);
				myWriter.close(); 
				
			} catch (IOException e) {

				e.printStackTrace();
			}
				
        	
        }
        
	
	
	}