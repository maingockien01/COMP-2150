import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	
// @responsibility		
//
//-----------------------------------------------------

class TestChangeRecorder {
	HistoryRecorder recorder;
    ChangeRecord record1;
    ChangeRecord record2;
    ChangeRecord record3;
    
    ChangeRecord record4;
    ChangeRecord record5;
    ChangeRecord record6;

	@BeforeEach
	void setup () {
		recorder = new HistoryRecorderImp ();
		record1 = new ChangeRecordImp ("user1", "doc1", ChangeRecord.Action.CREATE_DOCUMENT, 0);
		record2 = new ChangeRecordImp ("user1", "doc1", ChangeRecord.Action.APPEND_DOCUMENT, 1);
        record2.setDocumentContent ("Append\n");
		record3 = new ChangeRecordImp ("user1", "doc1", ChangeRecord.Action.REPLACE_DOCUMENT, 2);
        record3.setDocumentContent ("Edit\n");

        recorder.saveRecord (record1);
        recorder.saveRecord (record2);
        recorder.saveRecord (record3);
        
        record4 = new ChangeRecordImp ("user2", "doc1", ChangeRecord.Action.CREATE_DOCUMENT, 3);
        record5 = new ChangeRecordImp ("user2", "doc1", ChangeRecord.Action.APPEND_DOCUMENT, 4);
        record5.setDocumentContent ("Append\n");
        record6 = new ChangeRecordImp ("user2", "doc1", ChangeRecord.Action.REPLACE_DOCUMENT, 5);
        record6.setDocumentContent ("Edit\n");
        
        recorder.saveRecord (record4);
        recorder.saveRecord (record5);
        recorder.saveRecord (record6);
        
		record1 = new ChangeRecordImp ("user1", "doc2", ChangeRecord.Action.CREATE_DOCUMENT, 6);
		record2 = new ChangeRecordImp ("user1", "doc2", ChangeRecord.Action.APPEND_DOCUMENT, 7);
        record2.setDocumentContent ("Append\n");
		record3 = new ChangeRecordImp ("user1", "doc2", ChangeRecord.Action.REPLACE_DOCUMENT, 8);
        record3.setDocumentContent ("Edit\n");

        recorder.saveRecord (record1);
        recorder.saveRecord (record2);
        recorder.saveRecord (record3);
        
	}
	
	@Test
	void testGetAtTime() {
		ChangeRecord atTime0 = recorder.getRecordAtTime (0);

        assertEquals (atTime0.toString(), "User: user1.\nTime: 0.\nAction: CREATE_DOCUMENT.\nDocument title: doc1.\nDocument snapshot:\n");

        ChangeRecord atTime1 = recorder.getRecordAtTime (1);

        assertEquals (atTime1.toString(), "User: user1.\nTime: 1.\nAction: APPEND_DOCUMENT.\nDocument title: doc1.\nDocument snapshot:\nAppend\n");

        ChangeRecord atTime2 = recorder.getRecordAtTime (2);

        assertEquals (atTime2.toString(), "User: user1.\nTime: 2.\nAction: REPLACE_DOCUMENT.\nDocument title: doc1.\nDocument snapshot:\nEdit\n");
	}
	
	@Test
	void testUserReport () {
		System.out.println("User Report: ");

		String user1report = recorder.getUserReport("user1");
		
		System.out.println (user1report);
	}
	
	@Test
	void testDocumentReport () {
		
		System.out.println("Document Report: ");
		
		String documentReport = recorder.getDocumentReport("doc1");
		
		System.out.println(documentReport);
	}

}
