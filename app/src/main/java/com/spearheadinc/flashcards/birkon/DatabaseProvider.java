package com.spearheadinc.flashcards.birkon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;

public class DatabaseProvider
{
	FCDBHelper myFCDbHelper;
	
	String[] lkp_TypesArrFC = new String[] {"lkp_Types", "pk_TypeId", "TypeValue"}; 
	String[] m_FlashCardDecksArr = new String[] {"m_FlashCardDecks", "pk_FlashCardDeckId", "DeckTitle", "DeckImage",
													"DeckColor"}; 
	
	String[] m_FlashCardArr = new String[] {"m_FlashCard", "pk_FlashCardId", "InternalCardId", "fk_FlashCardDeckId", 
													"ISKnown", "ISBookMarked"}; 
	
	String[] m_FlashCardFrontBackDetailsArr = new String[] {"m_FlashCardFrontBackDetails", "pk_FlashCardFrontBackDetailId", 
															"fk_FlashCardId", "FrontOrBack", 
															"fk_TypeId", "TitleData", "SortKey"}; 
	
	String[] m_FlashCardInternalDetailsArr = new String[] {"m_FlashCardInternalDetails", "pk_FlashCardInternalDetailId", 
															"fk_FlashCardId", "fk_TypeId", "TitleData", 
															"FrontOrBack", "SortKey"}; 
	
	String[] m_ConfigDetailsArr = new String[] {"m_ConfigDetails", "Bookmark", "Animation", "AudioIcon", "Name", "HelpText",
													"Help", "Info", "TitleName", "DetailName"};
	
    public void createDB(Context context) {
        myFCDbHelper = new FCDBHelper(context);
        List<String[]> listFC = new ArrayList<String[]>();
        listFC.add(lkp_TypesArrFC);
        listFC.add(m_FlashCardDecksArr);
        listFC.add(m_FlashCardArr);
        listFC.add(m_FlashCardFrontBackDetailsArr);
        listFC.add(m_FlashCardInternalDetailsArr);
        listFC.add(m_ConfigDetailsArr);
 
        try 
        {
        	myFCDbHelper.createDataBase();

        } 
        catch(IOException ioe)
        {
        	throw new Error("Unable to create database");
        }
    }

	public FCDBHelper getMyFCDbHelper() {
		return myFCDbHelper;
	}
}