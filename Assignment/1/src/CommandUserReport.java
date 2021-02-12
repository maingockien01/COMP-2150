//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent of Command User Report
// @responsibility		
//
//-----------------------------------------------------
public class CommandUserReport extends ReadOnlyCommand {
	public CommandUserReport(String userId) {
		super(userId, "NULL", ChangeRecord.Action.REPORT_USER);
	}

	@Override
	protected DatabaseOutput operating(Database database) {
		DatabaseOutput output = database.getUserHistory(userId);
		return output;
	}
	
	@Override
	public String toString() {
		return String.format("Command: %s - User: %s", action, userId);
	}
}
