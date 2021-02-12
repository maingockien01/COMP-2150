
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	The command that will only read/retrieve data from database
//						So that, there is no need of saving record and checking userId
// @responsibility		
//
//-----------------------------------------------------

public abstract class ReadOnlyCommand extends AbstractCommand {

	/**
	 * @param userId
	 * @param documentTitle
	 * @param action
	 */
	public ReadOnlyCommand(String userId, String documentTitle, ChangeRecord.Action action) {
		super(userId, documentTitle, action);
	}

	@Override
	public DatabaseOutput onOperating(Database database) {
		DatabaseOutput output = operating (database);
		return new FailOutput(output.getData());
	}
	
	protected abstract DatabaseOutput operating (Database database);

}
