
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent of Command Restore
// @responsibility		
//
//-----------------------------------------------------

public class CommandRestore extends WriteEnableCommand {
    private int atTime;

	public CommandRestore(String userId, String documentTitle, int atTime) {
		super(userId, documentTitle, ChangeRecord.Action.RESTORE_DOCUMENT);
        this.atTime = atTime;
	}

	
	@Override
	protected DatabaseOutput operating(Database database) {
		DatabaseOutput output;
		output = database.restoreDocument(documentTitle, atTime);
		return output;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - At Time: " + atTime;
	}
}
