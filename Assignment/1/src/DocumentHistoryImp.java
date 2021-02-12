//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Implementation of DocumentHistory
//
//-----------------------------------------------------
public class DocumentHistoryImp implements DocumentHistory {
    private List documentsHistory;

    public DocumentHistoryImp () {
        documentsHistory = new GeneralList ();
    }
    
    @Override
    public String getDocumentReport (String documentTitle) {
        ListItem documentReport = documentsHistory.getItem (documentTitle);
        if (documentReport != null) {
        	return documentReport.toString ();
        } else {
        	return "DOCUMENT HAS NO REPORT";
        }
    }


    @Override
    public boolean saveDocumentChange (ChangeRecord record) {
        if (!documentsHistory.isThereItem (record.getDocumentTitle ())) {
            ListItem newDocument = new ListAsItem (record.getDocumentTitle ());

            documentsHistory.addItem (newDocument);
        }

        ListAsItem documentHistory = (ListAsItem) documentsHistory.getItem (record.getDocumentTitle ());

        documentHistory.addItem (record);

        return true;
    }
}
