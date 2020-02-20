package com.contactsunny.poc.PojoEntityExtensionPOC.models;

import com.contactsunny.poc.PojoEntityExtensionPOC.domain.User;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserEntity extends User {
}
