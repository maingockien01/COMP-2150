
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Class contain the users action on documents
//
//-----------------------------------------------------
public interface ChangeRecord extends ListItem {
    public static final String TO_STRING_FORMAT = "User: %s.\nTime: %d.\nAction: %s.\nDocument title: %s.\nDocument snapshot:\n%s";
	public static final String NULL_DOCUMENT_TITLE = "NULL";
    public static enum Action {
        CREATE_DOCUMENT, REPLACE_DOCUMENT, APPEND_DOCUMENT, DELETE_LINE, CREATE_USER, PRINT_DOCUMENT, HISTORY_DOCUMENT, RESTORE_DOCUMENT, REPORT_USER,
    }


    //---------------------------------
    // getUserId
    //
    // PURPOSE:				
    // PARAMETERS:
    //
    // RETURNS:
    //	{String}		user id
    //---------------------------------
    String getUserId ();


    //---------------------------------
    // getDocumentTitle
    //
    // PURPOSE:				
    // PARAMETERS:
    //
    // RETURNS:
    //	{String} 		document title
    //---------------------------------
    String getDocumentTitle ();

    //---------------------------------
    // getAction
    //
    // PURPOSE:				
    // PARAMETERS:
    //
    // RETURNS:
    //	{Action}		action of user
    //---------------------------------
    Action getAction ();

    //---------------------------------
    // getTime
    //
    // PURPOSE:				
    // PARAMETERS:
    //
    // RETURNS:
    //	{int}			the time that the command/action is carried out
    //---------------------------------
    int getTime ();

    //---------------------------------
    // getDocumentContent
    //
    // PURPOSE:				
    // PARAMETERS:
    //
    // RETURNS:
    //	{String}		the content of document after the action performed.
    //---------------------------------
    String getDocumentContent ();


	// ----------------------------------------------------------------------------------------------------------------
	// setDocumentContent
	//
	// PURPOSE:
	// PARAMETERS:
	// String			content of the document
	//
	// RETURNS:
	// {void}
	//----------------------------------------------------------------------------------------------------------------
	
	void setDocumentContent(String documentContent);
}
