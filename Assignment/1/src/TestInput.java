import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
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

class TestInput {
	Input input;
	
	@BeforeEach
	void setup () {
		System.out.println("Set up");
		input = new InputImp ();
	
	}
	
	/**
	 * Test method for {@link InputImp#readCommand(java.lang.String)}.
	 */
	@Test
	void testReadCommand() {
		Command command1 = input.readCommand("USER user1");
		assertTrue(command1 instanceof CommandUser);
		
		Command command2 = input.readCommand("CREATE doc1 user1");
		assertTrue(command2 instanceof CommandCreate);
		
		Command command3 = input.readCommand("APPEND doc1 user1 a line");
		assertTrue(command3 instanceof CommandAppend);
		
		Command command4 = input.readCommand("REPLACE doc1 user1 0 new line");
		assertTrue(command4 instanceof CommandReplace);
		
		Command command5 = input.readCommand("DELETE doc1 user1 1");
		assertTrue(command5 instanceof CommandDelete);
		
		Command command6 = input.readCommand("RESTORE doc1 user1 0");
		assertTrue(command6 instanceof CommandRestore);
		
		Command command7 = input.readCommand("HISTORY doc1");
		assertTrue(command7 instanceof CommandHistory);
		
		Command command8 = input.readCommand("USERREPORT user1");
		assertTrue(command8 instanceof CommandUserReport);
		
		Command command9 = input.readCommand("QUIT");
		assertTrue(command9 instanceof CommandQuit);
		
//		Command command10 = input.readCommand("USER user1");
//		assertTrue(command10 instanceof CommandUser);
	}


}
