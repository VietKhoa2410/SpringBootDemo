package bkit.training.SpringBootDemo.config;

import bkit.training.SpringBootDemo.model.UserEntity;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditConfig {
  @Bean
  public AuditorAware<UserEntity> auditorProvider() {
    return new AuditorAware<UserEntity>() {
      @Override
      public Optional<UserEntity> getCurrentAuditor() {
        return Optional.empty();
      }
    };
  }
}
