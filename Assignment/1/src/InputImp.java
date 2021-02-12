import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//----------------------------------------------------
//CLASS			: 	COMP 2150
//
//AUTHOR			: 	Kien Mai
//
//REMARKS			: 	implementation of input interface
//@responsibility		
//
//-----------------------------------------------------
public class InputImp implements Input {
    
    private static final int INDEX_COMMAND_TYPE = 0;
    private static final int INDEX_COMMAND_DETAIL = 1;
    
    private static final String COMMAND_TOKEN_DELIMITER = " ";
    private static final int COMMAND_TOKEN_LIMIT = 2;
    
    private static final int COMMAND_CREATE_LIMIT = 2;
    private static final int COMMAND_CREATE_APPEND = 3;
    private static final int COMMAND_CREATE_REPLACE = 4;
    private static final int COMMAND_CREATE_DELETE = 3;
    private static final int COMMAND_CREATE_RESTORE = 3;

    @Override
    public Command readCommand (String input) {
        input = input.trim ();
        if (isThisCommand (input)) {
            return new CommandComment(input);
        }
        
        String[] commandTokens = input.split(COMMAND_TOKEN_DELIMITER, COMMAND_TOKEN_LIMIT);

        String commandType = commandTokens[INDEX_COMMAND_TYPE];
        String commandDetail = commandTokens.length == 2 ? commandTokens[INDEX_COMMAND_DETAIL] : "";
        
        switch (commandType) {
            case "USER":
                return createCommandUser (commandDetail);
            case "CREATE":
            	return createCommandCreate (commandDetail);
            case "APPEND":
                return createCommandAppend (commandDetail);
            case "REPLACE":
                return createCommandReplace (commandDetail);
            case "DELETE":
                return createCommandDelete (commandDetail);
            case "PRINT":
                return createCommandPrint (commandDetail);
            case "RESTORE":
                return createCommandRestore (commandDetail);
            case "HISTORY":
                return createCommandHistory (commandDetail);
            case "USERREPORT":
                return createCommandUserReport (commandDetail);
            case "FILE":
            	return createCommandFile (commandDetail);
            case "QUIT":
                return createCommandQuit ();
            default:
                return new CommandComment("INVALID COMMAND");
        }
    }

    private boolean isThisCommand (String input) {
        return input.charAt(0) == '#';
    }

    private Command createCommandUser (String commandDetail) {
        String userId = commandDetail;
        return new CommandUser (userId);
    }

    private Command createCommandCreate (String commandDetail) {
        String[] details = commandDetail.split(COMMAND_TOKEN_DELIMITER, COMMAND_CREATE_LIMIT);
        
        String documentTitle = details[0];
        String userId = details[1];

        return new CommandCreate (documentTitle, userId);
    }

    private Command createCommandAppend (String commandDetail) {
        String[] details = commandDetail.split(COMMAND_TOKEN_DELIMITER, COMMAND_CREATE_APPEND);

        String documentTitle = details[0];
        String userId = details[1];
        String newLine = details[2];

        return new CommandAppend (userId, documentTitle, newLine);
    }

    private Command createCommandReplace (String commandDetail) {
        String[] details = commandDetail.split (COMMAND_TOKEN_DELIMITER, COMMAND_CREATE_REPLACE);

        try {
            String documentTitle = details[0];
            String userId = details[1];
            int line = Integer.parseInt (details[2]);
            String newContent = details[3];

            return new CommandReplace (userId, documentTitle, line, newContent);
        } catch (NumberFormatException e) {
            return new CommandComment ("INVALID FORMAT FOR COMMAND REPLACE");
        }

    }
    private Command createCommandDelete (String commandDetail) {
        String[] details = commandDetail.split (COMMAND_TOKEN_DELIMITER, COMMAND_CREATE_DELETE);

        try {
            String documentTitle = details[0];
            String userId = details[1];
            int line = Integer.parseInt (details[2]);

            return new CommandDelete (userId, documentTitle, line);
        } catch (NumberFormatException e) {
            return new CommandComment ("INVALID FORMAT FOR DELETE REPLACE");
        }

    }
    private Command createCommandPrint (String commandDetail) {
        String documentTitle = commandDetail;

        return new CommandPrint (documentTitle);
    }
    private Command createCommandRestore (String commandDetail) {
        String[] details = commandDetail.split (COMMAND_TOKEN_DELIMITER, COMMAND_CREATE_RESTORE);

        try {
            String userId = details[0];
            String documentTitle = details[1];
            int atTime = Integer.parseInt (details[2]);

            return new CommandRestore (userId, documentTitle, atTime);
        } catch (NumberFormatException e) {
            return new CommandComment ("INVALID COMMAND SYNTAX");
        }
    }
    private Command createCommandHistory (String commandDetail) {
        String documentTitle = commandDetail;

        return new CommandHistory (documentTitle);
    }
    private Command createCommandUserReport (String commandDetail) {
        String userId = commandDetail;

        return new CommandUserReport (userId);
    }
    private Command createCommandQuit () {
        return new CommandQuit ();
    }

    private Command createCommandFile (String commandDetail) {
    	String fileName = commandDetail;
        return new CommandFile (this, fileName);
    }

    
    @Override
    public void readFile (String fileName, WikiSystem wikiSystem) {
    	Scanner scanner = null;
    	try {
    		File file = new File("./"+fileName);
    		scanner = new Scanner (file);
    		
    		while (scanner.hasNextLine()) {
    			String line = scanner.nextLine();
    			Command command = readCommand(line);
    			wikiSystem.loadCommand(command);
    		}
    	} catch (FileNotFoundException e) {
    		
    		Command command = new CommandComment ("FILE IS NOT FOUND");
    		wikiSystem.loadCommand(command);
    	} finally {
    		if (scanner != null) {
    			scanner.close();
    		}
    	}
    }
}
 
