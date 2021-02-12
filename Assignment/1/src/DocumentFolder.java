
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	controlling the list of documents.
//
//-----------------------------------------------------
public interface DocumentFolder {
    

    //---------------------------------
    // add
    //
    // PURPOSE:				
    // PARAMETERS:
    //	{Document} new document
    // RETURNS:
    //	{boolean} return if the document is added successfully
	//			false if it is duplicate
    //---------------------------------
    boolean add (Document document);


    //---------------------------------
    // getDocument
    //
    // PURPOSE:				
    // PARAMETERS:
    //
    // RETURNS:
    //	{Document} return null if the document is not exist
    //---------------------------------
    Document getDocument (String documentTitle);


    boolean isThereDocument (String documentTitle);
}
