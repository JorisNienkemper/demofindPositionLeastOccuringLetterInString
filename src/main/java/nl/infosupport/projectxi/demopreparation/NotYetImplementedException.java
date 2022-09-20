package nl.infosupport.projectxi.demopreparation;

public class NotYetImplementedException extends RuntimeException {
    public NotYetImplementedException(String message) {
        super(message);
    }

    public NotYetImplementedException() {
        super("Not yet implemented. Probalby you did find a new requirement. Contact the PO");
    }
}
