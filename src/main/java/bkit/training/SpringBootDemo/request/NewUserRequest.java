package bkit.training.SpringBootDemo.request;

import java.sql.Date;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewUserRequest {
  @Size(min = 6, max = 64)
  private String username;
  @Size(max = 64)
  private String firstname;
  @Size( max = 64)
  private String lastname;
  private Date dob;
}
