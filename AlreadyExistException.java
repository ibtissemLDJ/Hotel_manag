public class AlreadyExist extends Exception {

    public AlreadyExist() {
    super("This ID already exists in the system.");
    }


    public AlreadyExist(String message) {
    super(message);
    }

    public String getErrorMessage() {
    return this.getMessage();
    }
}



