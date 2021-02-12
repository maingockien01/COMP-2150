//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	interface for System
// @responsibility		receiving commands from users to perform according to the command on behalf
//
//-----------------------------------------------------

public interface WikiSystem {
	// ----------------------------------------------------------------------------------------------------------------
	// loadCommands
	//
	// PURPOSE: the method is called to load the command in the awaiting command
	// queue
	// PARAMETERS:
	// {Command} command command object
	//
	// RETURNS:
	// {void}
	// ----------------------------------------------------------------------------------------------------------------
	void loadCommand(Command command);

	// ----------------------------------------------------------------------------------------------------------------
	// loadCommands
	//
	// PURPOSE: the method is called to load a number of commands in the awaiting
	// command queue
	// PARAMETERS:
	// {Command[]} commands formatted command string given from user
	// the string has the format according to the assignment description for now
	// the required format of string is specified in each sub-class commands.
	//
	// RETURNS:
	// {Command}
	// ----------------------------------------------------------------------------------------------------------------
	void loadCommands(Command... commands);

	// ---------------------------------
	// commanding
	//
	// PURPOSE: the method is called to execute commands in the command queue
	// PARAMETERS:
	//
	// RETURNS:
	// {void}
	void commanding();

	// ----------------------------------------------------------------------------------------------------------------
	// commandDatabase
	//
	// PURPOSE: the system tell the database to execute the data operation
	// PARAMETERS:
	// {DatabaseOperation} databaseOperation the operation that database needs to do
	//
	// {Database} database the target database
	//
	// RETURNS:
	// {DatabaseOutput} the result return back from the database after executing the
	// operation
	// ----------------------------------------------------------------------------------------------------------------
	DatabaseOutput commandDatabase(DatabaseOperation databaseOperation);

	// ----------------------------------------------------------------------------------------------------------------
	// commandDatabase
	//
	// PURPOSE: the system print output to console.
	// PARAMETERS:
	// {String} string the output
	//
	//
	// RETURNS:
	//
	// ----------------------------------------------------------------------------------------------------------------
	void printOutput(String string);

	// ---------------------------------
	// isRunnig
	//
	// PURPOSE: return if the system is still running
	// PARAMETERS:
	//
	// RETURNS:
	// {booolean} true if system is still running and false if not.
	// ---------------------------------
	boolean isRunning();

	// ---------------------------------
	// quitSystem
	//
	// PURPOSE: turn off the system
	// PARAMETERS:
	//
	// RETURNS:
	// {void}
	// ---------------------------------
	void quitSystem();
}
