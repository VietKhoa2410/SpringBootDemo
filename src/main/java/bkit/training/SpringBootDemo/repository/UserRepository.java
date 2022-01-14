package bkit.training.SpringBootDemo.repository;

import bkit.training.SpringBootDemo.model.UserEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
  List<UserEntity> findAllByLastnameStartingWith(String key, Pageable pageable);

  List<UserEntity> findAllByFirstnameStartingWithAndLastnameStartingWith( String key1,String key2);
}
