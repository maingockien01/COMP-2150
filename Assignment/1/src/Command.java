//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	interface for commands
//						command has responsibility of recipe for the system to achieve the task
//					  	commands are read-only, cannot edit after constructing
//					  	the detail, information of commands will be decided in the constructor
//
//-----------------------------------------------------

public interface Command {

	//---------------------------------
	// onCommanding
	//
	// PURPOSE:				the method is called to carry out the command
	// PARAMETERS:
	//	{System} system 	the system will perform the command on behalf
    //	{Database} database the database will perform the database operation
	//
	// RETURNS:
	//	{String} 			output of the command 
	//---------------------------------
	void onCommanding (WikiSystem wikiSystem);


	
}
