package org.telegram.eo;

/**
 * Hello world!
 *
 */
import java.io.IOException;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {
    public static void main(String[] args) throws IOException {

    	

        try {
        	
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            
            Eo Eo= new Eo();
            botsApi.registerBot(Eo);
               
            
        } catch (TelegramApiException e) {
        	
            e.printStackTrace();
        }  
        
        
    }
        
	}