//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent of Command History
// @responsibility		
//
//-----------------------------------------------------
public class CommandHistory extends ReadOnlyCommand {
    public CommandHistory (String documentTitle) {
        //TODO: null user
        super("NULL", documentTitle, ChangeRecord.Action.HISTORY_DOCUMENT);
    }

	@Override
	protected DatabaseOutput operating(Database database) {
        DatabaseOutput output = database.getDocumentHistory (documentTitle);
		return output;
	}
	
	@Override
	public String toString() {
		
		return String.format("Command: %s - Document: %s", action, documentTitle);
	}
}
