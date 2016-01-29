package com.george.nileperch.service;


import com.george.nileperch.domain.nileperch.Members;

import java.util.List;

/**
 * Created by george on 1/18/16.
 */

public interface MembersService {
    public Members addNewMember(Members members);
    public List<Members> findAllMembers();
    public Members editMember(Members members);
    public Members getOneMember(Long id);
    public boolean delete(Long id);
}
