
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	maintaining the user list in database
//
//-----------------------------------------------------
public interface UserList {

	// ---------------------------------
	// add
	//
	// PURPOSE:
	// PARAMETERS:
	//
	// RETURNS:
	//
	// ---------------------------------
	boolean add(User user);

	// ---------------------------------
	// getUser
	//
	// PURPOSE:
	// PARAMETERS:
	//
	// RETURNS:
	//
	// ---------------------------------
	User getUser(String userId);

	// ---------------------------------
	// makeCommand
	//
	// PURPOSE:
	// PARAMETERS:
	//
	// RETURNS:
	//
	// ---------------------------------
	boolean isDuplicate(String userId);
}
