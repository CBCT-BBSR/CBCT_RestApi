package com.java.crud.repositories;

import com.java.crud.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
 
/**
 * Created by sadiq.odho on 2/1/2019.
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>, JpaSpecificationExecutor<Privilege> {
    public Privilege findByName(String name);
}
