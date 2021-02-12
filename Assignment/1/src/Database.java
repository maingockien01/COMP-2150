//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	interface for database
//						the database control over the data (internally)
//						return the requested data by receiving the data operation
//
//-----------------------------------------------------

public interface Database {
	// ---------------------------------
	// getData
	//
	// PURPOSE: the method is called to carry out the operation on behalf
	// PARAMETERS:
	// {DatabaseOperation} operation
	//
	// RETURNS:
	// {DatabaseOutput} the result of database operation.
	// ---------------------------------
	DatabaseOutput operating(DatabaseOperation operation);

	// ----------------------------------------------------------------------------------------------------------------
	// getUser
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} user id
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput getUser(String userId);

	// ----------------------------------------------------------------------------------------------------------------
	// createUser
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} user id
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput createUser(String userId);

	// ----------------------------------------------------------------------------------------------------------------
	// getDocument
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput getDocument(String documentTitle);

	// ----------------------------------------------------------------------------------------------------------------
	// appendDocument
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	// {String} the content of new line
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput appendDocument(String documentTitle, String newLine);

	// ----------------------------------------------------------------------------------------------------------------
	// editDocument
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	// {int} the line that is replaced by new content
	// {String} the content of new line
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput editDocument(String documentTitle, int line, String content);

	// ----------------------------------------------------------------------------------------------------------------
	// deleteDocument
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	// {int} the line that is deleted
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput deleteDocument(String documentTitle, int line);

	// ----------------------------------------------------------------------------------------------------------------
	// restoreDocument
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	// {int} the time that content is restored.
	// The time must be exactly the time of operation that acted on the document
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput restoreDocument(String document, int time);

	// ----------------------------------------------------------------------------------------------------------------
	// saveChange
	//
	// PURPOSE:
	// PARAMETERS:
	// {ChangeRecord} the record of action performed
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput saveChange(ChangeRecord record);

	// ----------------------------------------------------------------------------------------------------------------
	// getDocumentHistory
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput getDocumentHistory(String documentTitle);

	// ----------------------------------------------------------------------------------------------------------------
	// getUserHistory
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} user Id
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput getUserHistory(String userId);

	// ----------------------------------------------------------------------------------------------------------------
	// createDocument
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	//
	// RETURNS:
	// {DatabaseOutput}
	// ----------------------------------------------------------------------------------------------------------------

	DatabaseOutput createDocument(String documentTitle);
}
