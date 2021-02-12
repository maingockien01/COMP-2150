//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	implementation of history recorder
// @responsibility		
//
//-----------------------------------------------------

public class HistoryRecorderImp implements HistoryRecorder {
	private List timeOrderedHistory;
	private DocumentHistory documentHistory;
	private UserHistory userHistory;

	public HistoryRecorderImp() {
		timeOrderedHistory = new GeneralList();
		documentHistory = new DocumentHistoryImp();
		userHistory = new UserHistoryImp();
	}

	@Override
	public String getUserReport(String userId) {
		return userHistory.getUserReport(userId);
	}

	@Override
	public String getDocumentReport(String documentTitle) {
		return documentHistory.getDocumentReport(documentTitle);
	}

	@Override
	public void saveRecord(ChangeRecord record) {
		timeOrderedHistory.addItem(record);
		documentHistory.saveDocumentChange(record);
		userHistory.saveUserChange(record);
	}

	@Override
	public ChangeRecord getRecordAtTime(int time) {

		return (ChangeRecord) timeOrderedHistory.getItem("" + time);
	}

}
