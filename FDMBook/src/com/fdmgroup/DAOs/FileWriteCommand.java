package com.fdmgroup.DAOs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.fdmgroup.Models.ChatHistory;
import com.fdmgroup.Models.FDMafiaUser;
import com.fdmgroup.Models.Message;

/**
 * 
 * @author Kishan
 *
 */
public class FileWriteCommand implements WriteCommand {

	public FileWriteCommand(){
		
	}

	/**
	 * Create a new chat log for a ChatHistory object in a predefined location.
	 * @param chat
	 * @throws IOException
	 */
	public void newChatLog(ChatHistory chat) throws IOException{
		//String path = ("C:" + File.separator+"Users" +File.separator+"Kishan"+ File.separator +"workspace"+File.separator+"ChatSystem_KishanPatel" + File.separator+
		//		"WebContent"+File.separator+"ChatLogs" + File.separator +chat.getChatMessageLogURL());
		
		String path = ("C:" + File.separator+"Users" +File.separator+"kishan.patel1"+ File.separator +"JavaEclipseWorkspace"+File.separator+"ChatSystem_KishanPatel" + File.separator+
				"WebContent"+File.separator+"ChatLogs" + File.separator +chat.getChatMessageLogURL());
	
		File f = new File(path);
		f.createNewFile();

	}
	
	/**
	 * Add a string to an existing file.
	 * @param url - Location of file that will be written to.
	 * @param message - String that will be appended to specified file.
	 */
	public void writeMessage(String url,Message message) {

		String messageSent = message.getMessageSentByUser();
		String timeStamp = message.getTimeStamp();
		String userWhoCreatedMessage = message.getUserWhoCreatedMessage();

		Writer writer = null;
		

		try {
				writer = new FileWriter(url, true);
	
				writer.write("["+timeStamp+"] " + "["+userWhoCreatedMessage+"]" + " : "+messageSent+ "\n");
	

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void writeUser(FDMafiaUser user) {
		// TODO Auto-generated method stub
		
	}

}
