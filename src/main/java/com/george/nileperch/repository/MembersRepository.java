package com.george.nileperch.repository;

import com.george.nileperch.domain.nileperch.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by george on 1/18/16.
 */
@Repository
public interface MembersRepository extends JpaRepository<Members, Long>{

    Members findByIdNumber(Long id);
    Members findByEmail(String email);
}
