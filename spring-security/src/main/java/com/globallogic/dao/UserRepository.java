package com.globallogic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.globallogic.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
 
	@Query(value="select * from user_details where user_name = ?1", nativeQuery=true)
	public List<User> findUserByUserName(String userName);
}
