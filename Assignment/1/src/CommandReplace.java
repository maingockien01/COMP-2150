//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent of command Replace
// @responsibility		
//
//-----------------------------------------------------
public class CommandReplace extends WriteEnableCommand {
    private String newLine;
    private int line;

    public CommandReplace (String userId, String documentTitle, int line, String newLine) {
        super(userId, documentTitle, ChangeRecord.Action.REPLACE_DOCUMENT);
        this.newLine = newLine;
        this.line = line;
    }

	@Override
	protected DatabaseOutput operating(Database database) {
		DatabaseOutput output = database.editDocument(documentTitle, this.line, newLine);
		return output;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " - Line: " + line + " - Content: " + newLine;
	}
}
