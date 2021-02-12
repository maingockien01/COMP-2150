//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Success return
// @responsibility		
//
//-----------------------------------------------------

public class SuccessOutput extends StringOutput {

	public static boolean isSuccessOutput (DatabaseOutput output) {
		return output instanceof SuccessOutput;
	}
	public SuccessOutput(String data) {
		super(data);
	}

}
