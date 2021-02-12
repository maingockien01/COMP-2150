import static org.junit.jupiter.api.Assertions.*;

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

class TestDatabase {
	Database database;

	@BeforeEach
	void setupEach() {
		database = new DatabaseImp();

	}

	@Test
	void testGetUser() {
		DatabaseOutput output1 = database.createUser("User1");
		assertEquals(output1.getData(), "CONFIRMED");
		DatabaseOutput output2 = database.createUser("User2");
		assertEquals(output2.getData(), "CONFIRMED");
		DatabaseOutput output3 = database.createUser("User3");
		assertEquals(output3.getData(), "CONFIRMED");

		DatabaseOutput output4 = database.getUser("User1");
		assertEquals(output4.getData(), "FOUND");
		DatabaseOutput output5 = database.getUser("User2");
		assertEquals(output5.getData(), "FOUND");
		DatabaseOutput output6 = database.getUser("User4");
		assertEquals(output6.getData(), "NOT FOUND");
	}

	@Test
	void testCreateUser() {
		DatabaseOutput output1 = database.createUser("User1");
		assertEquals(output1.getData(), "CONFIRMED");
		DatabaseOutput output2 = database.createUser("User2");
		assertEquals(output2.getData(), "CONFIRMED");
		DatabaseOutput output3 = database.createUser("User3");
		assertEquals(output3.getData(), "CONFIRMED");

		DatabaseOutput output4 = database.createUser("User1");
		assertEquals(output4.getData(), "DUPLICATE");

		DatabaseOutput output5 = database.createUser("User space");
		assertEquals(output5.getData(), "INVALID INPUT");
	}

	@Test
	void testCreateDocument() {
		DatabaseOutput output1 = database.createDocument("Doc1");
		assertEquals(output1.getData(), "CONFIRMED");

		DatabaseOutput output2 = database.createDocument("Doc2");
		assertEquals(output2.getData(), "CONFIRMED");

		DatabaseOutput output3 = database.createDocument("Doc1");
		assertEquals(output3.getData(), "DUPLICATE");

		DatabaseOutput output4 = database.createDocument("Doc and space");
		assertEquals(output4.getData(), "INVALID INPUT");

	}

	@Test
	void testGetDocument() {
		database.createDocument("Doc1");
		database.appendDocument("Doc1", "First line");
		database.appendDocument("Doc1", "Second line");

		DatabaseOutput output1 = database.getDocument("Doc1");
		assertEquals(output1.getData(), "First line\nSecond line");

		database.createDocument("Doc2");

		DatabaseOutput output2 = database.getDocument("Doc2");
		assertEquals(output2.getData(), "");

		DatabaseOutput output3 = database.getDocument("Doc3");
		assertEquals(output3.getData(), "NOT FOUND");

	}

	@Test
	void testEditDocument() {
		database.createDocument("Doc1");
		database.appendDocument("Doc1", "First line");
		database.appendDocument("Doc1", "Second line");
		database.appendDocument("Doc1", "Third line");

		DatabaseOutput output1 = database.getDocument("Doc1");
		assertEquals(output1.getData(), "First line\nSecond line\nThird line");

		database.editDocument("Doc1", 0, "first line");
		database.editDocument("Doc1", 1, "second line");
		database.editDocument("Doc1", 2, "third line");

		DatabaseOutput output2 = database.getDocument("Doc1");
		assertEquals(output2.getData(), "first line\nsecond line\nthird line");

		DatabaseOutput output3 = database.editDocument("Doc2", 0, "Whart");
		assertEquals(output3.getData(), "NOT FOUND");

		DatabaseOutput output4 = database.editDocument("Doc1", 4, "Whart");
		assertEquals(output4.getData(), "FAIL");

	}

	@Test
	void testDeleteDocument() {
		database.createDocument("Doc1");
		database.appendDocument("Doc1", "First line");
		database.appendDocument("Doc1", "Second line");
		database.appendDocument("Doc1", "Third line");

		DatabaseOutput output1 = database.getDocument("Doc1");
		assertEquals(output1.getData(), "First line\nSecond line\nThird line");

		database.deleteDocument("Doc1", 2);

		DatabaseOutput output2 = database.getDocument("Doc1");
		assertEquals(output2.getData(), "First line\nSecond line");

		database.deleteDocument("Doc1", 0);

		DatabaseOutput output3 = database.getDocument("Doc1");
		assertEquals(output3.getData(), "Second line");

		DatabaseOutput output5 = database.deleteDocument("Doc2", 0);
		assertEquals(output5.getData(), "NOT FOUND");

		DatabaseOutput output6 = database.deleteDocument("Doc1", 1);
		assertEquals(output6.getData(), "FAIL");
	}

