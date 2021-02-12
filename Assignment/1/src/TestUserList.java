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

class TestUserList {

	// ----------------------------------------------------------------------------------------------------------------
	// setUpBeforeClass
	//
	// PURPOSE:
	// PARAMETERS:
	// TestUserList
	//
	// RETURNS:
	// {void}
	// ----------------------------------------------------------------------------------------------------------------
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	// ----------------------------------------------------------------------------------------------------------------
	// setUp
	//
	// PURPOSE:
	// PARAMETERS:
	// TestUserList
	//
	// RETURNS:
	// {void}
	// ----------------------------------------------------------------------------------------------------------------
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() {
		UserList list = new UserListImp();

		User user1 = new UserImp("User1");
		User user2 = new UserImp("User2");
		User user3 = new UserImp("User3");

		User duplicateUser1 = new UserImp("User1");

		assertTrue(list.add(user1));
		assertTrue(list.add(user2));
		assertTrue(list.add(user3));

		assertFalse(list.add(duplicateUser1));
	}

	@Test
	void testGet() {
		UserList list = new UserListImp();

		User user1 = new UserImp("User1");
		User user2 = new UserImp("User2");
		User user3 = new UserImp("User3");

		assertTrue(list.add(user1));
		assertTrue(list.add(user2));
		assertTrue(list.add(user3));

		assertEquals(list.getUser("User1").getUserId(), "User1");
		assertEquals(list.getUser("User2").getUserId(), "User2");
		assertEquals(list.getUser("User3").getUserId(), "User3");

		assertNull(list.getUser("Non-exist"));

	}

}
