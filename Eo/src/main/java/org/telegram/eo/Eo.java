package org.telegram.eo;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Eo extends TelegramLongPollingBot {
	
	ReadClass config;
	
	/**
	 * Constructor
	 * Create a ReadClass object with the location of the config file
	 */
	public Eo() {
		ReadClass config = new ReadClass("C:\\Users\\aleja\\Desktop\\Eo.config");
		this.config = config;
		
		}
	
	
	/**
	 * 
	 * Methods
	 * @param The message that is going to be send to the channel
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException {
		        long channel=-1001758498434L ; //prueba
				//long channel=-1001574111334L ;
		       	SendMessage message = new SendMessage(); // Create a SendMessage object
		        message.setChatId(Long.toString(channel));
		        message.setText(msg);
	        
	        try {
	            execute(message); // Call method to send the message
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	        
	}
	
	/** 
	 * If receives a message
	 * 
	 * 
	 * It has different funtions 
	 * 
	 * helloEo = Says hi
	 * informationEo = Gives information about the bot
	 * getIpEo = Gives the current IP
	 * getPortEo = Gives the current PORT
	 * setIpEo (IP) = Sets the specified IP
	 * setPortEo (PORT) = Sets the specified PORT
	 * 
	 * If the message is the information sent by Darrow, it sends the information by a Socket with
	 * the specified IP and PORT. 
	 */
	
	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasChannelPost()) {
			
	        String post= update.getChannelPost().getText(); //get the message
	        String[] value = post.split(" "); //split it when it finds \n
	        
	         
	        if("/helloEo".equals(post)) { //Function helloEo
	        	
	        	try {
	        		
					sendMsg("Hello, I am EO 😌"); //sends message
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
	        	
	        		
	        }else if("/informationEo".equals(post)) {  //Function informationEo
	        	
	        	try {
	        		
					sendMsg("I am the bot who listens to the information that Darrow is sending. I am located in Manizales and sending the information to the GEODATA 😌");
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
	        
	        	
	        }else if("/getIpEo".equals(post)) { //Function getIpEo
	        
	        	try {
	        		
					sendMsg(config.getIP()); //sends message with the IP
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
	        	
	        	
		     }else if("/getPortEo".equals(post)) {  //Function getPortEo
			        
		        	try {
		        		
						sendMsg(config.getPort()); //sends message with the PORT
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
		             
	        
		     
		     }else if("/setIpEo".equals(value[0])) { // Function setIpEo
				        
		    	        config.setIP(value[1]);  //Sets IP specified by the user
		    	        
			        	try {
			        		
							sendMsg("IP set to " + config.getIP()); //Sends a message with the new IP
							
						} catch (IOException e) {
							
							
							e.printStackTrace();
						}  
			        	
		        	
		     }else if("/setPortEo".equals(value[0])) { //Function setPortEo
			        
	    	        config.setPort(value[1]); //Sets PORT specified by the user
	    	        
		        	try {
		        		
						sendMsg("Port set to " + config.getPort()); //Sends a message with the new PORT
						
					} catch (IOException e) {

						e.printStackTrace();
					}   	
	        	
		     
		     
		     
		     
		     }else {
	        	
	        	 try {
	        		 		
	        	    Socket s = new Socket(config.getIP(),Integer.parseInt(config.getPort())); 
	        	    //configures a new socket with the specified information. 
	 	        	DataOutputStream m = new DataOutputStream(s.getOutputStream());
	 	        	m.writeUTF(post + "\n"); //Sends the post to the server
	 	        	s.close();
	 	        	
	 			} catch (ConnectException e1) {
	 				
	 				System.out.println("Connection error");
	 				
	 				try {
		        		
						sendMsg("I can't connect to server");
						
					} catch (IOException e) {
						
						e.printStackTrace();
	 				
	 			}
	 	        
	        	
	        } catch (UnknownHostException e) {
	        	
					e.printStackTrace();
					
				} catch (IOException e) {

					e.printStackTrace();
				}
	        }
	        
	    
	}
	}
	

	@Override
	public String getBotUsername() {

        return "Eo";
    }

    @Override
    public String getBotToken() {

        return "2126583823:AAH_BCLM0THa-pcXr5Pe4hcT-yaE9n8Yas4";
    }
}