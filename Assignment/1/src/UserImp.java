
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Implementation of User
//
//-----------------------------------------------------
public class UserImp implements User {
    //read-only
    private String userId;

    public UserImp (String userId) {
        this.userId = userId;
    }

    @Override
    public String getUserId () {
        return this.userId;
    }

	@Override
	public String getItemId() {
		
		return userId;
	}
}
