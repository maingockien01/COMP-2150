import static java.lang.System.out;
import static java.lang.System.err;

//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	System Implementation	
// @responsibility		
//
//-----------------------------------------------------
public class WikiSystemImp implements WikiSystem {
	private CommandQueue commandQueue;
	private boolean isRunning;
	private Database database;

	private int time;

	public WikiSystemImp(Database database) {
		time = -1;
		commandQueue = new CommandQueueImp();
		isRunning = true;
		this.database = database;
	}

	@Override
	public void loadCommand(Command command) {
		if (!isRunning) {
			err.println("System is shut down! Cannot process the function!");
			return;
		}

		if (command == null) {
			return;
		}

		assert (command != null);

		commandQueue.add(command);
	}

	@Override
	public void loadCommands(Command... commands) {
		if (!isRunning) {
			err.println("System is shut down! Cannot process the function!");
			return;
		}

		if (commands == null) {
			return;
		}

		assert (commands != null);

		for (Command command : commands) {
			if (command != null) {
				commandQueue.add(command);
			}
		}
	}

	@Override
	public void commanding() {
		if (!isRunning) {
			err.println("System is shut down! Cannot process the function!");
			return;
		}

		while (!commandQueue.isEmpty()) {

			Command command = commandQueue.remove();
			if (!(command instanceof CommandComment || command instanceof CommandFile)) {
				time++;
				System.out.println(String.format("--- %d ---", time));
				System.out.println("***Processing: " + command);
			}

			command.onCommanding(this);
		}
	}

	@Override
	public DatabaseOutput commandDatabase(DatabaseOperation databaseOperation) {
		if (!isRunning) {
			err.println("System is shut down! Cannot process the function!");
			return new FailOutput("THE SYSTEM HAS BEEN SHUT DOWN!");
		}
		databaseOperation.setTime(time);
		return database.operating(databaseOperation);
	}

	@Override
	public void printOutput(String output) {
		if (!isRunning) {
			return;
		}

		out.println(output);
	}

	@Override
	public boolean isRunning() {
		return this.isRunning;
	}

	@Override
	public void quitSystem() {
		this.isRunning = false;
	}
}
