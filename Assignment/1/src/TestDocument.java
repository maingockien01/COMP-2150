import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

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

class TestDocument {
    static final String DOCUMENT_TITLE_1 = "Testing 1";
    static final String DOCUMENT_CONTENT_1 = "This is document content1";

	//----------------------------------------------------------------------------------------------------------------
	// setUpBeforeClass
	//
	// PURPOSE:				
	// PARAMETERS:
	// TestDocument
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
	// TestDocument
	//
	// RETURNS:
	//	{void} 	
	//----------------------------------------------------------------------------------------------------------------
	@BeforeEach
	void setUp() throws Exception {
	}

    @Test
    void testConstructor () {
        Document doc1 = new DocumentImp ("Doc1");
        assertTrue(doc1.getTitle().equals("Doc1"));

        Document doc2 = new DocumentImp ("Doc2", "Fake content for document 2");
        assertTrue(doc2.getTitle().equals("Doc2"));
        assertTrue(doc2.getContent().equals("Fake content for document 2"));

    }

	@Test
	void testAppendEmptyDocument() {
        Document document = new DocumentImp (DOCUMENT_TITLE_1);

        assertTrue (document.getContent().equals(""));

        String newLine = "This is new line";

        document.append(newLine);
        
        out.println("After append: " + document.getContent());
        assertTrue (document.getContent().equals(newLine));
	}
	
	@Test
	void testAppendNonEmptyDocument () {
		Document document = new DocumentImp (DOCUMENT_TITLE_1, DOCUMENT_CONTENT_1);
		
        String newLine = "This is new line";
        
		document.append(newLine);
		
        assertTrue (document.getContent().equals(DOCUMENT_CONTENT_1+newLine));

	}
	
	@Test
	void testReplaceLineParam () {
        Document document1 = new DocumentImp (DOCUMENT_TITLE_1);
		Document document2 = new DocumentImp (DOCUMENT_TITLE_1, DOCUMENT_CONTENT_1);
		
		assertFalse(document1.edit(0, "The document is empty, cannot edit"));
        assertFalse(document2.edit(1, "The document has only 1 line, should be false"));
        assertFalse(document2.edit(-1, "The input should be positive"));

        assertTrue(document2.edit(0, "This should be true"));

	}
	
	@Test
	void testReplaceNormally () {
		
		Document document2 = new DocumentImp (DOCUMENT_TITLE_1, DOCUMENT_CONTENT_1);
        assertTrue(document2.edit(0, "This should be true"));
        assertTrue(document2.getContent().equals("This should be true"));

        Document document3 = new DocumentImp ("DOCUMENT 2", "Line1\nLine2\nLine3\n");
        document3.edit(1, "NewLine2");
        assertEquals("Line1\nNewLine2\nLine3\n", document3.getContent());
	}

    @Test
    void testDeleteLineParam () {
        Document document1 = new DocumentImp (DOCUMENT_TITLE_1);
		Document document2 = new DocumentImp (DOCUMENT_TITLE_1, DOCUMENT_CONTENT_1);
		
		assertFalse(document1.deleteLine(0));
        assertFalse(document2.deleteLine(1));
        assertFalse(document2.deleteLine(-1));

        assertTrue(document2.deleteLine(0));

       
    }

    @Test
    void testDeleteContent () {
        Document document3 = new DocumentImp ("DOCUMENT 2", "Line1\nLine2\nLine3\n");
        document3.deleteLine(1);
        assertEquals("Line1\nLine3\n", document3.getContent());
    }
	

}
