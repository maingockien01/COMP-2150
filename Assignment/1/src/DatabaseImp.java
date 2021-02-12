
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	
//
//-----------------------------------------------------
public class DatabaseImp implements Database {
	private DocumentFolder documents;
	private UserList users;
	private HistoryRecorder history;

	public DatabaseImp() {
		documents = new DocumentFolderImp();
		users = new UserListImp();
		history = new HistoryRecorderImp();

	}

	@Override
	public DatabaseOutput operating(DatabaseOperation operation) {
		DatabaseOutput output = operation.onOperating(this);

		if (SuccessOutput.isSuccessOutput(output)) {
			ChangeRecord record = operation.getChangeRecord();
			saveChange(record);
		}

		return output;
	}

	@Override
	public DatabaseOutput getUser(String userId) {
		User user = users.getUser(userId);

		if (user == null) {
			return new NotFoundOutput();
		} else {
			return new FoundOutput();
		}
	}

	@Override
	public DatabaseOutput createUser(String userId) {
		if (!User.validateID(userId)) {
			return new FailOutput("INVALID INPUT");
		}
		if (users.isDuplicate(userId)) {
			return new FailOutput("DUPLICATE");
		}
		User newUser = new UserImp(userId);
		users.add(newUser);

		return new SuccessOutput("CONFIRMED");
	}

	@Override
	public DatabaseOutput createDocument(String documentTitle) {
		if (!Document.validateTitle(documentTitle)) {
			return new FailOutput("INVALID INPUT");
		}
		;
		if (documents.isThereDocument(documentTitle)) {
			return new FailOutput("DUPLICATE");
		}

		Document newDocument = new DocumentImp(documentTitle);

		documents.add(newDocument);

		return new SuccessOutput("CONFIRMED");

	}

	public DatabaseOutput getDocument(String documentTitle) {
		Document document = documents.getDocument(documentTitle);
		if (document == null) {
			return new FailOutput("NOT FOUND");
		} else {
			return new SuccessOutput(document.getContent());
		}
	}

	public DatabaseOutput appendDocument(String documentTitle, String newLine) {
		if (!documents.isThereDocument(documentTitle)) {
			return new FailOutput("NOT FOUND");
		}
		;

		Document document = documents.getDocument(documentTitle);
		if (!document.getContent().equals("")) {
			document.append("\n");
		}
		document.append(newLine);

		return new SuccessOutput("SUCCESS");
	}

	public DatabaseOutput editDocument(String documentTitle, int line, String content) {
		if (!documents.isThereDocument(documentTitle)) {
			return new FailOutput("NOT FOUND");
		}
		;

		Document document = documents.getDocument(documentTitle);
		boolean isSuccess = document.edit(line, content);

		if (isSuccess) {
			return new SuccessOutput("SUCESS");
		} else {
			return new FailOutput("FAIL");
		}

	}

	public DatabaseOutput deleteDocument(String documentTitle, int line) {
		if (!documents.isThereDocument(documentTitle)) {
			return new FailOutput("NOT FOUND");
		}
		;

		Document document = documents.getDocument(documentTitle);

		boolean isSuccess = document.deleteLine(line);

		if (isSuccess) {
			return new SuccessOutput("SUCCESS");
		} else {
			return new FailOutput("FAIL");
		}
	}

	public DatabaseOutput restoreDocument(String documentTitle, int time) {
		if (!documents.isThereDocument(documentTitle)) {
			return new FailOutput("NOT FOUND");
		}
		;

		ChangeRecord record = history.getRecordAtTime(time);
		if (record == null) {
			return new FailOutput("INVALID TIME");
		}
		String contentAtTime = record.getDocumentContent();

		Document document = documents.getDocument(documentTitle);

		document.setContent(contentAtTime);

		return new SuccessOutput("Restore content: " + document.getContent());
	}

	public DatabaseOutput saveChange(ChangeRecord record) {
		DatabaseOutput documentSnapshot = getDocument(record.getDocumentTitle());
		record.setDocumentContent(documentSnapshot.getData());
		history.saveRecord(record);
		
		return new SuccessOutput("SUCCESS");
	}

	public DatabaseOutput getDocumentHistory(String documentTitle) {
		Document document = documents.getDocument(documentTitle);
		if (document == null) {
			return new FailOutput("NOT FOUND");
		}
		;

		String documentHistory = history.getDocumentReport(documentTitle);

		return new SuccessOutput(documentHistory);
	}

	public DatabaseOutput getUserHistory(String userId) {
		if (!users.isDuplicate(userId)) {
			return new FailOutput("-NOT FOUND");
		}

		String userReport = history.getUserReport(userId);

		return new SuccessOutput(userReport);
	}
	
	

}
