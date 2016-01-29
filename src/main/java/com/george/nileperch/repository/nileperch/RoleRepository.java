package com.george.nileperch.repository.nileperch;

import com.george.nileperch.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wladek on 11/24/15.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {
}
