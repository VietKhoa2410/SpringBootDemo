package bkit.training.SpringBootDemo.service;

import bkit.training.SpringBootDemo.exception.InvalidConstrainException;
import bkit.training.SpringBootDemo.model.UserEntity;
import bkit.training.SpringBootDemo.repository.UserRepository;
import bkit.training.SpringBootDemo.request.NewUserRequest;
import bkit.training.SpringBootDemo.response.ListUserResponse;
import bkit.training.SpringBootDemo.validate.ConstraintValidator;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final ConstraintValidator validator;

  public UserService(UserRepository userRepository, ConstraintValidator validator){
    this.userRepository=userRepository;
    this.validator=validator;
  }

  public ListUserResponse findAll(){
    Iterable<UserEntity> userEntities = userRepository.findAll();
    List<UserEntity> userEntityList = StreamSupport.stream(userEntities.spliterator(),false).collect(
        Collectors.toList());
    ListUserResponse listUserResponse = new ListUserResponse(userEntityList);
    return listUserResponse;
  }

  public UserEntity create(NewUserRequest request) throws InvalidConstrainException {

    validator.validate(request);

    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(request.getUsername());
    userEntity.setFirstname(request.getFirstname());
    userEntity.setLastname(request.getLastname());
    userEntity.setDob(request.getDob());
    userEntity.setCreateAt(new Date(System.currentTimeMillis()));

    return userRepository.save(userEntity);
  }

  public ListUserResponse findByLastname(String key){
    Pageable sortedByLastname = PageRequest.of(0,3, Sort.by("lastname"));
    List<UserEntity> userEntities = userRepository.findAllByLastnameStartingWith(key,sortedByLastname);
    ListUserResponse listUserResponse = new ListUserResponse(userEntities);
    return listUserResponse;
  }

  public ListUserResponse findByFirstnameAndLastname(String key){
    List<UserEntity> userEntities = userRepository.findAllByFirstnameStartingWithAndLastnameStartingWith(key,key);
    ListUserResponse listUserResponse = new ListUserResponse(userEntities);
    return listUserResponse;
  }
}
