//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	in charge of keeping and retrieving changes made by users
// @responsibility		
//
//-----------------------------------------------------
public interface UserHistory {
	// ----------------------------------------------------------------------------------------------------------------
	// getUserReport
	//
	// PURPOSE:
	// PARAMETERS:
	// UserHistory
	//
	// RETURNS:
	// {String}
	// ----------------------------------------------------------------------------------------------------------------
	String getUserReport(String userId);

	// ----------------------------------------------------------------------------------------------------------------
	// saveUserChange
	//
	// PURPOSE:
	// PARAMETERS:
	// UserHistory
	//
	// RETURNS:
	// {boolean}
	// ----------------------------------------------------------------------------------------------------------------
	boolean saveUserChange(ChangeRecord record);
}
