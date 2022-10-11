package exceptions;

public class RelationNotFoundException extends RuntimeException{
  public RelationNotFoundException(String message) {
    super(message);
  }
}
