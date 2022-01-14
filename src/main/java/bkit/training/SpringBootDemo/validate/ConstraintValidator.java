package bkit.training.SpringBootDemo.validate;

import bkit.training.SpringBootDemo.exception.InvalidConstrainException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConstraintValidator {
  private final Validator validator;

  public ConstraintValidator(Validator validator){
    this.validator=validator;
  }

  public <T> void validate(T payload) throws InvalidConstrainException {
    Set<ConstraintViolation<T>> violations = validator.validate(payload);
    if (!violations.isEmpty()) {
      final var violation = violations.iterator().next();
      final var errorPath = violation.getPropertyPath().toString();

      log.error("Invalid constraint: "+errorPath);
      throw new InvalidConstrainException(400,errorPath);
    }
  }
}
