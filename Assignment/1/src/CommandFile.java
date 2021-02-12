//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Represent the command file	
// @responsibility		loading data from a file
//
//-----------------------------------------------------

public class CommandFile implements Command {
	private Input input;
	private String fileName;
	
	public CommandFile (Input input, String fileName) {
		this.input = input;
		this.fileName = fileName;
	}
	@Override
	public void onCommanding(WikiSystem wikiSystem) {
		input.readFile (fileName, wikiSystem);
	}
	
	@Override
	public String toString() {
		return String.format("Command: FILE - fileName: %s", fileName);
	}
}
