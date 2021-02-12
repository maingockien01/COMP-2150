
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	class in charge of changes made to the database
//
//-----------------------------------------------------
public interface HistoryRecorder {

//---------------------------------
// getUserReport
//
// PURPOSE:				
// PARAMETERS:
//
// RETURNS:
//	{String}
//---------------------------------
	String getUserReport(String userId);

//---------------------------------
// getDocumentReport
//
// PURPOSE:				
// PARAMETERS:
//
// RETURNS:
//	{String}
//---------------------------------
	String getDocumentReport(String documentTitle);

//---------------------------------
// saveRecord
//
// PURPOSE:				
// PARAMETERS:
//
// RETURNS:
//
//---------------------------------
	void saveRecord(ChangeRecord record);

	// ----------------------------------------------------------------------------------------------------------------
	// getRecordAtTime
	//
	// PURPOSE:
	// PARAMETERS:
	// 
	//
	// RETURNS:
	// {ChangeRecord}
	// ----------------------------------------------------------------------------------------------------------------
	ChangeRecord getRecordAtTime(int time);
}
