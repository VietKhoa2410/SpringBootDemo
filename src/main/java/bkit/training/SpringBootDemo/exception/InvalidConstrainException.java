package bkit.training.SpringBootDemo.exception;

import lombok.Getter;

@Getter
public class InvalidConstrainException extends Exception{
  private final int errorCode;
  private final String errorMessage;

  public InvalidConstrainException(int errorCode, String errorMessage){
    this.errorCode=errorCode;
    this.errorMessage=errorMessage;
  }
}
