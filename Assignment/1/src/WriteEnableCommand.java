//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Command that will change the data in database
//						the command need user id as checking requirements
// @responsibility		
//
//-----------------------------------------------------

public abstract class WriteEnableCommand extends AbstractCommand {	
	public WriteEnableCommand(String userId, String documentTitle, ChangeRecord.Action action) {
		super(userId, documentTitle, action);

	}

	@Override
	public void onCommanding(WikiSystem wikiSystem) {

		DatabaseOutput output = wikiSystem.commandDatabase(this);
		wikiSystem.printOutput(output.getData());
	}

	@Override
	public DatabaseOutput onOperating(Database database) {
		if (!isUserWriteEnable (database, userId)) {
			return new FailOutput("NOT FOUND");
		} else {
			return operating (database);
		}
	}
	
	private boolean isUserWriteEnable (Database database, String userId) {
		DatabaseOutput getUser = database.getUser(userId);
		return SuccessOutput.isSuccessOutput (getUser);
	}
	
	protected abstract DatabaseOutput operating (Database database);
}
