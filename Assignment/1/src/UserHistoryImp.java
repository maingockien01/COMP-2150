//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Implementation of user History
// @responsibility		
//
//-----------------------------------------------------
public class UserHistoryImp implements UserHistory {
	private List usersHistory;

	public UserHistoryImp() {
		usersHistory = new GeneralList();
	}

	@Override
	public String getUserReport(String userId) {
		ListItem userReport = usersHistory.getItem(userId);

		if (userReport == null) {
			return "NOT FOUND USER";
		} else {
			return userReport.toString();
		}
	}

	@Override
	public boolean saveUserChange(ChangeRecord record) {
		// If user not exist
		// create new user
		// add record into user history

		if (!usersHistory.isThereItem(record.getUserId())) {
			ListItem newUser = new ListAsItem(record.getUserId());
			usersHistory.addItem(newUser);
		}
		;
		ListAsItem user = (ListAsItem) usersHistory.getItem(record.getUserId());

		user.addItem(record);

		return true;
	}
}
