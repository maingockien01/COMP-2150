//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent the Command Create
// @responsibility		create a document
//
//-----------------------------------------------------
public class CommandCreate extends WriteEnableCommand {

	public CommandCreate(String documentTitle, String userId) {
		super(userId, documentTitle, ChangeRecord.Action.CREATE_DOCUMENT);
	}

	@Override
	protected DatabaseOutput operating(Database database) {
		DatabaseOutput documentOutput = database.createDocument(documentTitle);
		return documentOutput;
	}

}
