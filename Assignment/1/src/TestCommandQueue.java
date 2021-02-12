import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Test suite for CommandQueue
// @responsibility		
//
//-----------------------------------------------------

class TestCommandQueue {
	private static final int NUMBER_COMMANDS = 10;
	CommandQueue queue;

	// ----------------------------------------------------------------------------------------------------------------
	// setUp
	//
	// PURPOSE:
	// PARAMETERS:
	// @throws java.lang.Exception
	//
	// RETURNS:
	// {void}
	// ----------------------------------------------------------------------------------------------------------------
	@BeforeEach
	void setUp() throws Exception {
		queue = new CommandQueueImp();
	}

	// ----------------------------------------------------------------------------------------------------------------
	// testIsEmpty
	//
	// PURPOSE: test methods isEmpty
	//
	// CASE: isEmpty before and after add a command
	// ----------------------------------------------------------------------------------------------------------------
	@Test
	void testIsEmptyAfterAdding() {
		assertTrue(queue.isEmpty());

		Command command1 = new FakeCommand();

		queue.add(command1);

		assertFalse(queue.isEmpty());
	}

	// ----------------------------------------------------------------------------------------------------------------
	// testIsEmpty
	//
	// PURPOSE: test methods isEmpty
	//
	// CASE: isEmpty before and after adding a command then remove that command
	// ----------------------------------------------------------------------------------------------------------------
	@Test
	void testIsEmptyAfterAddingRemoving() {
		Command command1 = new FakeCommand();

		assertTrue(queue.isEmpty());

		queue.add(command1);
		Command removeCommand = queue.remove();

		assertEquals(command1, removeCommand);
		assertTrue(queue.isEmpty());
	}

	// ---------------------------------------------------------------------------------------------------------------
	// testQueueScaffolding
	//
	// PURPOSE: test queue implementation with a number of add, peek, and remove
	// CASE: test if is empty
	// add a number of fake command
	// test peek after each insert to make sure the command is added at the head
	// test remove that the return command would be same as the order of adding
	// commands
	// test isEmpty
	//
	// ---------------------------------------------------------------------------------------------------------------
	@Test
	void testQueue() {
		Command[] commands = new Command[NUMBER_COMMANDS];
		
		assertTrue(queue.isEmpty());
		for (int i = 0; i < NUMBER_COMMANDS; i ++) {
			commands[i] = new FakeCommand ();
			queue.add(commands[i]);
		}
		assertFalse(queue.isEmpty());
		for (int i = 0; i < NUMBER_COMMANDS; i ++) {
			Command command = queue.remove();
			assertEquals(commands[i], command);
		}
		assertTrue(queue.isEmpty());
	}

	// ----------------------------------------------------------------------------------------------------------------
	// Just a useless class for testing
	// ----------------------------------------------------------------------------------------------------------------
	class FakeCommand implements Command {
		public FakeCommand() {
		}

		@Override
		public void onCommanding(WikiSystem wikiSystem) {
			// DO nothing
		}
	}
}
