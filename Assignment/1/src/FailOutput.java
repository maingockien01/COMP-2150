//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	DatabaseOutput for fail case
// @responsibility		
//
//-----------------------------------------------------

public class FailOutput extends StringOutput {
	
	public static boolean isFailOutput (DatabaseOutput output) {
		return output instanceof FailOutput;
	}

	public FailOutput(String data) {
		super(data);
	}

}
