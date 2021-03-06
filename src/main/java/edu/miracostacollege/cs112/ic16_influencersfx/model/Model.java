package edu.miracostacollege.cs112.ic16_influencersfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

/**
 * The <code>Model</code> class represents the business logic (data and calculations) of the application.
 * In the Influencers app, it loads influencer data from a binary file
 * It is also responsible for saving data to a binary file.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Model {
	
	public static final String BINARY_FILE = "Influencers.dat";

	/**
	 * Determines whether the binary file exists and has data (size/length >= 5 bytes).
	 *
	 * @return True if the binary file exists and has data, false otherwise.
	 */
	public static boolean binaryFileHasData()
	{
		// TODO: Create a File reference to the binary file
		File binaryFile = new File(BINARY_FILE);
		// TODO: Return whether the binary file exists and has >= 5 bytes size
		return (binaryFile.exists() && binaryFile.length() >=5);
	}

	/**
	 * Populates the list of all influencers from the binary file.
	 *
	 * @return The list of all influences populated from the binary file
	 */
	public static ObservableList<Influencer> populateListFromBinaryFile()
	{
		ObservableList<Influencer> allInfluencers = FXCollections.observableArrayList();
		// TODO: If the binary file has data:
		if(binaryFileHasData())
		try{
			// TODO: Instantiate an ObjectInputStream reference to the binary file for reading
			ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
			// TODO: Create a temp array of Influencer objects to read from the binary file
			Influencer[] temp = (Influencer[]) fileReader.readObject();
			// TODO: Initialize the temp array from the binary file reader
			// TODO: Add the temp array to the collection of all influencers (list).
			for(Influencer i : temp)
				allInfluencers.add(i);
			// TODO: Close the binary file reader.
			fileReader.close();
		}catch (IOException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return allInfluencers;
	}

	/**
	 * Saves the list of all influencers to the binary file. This will be called each time the application stops,
	 * which occurs when the user exits/closes the app.  Note this method is called in the View, by the controller,
	 * during the stop() method.
	 * @return True if the data were saved to the binary file successfully, false otherwise.
	 */
	public static boolean writeDataToBinaryFile(ObservableList<Influencer> allInfluencersList)
	{

		// TODO: Create a temp array of Influencer objects to read from the binary file (length should match list size)
		Influencer [] temp = new Influencer[allInfluencersList.size()];
		// TODO: Loop through the temp array and initialize each element to the corresponding element in the list
		for (int i = 0; i < temp.length; i++) {
			temp[i] = allInfluencersList.get(i);
		}
		// TODO: Write the temp array object to the binary file writer
		try{
			ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
			fileWriter.writeObject(temp);
			// TODO: Close the binary file writer and return true.
			fileWriter.close();
		} catch (IOException  e) {
			// TODO: If an exception occurs, print its message and return false.
			System.out.println("error " + e);
			return false;
		}
		return true;
	}

}
