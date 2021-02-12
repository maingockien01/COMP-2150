//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	interface for database operation
//						the operation will call back database to carry out the operation coded in the object
//						the operation to database has same function like the command to the system
//							the operation specify what or which query database need to do. 
//
//-----------------------------------------------------
public interface DatabaseOperation {

	// ---------------------------------
	// onOperating
	//
	// PURPOSE:
	// PARAMETERS:
	// 	{Database}	the database perform the operation
	// RETURNS:
	//	{DatabaseOutput} the output of the operation
	// ---------------------------------
	DatabaseOutput onOperating(Database database);

	// ----------------------------------------------------------------------------------------------------------------
	// getChangeRecord
	//
	// PURPOSE: get change record of the operation
	// PARAMETERS:
	// 
	//
	// RETURNS:
	// {ChangeRecord}	the record of the command
	// ----------------------------------------------------------------------------------------------------------------

	ChangeRecord getChangeRecord();

	// ---------------------------------
	// setTime
	//
	// PURPOSE: set time the operation is performed
	// PARAMETERS:
	// {int} time
	// RETURNS:
	// 
	// ---------------------------------
	void setTime(int time);
	
	// ----------------------------------------------------------------------------------------------------------------
	// getTime
	//
	// PURPOSE: get time that the operation is performed
	// PARAMETERS:
	// Command
	//
	// RETURNS:
	// {int}
	// ----------------------------------------------------------------------------------------------------------------

	int getTime();
}
