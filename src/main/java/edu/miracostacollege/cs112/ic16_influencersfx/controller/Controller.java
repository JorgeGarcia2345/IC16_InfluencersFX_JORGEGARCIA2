package edu.miracostacollege.cs112.ic16_influencersfx.controller;

import edu.miracostacollege.cs112.ic16_influencersfx.model.Influencer;

import edu.miracostacollege.cs112.ic16_influencersfx.model.Model;
import javafx.collections.ObservableList;

/*
	singleton, only one obj ever created

	constructor private!!!!

	public - get instance
	returns controller obj



 */


/**
 * The <code>Controller</code> is a Singleton object that relays all commands between the Model and View
 * (and vice versa).  There is only one Controller object, accessible by a call to the static getInstance()
 * method.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Controller {

	private static Controller theInstance;
	private ObservableList<Influencer> mAllInfluencersList;

	// TODO: Create private constructor to enforce Singleton pattern


	/**
	 * Gets the one instance of the Controller.
	 * @return The instance
	 */
	public static Controller getInstance() {
		
		// TODO: If the instance is null, assign it to a new Controller,
		// TODO: then, assign the mAllInfluencersList to the populateListFromBinaryFile() method

		return theInstance;
	}

	/**
	 * Gets the list of all influencers.
	 * @return The list of all influencers.
	 */
	public ObservableList<Influencer> getAllInfluencers() {
		return mAllInfluencersList;
	}

	/**
	 * Makes a request for the model to save all the influencer data (the list of all influencers) to
	 * a persistent binary file.
	 */
	public void saveData() {
		Model.writeDataToBinaryFile(mAllInfluencersList);
	}
}
