# TelebramBotEo

This bot receives the information from Darrow and sends it to a socket. The IP and the port are programmable with its funtions. To start, it's important to add the maven dependecies as follows. 
Add to the pom.xml file the telegram bot dependency. 

<dependency>
  <groupId>org.telegram</groupId>
  <artifactId>telegrambots</artifactId>
  <version>5.4.0</version>
</dependency>

It has different funtions 
	 * helloEo = Says hi
	 * informationEo = Gives information about the bot
	 * getIpEo = Gives the current IP
	 * getPortEo = Gives the current PORT
	 * setIpEo (IP) = Sets the specified IP
	 * setPortEo (PORT) = Sets the specified PORT
   
 To try it in linux, the easiest way is to open a server with ncat as follows: 
 
 nc -lk 23456
 
 
