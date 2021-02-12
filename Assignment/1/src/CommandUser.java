//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent of command User
//
//-----------------------------------------------------
public class CommandUser extends AbstractCommand {

    public CommandUser (String userId) {
    	super(userId, ChangeRecord.NULL_DOCUMENT_TITLE, ChangeRecord.Action.CREATE_USER);
    }

	@Override
	public DatabaseOutput onOperating(Database database) {
		DatabaseOutput output = database.createUser(userId);
		return output;
	}
}
