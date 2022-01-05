package todoapplication;

import java.io.IOException;

public class ApplicationException extends Throwable {

  public ApplicationException(String errorMessage, Exception e) {
    super(errorMessage, e);
  }
}
