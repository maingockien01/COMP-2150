//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	ADS Queue for storing commands
// @responsibility		ADS Queue
//
//-----------------------------------------------------
public interface CommandQueue {
	//----------------------------------------------------------------------------------------------------------------
	// add
	//
	// PURPOSE:				add command to the head of the queue
	// PARAMETERS:
	//	{Command} command 	command object not null
	//
	// RETURNS:
	//	{void} 	
	//----------------------------------------------------------------------------------------------------------------
	void add (Command command);
	
	//----------------------------------------------------------------------------------------------------------------
	// isEmpty
	//
	// PURPOSE:				the method is called to return if the queue is empty 
	// PARAMETERS:
	//	
	//
	// RETURNS:
	//	{boolean} 			if the queue is empty
	//----------------------------------------------------------------------------------------------------------------
	boolean isEmpty ();
	
	//----------------------------------------------------------------------------------------------------------------
	// peek
	//
	// PURPOSE:				the method is called to return the head of the queue without removing the element
	// PARAMETERS:
	//	
	//
	// RETURNS:
	//	{Command} 		 	command object at the head
	//----------------------------------------------------------------------------------------------------------------
	Command peek ();
	
	//----------------------------------------------------------------------------------------------------------------
	// remove
	//
	// PURPOSE:				the method is called to return the head of the queue and remove the element
	// PARAMETERS:
	//	
	//
	// RETURNS:
	//	{Command} 		 	command object at the head
	//----------------------------------------------------------------------------------------------------------------
	Command remove ();
}
