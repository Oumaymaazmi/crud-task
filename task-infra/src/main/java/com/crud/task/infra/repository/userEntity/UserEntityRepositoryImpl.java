package com.crud.task.infra.repository.userEntity;

import com.crud.task.domain.pojo.AppUser;
import com.crud.task.domain.port.IUserRepository;
import com.crud.task.infra.mapper.IUserEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserEntityRepositoryImpl implements IUserRepository {
    private final IUserEntityRepository userEntityRepository;
    private final IUserEntityMapper mapper;

    @Override
    public AppUser findByUserName(String email) {
        return mapper.entityToPojo(userEntityRepository.findByUsername(email));
    }

    @Override
    public void save(AppUser user) {
        userEntityRepository.save(mapper.pojoToEntity(user));
    }
}
