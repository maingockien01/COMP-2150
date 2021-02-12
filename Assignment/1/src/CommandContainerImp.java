//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	Command Container Implementation
// @responsibility		check ComandContainer interface for more information
//
//-----------------------------------------------------

public class CommandContainerImp implements CommandContainer {
	// Read-only
	private Command command;

	// Write enable
	private CommandContainer nextContainer;

	// --------------------------------------------------------------------------------
	// constructor there is no default constructor
	// so developer has to provide the command to create objects
	// PARAMS:
	// {Command} the command that container has
	// the command is read-only and only provided by constructor
	//
	//
	// DbC:
	// @param command it must not be null
	// --------------------------------------------------------------------------------
	public CommandContainerImp(Command command) {
		assert (command != null);

		this.command = command;
		this.nextContainer = null;
	}

	// --------------------------------------------------------------------------------
	// constructor there is no default constructor
	// so developer has to provide the command to create objects
	// this constructor is used when there is another container ready
	//
	// PARAMS:
	// {Command} the command that container has
	// the command is read-only and only provided by constructor
	//
	// {CommandContainer} the next container
	//
	// DbC:
	// @param command it must not be null
	// --------------------------------------------------------------------------------
	public CommandContainerImp(Command command, CommandContainer nextContainer) {
		assert (command != null);

		this.command = command;
		this.nextContainer = nextContainer;
	}

	@Override
	public Command getCommand() {
		return this.command;
	}

	@Override
	public CommandContainer getNext() {
		return this.nextContainer;
	}

	@Override
	public void setNextContainer(CommandContainer nextContainer) {
		this.nextContainer = nextContainer;
	}

}
