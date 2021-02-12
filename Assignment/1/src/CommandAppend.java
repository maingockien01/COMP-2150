
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	represent the command APPEND
// @responsibility		
//
//-----------------------------------------------------

public class CommandAppend extends WriteEnableCommand {
	private String newContent;

	public CommandAppend(String userId, String documentTitle, String newContent) {
		super(userId, documentTitle, ChangeRecord.Action.APPEND_DOCUMENT);
		this.newContent = newContent;
	}

	@Override
	protected DatabaseOutput operating(Database database) {
		DatabaseOutput output = database.appendDocument(documentTitle, newContent);
		return output;
	}
	
	@Override
	public String toString () {
		return super.toString() + " - New content: " + newContent;
	
	}
}
