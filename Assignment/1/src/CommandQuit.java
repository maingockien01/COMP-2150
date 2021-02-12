//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	this class represent quit command from user
//
//-----------------------------------------------------
public class CommandQuit implements Command {
	
    public CommandQuit () {
    }
    
    @Override
    public void onCommanding (WikiSystem wikiSystem) {
    	wikiSystem.printOutput("STOPPING SYSTEM!");
        wikiSystem.quitSystem ();
    }
    
    @Override
    public String toString() {
    	return "Command: QUIT";
    }
}
