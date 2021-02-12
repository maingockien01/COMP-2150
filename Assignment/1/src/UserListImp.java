//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	implementation of UserList
//
//-----------------------------------------------------
public class UserListImp implements UserList {

    private List users;
    
    public UserListImp () {        
        users = new GeneralList ();
    }

    @Override
    public boolean add (User user) {

        return users.addItem(user);
    }

    @Override
    public boolean isDuplicate (String userId) {
        

        return users.isThereItem(userId);
    }
    
    @Override
    public User getUser (String userId) {
        return (User) users.getItem(userId);
    }

}
