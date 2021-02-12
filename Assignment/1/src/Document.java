//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Interface of Document class representing documents in system
// @responsibility		containing document information and tools to act on the document itself
//-----------------------------------------------------

public interface Document extends ListItem {
	static final int LIMIT_TITLE_LENGTH = 80;

	public static boolean validateTitle(String documentTitle) {
		if (documentTitle == null || documentTitle.contains(" ") || documentTitle.length() >= LIMIT_TITLE_LENGTH) {
			return false;
		}
		return true;

	}

	// ---------------------------------
	// getTitle
	//
	// PURPOSE:
	// PARAMETERS:
	//
	// RETURNS:
	// {String}
	// ---------------------------------
	String getTitle();

	// ---------------------------------
	// getContent
	//
	// PURPOSE:
	// PARAMETERS:
	//
	// RETURNS:
	// {String}
	// ---------------------------------
	String getContent();

	// ----------------------------------------------------------------------------------------------------------------
	// edit
	//
	// PURPOSE:
	// PARAMETERS:
	// Document
	// {int} line
	// {String} new content of the line
	// RETURNS:
	// {boolean}
	// ----------------------------------------------------------------------------------------------------------------
	boolean edit(int line, String newLine);

	// ---------------------------------
	// append
	//
	// PURPOSE:
	// PARAMETERS:
	//
	// RETURNS:
	// {boolean}
	// ---------------------------------
	boolean append(String newLine);

	// ---------------------------------
	// deleteLine
	//
	// PURPOSE:
	// PARAMETERS:
	//
	// RETURNS:
	// {boolean} if the line is deleted.
	// return false if the line is not in the document
	// ---------------------------------
	boolean deleteLine(int line);

	// ----------------------------------------------------------------------------------------------------------------
	// equals
	//
	// PURPOSE:
	// PARAMETERS:
	// Document other document
	//
	// RETURNS:
	// {boolean}
	// ----------------------------------------------------------------------------------------------------------------
	boolean equals(Document other);

	// ----------------------------------------------------------------------------------------------------------------
	// setContent
	//
	// PURPOSE:
	// PARAMETERS:
	// {String} new content
	//
	// RETURNS:
	// {void}
	// ----------------------------------------------------------------------------------------------------------------
	void setContent(String content);

}
