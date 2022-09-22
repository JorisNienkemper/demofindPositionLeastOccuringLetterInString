package nl.infosupport.projectxi.demopreparation;

public class NotYetImplementedException extends RuntimeException {
    public NotYetImplementedException(String message) {
        super(message);
    }

    public NotYetImplementedException() {
        super("Not yet implemented. Probably you did find a new requirement. Contact the PO");
    }
}
