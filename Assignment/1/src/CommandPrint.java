public class CommandPrint extends ReadOnlyCommand {
    public CommandPrint (String documentTitle) {
        super("NULL", documentTitle, ChangeRecord.Action.PRINT_DOCUMENT);
    }

	@Override
	protected DatabaseOutput operating(Database database) {
        DatabaseOutput output = database.getDocument (documentTitle);
		return output;
	}
	
	@Override
	public String toString() {
		return String.format("Command: %s - Document: %s", action, documentTitle);
	}
}
