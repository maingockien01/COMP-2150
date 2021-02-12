
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	in charge of controlling changes to documents
//
//-----------------------------------------------------
public interface DocumentHistory {
	// ----------------------------------------------------------------------------------------------------------------
	// getDocumentReport
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} document title
	//
	// RETURNS:
	// {String} get the report of changes on document 
	// ----------------------------------------------------------------------------------------------------------------
	String getDocumentReport(String documentTitle);

	// ----------------------------------------------------------------------------------------------------------------
	// saveDocumentChange
	//
	// PURPOSE:
	// PARAMETERS:
	// DocumentHistory
	//
	// RETURNS:
	// {boolean} if the record is saved successfully 
	// ----------------------------------------------------------------------------------------------------------------
	boolean saveDocumentChange(ChangeRecord record);
}
