//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Output contain String as data returned
// @responsibility		
//
//-----------------------------------------------------
public class StringOutput implements DatabaseOutput {
    private String data;
    
    public StringOutput (String data) {
        this.data = data;
    }

    @Override
    public String getData () {
        return this.data;
    }
}
