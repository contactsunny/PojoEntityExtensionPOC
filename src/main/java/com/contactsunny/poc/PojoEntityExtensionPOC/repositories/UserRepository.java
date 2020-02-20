package com.contactsunny.poc.PojoEntityExtensionPOC.repositories;

import com.contactsunny.poc.PojoEntityExtensionPOC.models.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
