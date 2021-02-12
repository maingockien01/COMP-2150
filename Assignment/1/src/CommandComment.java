//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent the command COMMENT
// @responsibility		
//
//-----------------------------------------------------
public class CommandComment implements Command {

    private String comment;

    public CommandComment (String comment) {
        this.comment = comment;
    }
    
    @Override
    public void onCommanding (WikiSystem wikiSystem) {
        wikiSystem.printOutput (comment);
    }
    
    @Override
    public String toString() {
    	return String.format("Command: Comment");
    }
}
