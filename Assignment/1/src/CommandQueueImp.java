//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Implementation of CommandQueue
// @responsibility		check CommandQueue interface file for more information
//
//-----------------------------------------------------

public class CommandQueueImp implements CommandQueue {

	private CommandContainer head;

	// --------------------------------------------------------------------
	// constructor
	//
	//
	// --------------------------------------------------------------------
	public CommandQueueImp() {
		// TODO: check Null Object pattern to prevent null pointer exception
		head = null;
	}

	// --------------------------------------------------------------------
	// DbC:
	// @param command must not be null
	// @variant after adding, head is not null
	// --------------------------------------------------------------------
	@Override
	public void add(Command command) {
		assert (command != null);

		CommandContainer container = new CommandContainerImp(command, head);
		head = container;

		assert (head != null);
	}

	@Override
	public boolean isEmpty() {

		return head == null;
	}

	@Override
	public Command peek() {
	    CommandContainer container = getLastContainer ();

        if (container == null) {
            return null;
        } else {
            return container.getCommand ();
        }
    }

	private CommandContainer getLastContainer () {
        if (head == null) {
            return null;
        };
        CommandContainer container = head;
        while (container.getNext () != null) {

            container = container.getNext ();
        }
		return container;
	}

	@Override
	public Command remove() {
		if (head == null) {
			return null;
		} else {
            CommandContainer beforeLast = getBeforeLastContainer ();
            if (beforeLast == null) {
                CommandContainer container = head;
                head = null;
                return container.getCommand ();
            } else {
                CommandContainer container = beforeLast.getNext ();
                beforeLast.setNextContainer (null);

                return container.getCommand ();
            }
		}
	}
	
	private CommandContainer getBeforeLastContainer () {
        if (head == null || head.getNext () == null) {
            return null;
        };

        CommandContainer beforeContainer = head;
        CommandContainer container = head.getNext ();

        while (container.getNext () != null) {
            
            beforeContainer = beforeContainer.getNext ();
            container = container.getNext ();
        }

        return beforeContainer;
	}
}
