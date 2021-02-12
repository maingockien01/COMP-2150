//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	interface for database output class
//						the class is simply the data returned by database after operating.
//
//-----------------------------------------------------
public interface DatabaseOutput {
	// ---------------------------------
	// getData
	//
	// PURPOSE: 		the method is called to return the data from database operation
	// PARAMETERS:		
	//
	// RETURNS:
	// {String} 		the result of database operation. 
	// ---------------------------------
	String getData();
}
