
//-----------------------------------------
// NAME				: KIEN MAI
// STUDENT NUMBER	: 7876083
// COURSE			: COMP 2150
// INSTRUCTOR		: your instructor
// ASSIGNMENT		: #1      
// 
// REMARKS			: stimulate the work of wiki system
//
//
//-----------------------------------------
import java.util.Scanner;

public class Main {
	private Input input;
	private WikiSystem wikiSystem;
	private Database database;

	private Scanner keyboard;

	public static void main(String[] args) {

		Main main = new Main();
		main.run();

	}

	public Main() {
		input = new InputImp();
		database = new DatabaseImp();
		wikiSystem = new WikiSystemImp(database);

		keyboard = new Scanner(System.in);
	}

	public void run() {
		System.out.println("Welcome to Wiki system.");
		System.out.println(
				"To load the commands from file, please put the file in the current folder and use command: FILE [fileName].");
		while (wikiSystem.isRunning()) {
			System.out.println("Please type your command following the syntax: ");
			String commandString = keyboard.nextLine();
			Command command = input.readCommand(commandString);
			wikiSystem.loadCommand(command);
			wikiSystem.commanding();
		}
		System.out.println("Thank you for using Wiki System");

	}
}
