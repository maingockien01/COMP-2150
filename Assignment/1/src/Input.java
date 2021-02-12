//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	in charge of reading input and translating to command
// @responsibility		
//
//-----------------------------------------------------
public interface Input {

	// ----------------------------------------------------------------------------------------------------------------
	// readCommand
	//
	// PURPOSE:
	// PARAMETERS:
	// Input
	//
	// RETURNS:
	// {Command}
	// ----------------------------------------------------------------------------------------------------------------
	Command readCommand(String input);

	// ----------------------------------------------------------------------------------------------------------------
	// readFile
	//
	// PURPOSE: load file to command into wiki system
	// PARAMETERS:
	// 
	//
	// RETURNS:
	// {void}
	// ----------------------------------------------------------------------------------------------------------------
	void readFile(String fileName, WikiSystem wikiSystem);
}
