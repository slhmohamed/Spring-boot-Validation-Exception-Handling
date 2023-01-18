package org.sid.validationexceptionhandling.repository;

import org.sid.validationexceptionhandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {
 User findByUserId(int id);
}
