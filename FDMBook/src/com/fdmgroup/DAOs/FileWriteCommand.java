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
		
		String path = ("H:" + File.separator+"git" +File.separator+"FDMBook"+ File.separator +"FDMBook"+File.separator+"WebContent" + File.separator+
				"WEB-INF" + File.separator +chat.getChatMessageLogURL());
	
		File f = new File(path);
		f.createNewFile();
		
	}
	
	/**
	 * Add a string to an existing file.
	 * @param url - Location of file that will be written to.
	 * @param message - String that will be appended to specified file.
	 */
	public void writeMessage(String url,Message message) {

		Writer writer = null;
		

		try {
				writer = new FileWriter(url, true);
				writer.write(message.toString() +"\n");
	

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
