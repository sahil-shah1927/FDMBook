package com.fdmgroup.DAOs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.Models.FDMBookUser;
/**
 * 
 * @author Kishan
 *
 */
public class FileReadCommand implements ReadCommand {
	
	private List<String> messageList;

	public FileReadCommand(){
		this.messageList=new ArrayList<String>();
	}
	
	/**
	 * 
	 * @param url - Location of file to be read.
	 * @return List<String> - List of strings read from the specified file.
	 */
	public List<String> readMessages(String url) {

		Reader reader = null;
		BufferedReader bufferedReader = null;

		try {

			reader = new FileReader(url);
			bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();

			while (line != null) {
				messageList.add(line);

					line = bufferedReader.readLine();
			}
			return messageList;

		} catch (FileNotFoundException e) {
			// TODO Handle the file not being found
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Handle any other IOException
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Handle exception during close()
				e.printStackTrace();
			}
		}
		return null;



	}

	
	
	
	
	@Override
	public FDMBookUser readUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
