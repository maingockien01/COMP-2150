//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	List 
// @responsibility		
//
//-----------------------------------------------------

public interface List {
	// ----------------------------------------------------------------------------------------------------------------
	// addItem
	//
	// PURPOSE:
	// PARAMETERS:
	// List
	//
	// RETURNS:
	// {boolean}
	// ----------------------------------------------------------------------------------------------------------------
	boolean addItem(ListItem item);

	// ----------------------------------------------------------------------------------------------------------------
	// getItem
	//
	// PURPOSE:
	// PARAMETERS:
	// List
	//
	// RETURNS:
	// {ListItem}
	// ----------------------------------------------------------------------------------------------------------------
	ListItem getItem(String itemId);

	// ----------------------------------------------------------------------------------------------------------------
	// isThereItem
	//
	// PURPOSE:
	// PARAMETERS:
	// List
	//
	// RETURNS:
	// {boolean}
	// ----------------------------------------------------------------------------------------------------------------
	boolean isThereItem(String itemId);
}
