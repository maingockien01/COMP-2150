//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Interface for CommandContainerImp class
// @responsibility		contain a command and the reference to other container next in the queue
//
//-----------------------------------------------------

public interface CommandContainer {
	//----------------------------------------------------------------------------------------------------------------
	// getCommand
	//
	// PURPOSE:				the method is called to return the command inside container
	// PARAMETERS:
	//	
	//
	// RETURNS:
	//	{Command} 			the command that command container contain
	//----------------------------------------------------------------------------------------------------------------
	Command getCommand ();
	
	//----------------------------------------------------------------------------------------------------------------
	// getNext
	//
	// PURPOSE:				the method is called to return the next container
	// PARAMETERS:
	//	
	//
	// RETURNS:
	//	{CommandContainer} 	the next container
	//----------------------------------------------------------------------------------------------------------------
	CommandContainer getNext ();
	
	//----------------------------------------------------------------------------------------------------------------
	// setNextContainer
	//
	// PURPOSE:				the method is called to return if the queue is empty 
	// PARAMETERS:
	//	{CommandContainer}	container this container point to
	//
	// RETURNS:
	//	
	//----------------------------------------------------------------------------------------------------------------
	void setNextContainer (CommandContainer nextContainer);
}
