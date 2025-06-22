package com.crud.task.infra.repository.userEntity;

import com.crud.task.infra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
