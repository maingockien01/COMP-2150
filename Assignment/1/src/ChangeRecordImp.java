//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Implementation of change record interface
// @responsibility		
//
//-----------------------------------------------------

public class ChangeRecordImp implements ChangeRecord {	
	//fields are read-only !!!
	private String userId;
	private String documentTitle;
	private Action action;
	private int time;
	
	//write-enable
	private String documentContent;
	
	/**
	 * @param userId
	 * @param documentTitle
	 * @param action
	 * @param time
	 */
	public ChangeRecordImp(String userId, String documentTitle, Action action, int time) {
		super();
		this.userId = userId;
		this.documentTitle = documentTitle;
		this.action = action;
		this.time = time;
		
		this.documentContent = ""; 
	}

	@Override
	public String getUserId() {
		return this.userId;
	}

	@Override
	public String getDocumentTitle() {
		return this.documentTitle;
	}

	@Override
	public Action getAction() {
		return this.action;
	}

	@Override
	public int getTime() {
		return this.time;
	}

	@Override
	public String getDocumentContent() {
		return this.documentContent;
	}
	
	/**
	 * @param documentContent the documentContent to set
	 */
	@Override
	public void setDocumentContent(String documentContent) {
		this.documentContent = documentContent;
	}

	@Override
	public String getItemId() {
		return this.time + "";
	}

    @Override
    public String toString () {
        return String.format(ChangeRecord.TO_STRING_FORMAT, this.userId,this.time, this.action, this.documentTitle, this.documentContent);
    }

}
