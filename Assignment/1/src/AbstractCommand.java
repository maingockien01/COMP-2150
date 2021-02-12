//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Abstract class of command and database operation- implementing general functions
// @responsibility		containing the orders of the command and the database operation.
//
//-----------------------------------------------------
public abstract class AbstractCommand implements Command, DatabaseOperation {
	private static final String TO_STRING_SYNTAX = "Command: %s - User: %s - Document: %s";
	protected String userId;
	protected String documentTitle;
	protected ChangeRecord.Action action;
	private int time;
	
	public AbstractCommand(String userId, String documentTitle, ChangeRecord.Action action) {
		super();
		this.userId = userId;
		this.documentTitle = documentTitle;
		this.action = action;
		time = -1;
	}

	@Override
	public void onCommanding(WikiSystem wikiSystem) {

		DatabaseOutput output = wikiSystem.commandDatabase(this);
		wikiSystem.printOutput(output.getData());
	}

	@Override
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public int getTime () {
		return this.time;
	}
	
	@Override
	public ChangeRecord getChangeRecord() {
		ChangeRecord record = new ChangeRecordImp (userId, documentTitle, action, getTime ());
		return record;
	}
	
	@Override
	public String toString () {
		return String.format(TO_STRING_SYNTAX, action, userId, documentTitle);
	
	}
}
