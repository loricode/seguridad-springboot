package com.loricode.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.loricode.model.User;

import jakarta.transaction.Transactional;


@EnableJpaRepositories
@Repository
public interface IUserRepository extends JpaRepository<User, String> {

  @Query(value="{ call sp_get_users() }", nativeQuery = true)
  public List<User> getListUsers();

  @Modifying
  @Query(value="{ call sp_create_user(:fullName, :email) }", nativeQuery = true)
  @Transactional
  public void addUser(String fullName, String email);
 

  @Modifying
  @Query(value="{ call sp_update_user(:id, :fullName, :email) }", nativeQuery = true)
  @Transactional
  public void  updateUser(String id, String fullName, String email);
 
}
