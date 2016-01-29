package com.george.nileperch.repository;

import com.george.nileperch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wladek
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    User findByLoginId(String loginId);

    User findByEmail(String email);
}
