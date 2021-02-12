
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	
//
//-----------------------------------------------------
public class DocumentFolderImp implements DocumentFolder {
    
    private List documents;

    public DocumentFolderImp () {
        documents = new GeneralList ();
    }
    
    @Override
    public boolean add (Document document) {
        
        return documents.addItem(document);

    }
    
    @Override
    public Document getDocument (String documentTitle) {
        

    	return (Document) documents.getItem(documentTitle);
    }

    @Override
    public boolean isThereDocument (String documentTitle) {
        return documents.isThereItem (documentTitle);
    }
}