	@Test
	void testDatabaseAndCommand() {
		// Command: USER, CREATE, APPEND, REPLACE
		System.out.println("Starting test database and command: USER, CREATE, APPEND, REPLACE");
		DatabaseOperation command1 = new CommandUser("user1");
		command1.setTime(0);
		DatabaseOperation command2 = new CommandCreate("doc1", "user1");
		command2.setTime(1);
		DatabaseOperation command3 = new CommandAppend("user1", "doc1", "First line");
		command3.setTime(2);
		DatabaseOperation command4 = new CommandAppend("user1", "doc1", "Second line");
		command4.setTime(3);
		DatabaseOperation command5 = new CommandAppend("user1", "doc1", "Third line");
		command5.setTime(4);

		System.out.println("Operating");
		command1.onOperating(database);
		command2.onOperating(database);
		command3.onOperating(database);
		command4.onOperating(database);
		command5.onOperating(database);

		DatabaseOutput output1 = database.getDocument("doc1");
		assertEquals(output1.getData(), "First line\nSecond line\nThird line");

		DatabaseOperation command6 = new CommandReplace("user1", "doc1", 2, "third line");
		command6.setTime(5);
		DatabaseOperation command7 = new CommandReplace("user1", "doc1", 1, "second line");
		command7.setTime(6);
		DatabaseOperation command8 = new CommandReplace("user1", "doc1", 0, "first line");
		command8.setTime(7);

		command6.onOperating(database);
		command7.onOperating(database);
		command8.onOperating(database);

		DatabaseOutput output2 = database.getDocument("doc1");
		assertEquals(output2.getData(), "first line\nsecond line\nthird line");
	}

	@Test
	void testDocumentHistory() {
		Database database = new DatabaseImp ();
		// Command: USER, CREATE, APPEND, REPLACE
		DatabaseOperation command1 = new CommandUser("user1");
		command1.setTime(0);
		DatabaseOperation command2 = new CommandCreate("doc1", "user1");
		command2.setTime(1);
		DatabaseOperation command3 = new CommandAppend("user1", "doc1", "First line");
		command3.setTime(2);
		DatabaseOperation command4 = new CommandAppend("user1", "doc1", "Second line");
		command4.setTime(3);
		DatabaseOperation command5 = new CommandAppend("user1", "doc1", "Third line");
		command5.setTime(4);

		database.operating(command1);
		database.operating(command2);
		database.operating(command3);
		database.operating(command4);
		database.operating(command5);


		DatabaseOutput output2 = database.getDocument("doc1");
		assertEquals(output2.getData(), "First line\nSecond line\nThird line");
		//Starting restore
		DatabaseOperation restore1 = new CommandRestore ("user1", "doc1", 2);
		restore1.setTime(5);
		
		database.operating(restore1);
		
		DatabaseOutput output4 = database.getDocument("doc1");
		assertEquals(output4.getData(), "First line");
		
		DatabaseOperation restore2 = new CommandRestore ("user1", "doc1", 4);
		restore1.setTime(6);
		
		database.operating(restore2);
		
		DatabaseOutput output5 = database.getDocument("doc1");
		assertEquals(output5.getData(), "First line\nSecond line\nThird line");
		
		DatabaseOutput documentHis1 = database.getDocumentHistory("doc1");
		assertEquals(documentHis1.getData(), "User: user1.\n" + 
				"Time: 1.\n" + 
				"Action: CREATE_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 2.\n" + 
				"Action: APPEND_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 3.\n" + 
				"Action: APPEND_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"Second line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 4.\n" + 
				"Action: APPEND_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"Second line\n" + 
				"Third line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 5.\n" + 
				"Action: RESTORE_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: -1.\n" + 
				"Action: RESTORE_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"Second line\n" + 
				"Third line\n" + 
				"----------\n" + 
				"");
		
		DatabaseOutput userHis1 = database.getUserHistory("user1");
		assertEquals(userHis1.getData(), "User: user1.\n" + 
				"Time: 0.\n" + 
				"Action: CREATE_USER.\n" + 
				"Document title: NULL.\n" + 
				"Document snapshot:\n" + 
				"NOT FOUND\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 1.\n" + 
				"Action: CREATE_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 2.\n" + 
				"Action: APPEND_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 3.\n" + 
				"Action: APPEND_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"Second line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 4.\n" + 
				"Action: APPEND_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"Second line\n" + 
				"Third line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: 5.\n" + 
				"Action: RESTORE_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"----------\n" + 
				"User: user1.\n" + 
				"Time: -1.\n" + 
				"Action: RESTORE_DOCUMENT.\n" + 
				"Document title: doc1.\n" + 
				"Document snapshot:\n" + 
				"First line\n" + 
				"Second line\n" + 
				"Third line\n" + 
				"----------\n" + 
				"" );
	}

}
