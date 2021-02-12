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

class TestDocumentFolder {

	//----------------------------------------------------------------------------------------------------------------
	// setUpBeforeClass
	//
	// PURPOSE:				
	// PARAMETERS:
	// TestDocumentFolder
	//
	// RETURNS:
	//	{void} 	
	//----------------------------------------------------------------------------------------------------------------
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	//----------------------------------------------------------------------------------------------------------------
	// setUp
	//
	// PURPOSE:				
	// PARAMETERS:
	// TestDocumentFolder
	//
	// RETURNS:
	//	{void} 	
	//----------------------------------------------------------------------------------------------------------------
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() {
		Document doc1 = new DocumentImp("Doc1");
		Document doc2 = new DocumentImp("Doc2");
		Document doc3 = new DocumentImp("Doc3");

		Document doc1_2 = new DocumentImp("Doc1");
		
		DocumentFolder folder = new DocumentFolderImp ();
		
		assertTrue (folder.add(doc1));
		assertTrue (folder.add(doc2));
		assertTrue (folder.add(doc3));
		assertFalse (folder.add(doc1_2));
		
	}
	
	@Test
	void testGet () {
		DocumentFolder folder = new DocumentFolderImp ();

		Document doc1 = new DocumentImp("Doc1");
		Document doc2 = new DocumentImp("Doc2");
		Document doc3 = new DocumentImp("Doc3");
	
		folder.add(doc1);
		folder.add(doc2);
		folder.add(doc3);
		
		assertEquals(folder.getDocument("Doc1").getTitle(), "Doc1");
		assertEquals(folder.getDocument("Doc2").getTitle(), "Doc2");
		assertEquals(folder.getDocument("Doc3").getTitle(), "Doc3");

	}

}
