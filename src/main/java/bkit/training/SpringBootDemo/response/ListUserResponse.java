package bkit.training.SpringBootDemo.response;

import bkit.training.SpringBootDemo.model.UserEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListUserResponse {
  List<UserEntity> userEntities;
}
