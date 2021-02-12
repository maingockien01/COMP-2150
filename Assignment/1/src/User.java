//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Interface of User class
//
//-----------------------------------------------------
public interface User extends ListItem {
    static final int LIMIT_ID_LENGTH = 80;

    public static boolean validateID (String userId) {
        if (userId == null || userId.contains (" ") || userId.length() >= LIMIT_ID_LENGTH) {
            return false;
        }
        return true;
    }
    
    //---------------------------------
    // getUserId
    //
    // PURPOSE:				
    // PARAMETERS:
    //
    // RETURNS:
    //  {String}            Id of user
    //---------------------------------
    String getUserId ();

}
