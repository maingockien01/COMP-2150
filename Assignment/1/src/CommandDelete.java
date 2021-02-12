//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent the command delete
// @responsibility		delete a line in a document
//
//-----------------------------------------------------

public class CommandDelete extends WriteEnableCommand {
	private int line;

	public CommandDelete(String userId, String documentTitle, int line) {
		super(userId, documentTitle, ChangeRecord.Action.DELETE_LINE);
		this.line = line;
	}

	@Override
	protected DatabaseOutput operating(Database database) {
		DatabaseOutput output = database.deleteDocument(documentTitle, this.line);
		return output;
	}
	
	@Override
	public String toString() {
		return super.toString().concat(" - line: " + line);
	}
}