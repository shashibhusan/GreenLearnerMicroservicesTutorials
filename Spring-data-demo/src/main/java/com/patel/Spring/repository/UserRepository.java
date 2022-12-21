package com.patel.Spring.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patel.Spring.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	//Index query and User is entity here not the table name
	@Query("select u from User u where u.lastName=?1")
	List<User> getAllUserByLastName(String firstName);
	
	// Name Query
	@Query(value = "select u from User u where u.gender=:gender", nativeQuery = false)
    List<User> getUsersByGender(@Param("gender")String gender1);
	
	/*
	 * // Name Query ..Making nativeQuery true means...you can refer table name directly instead of Entity name.
	 * 
	 * @Query(value = "select u from user u where u.gender=:gender", nativeQuery =
	 * true) List<User> getUsersByGender(@Param("gender")String gender1);
	 */
	
	@Lock(LockModeType.NONE)
    @Transactional
    @Modifying
    @Query("update User u set u.address=?2 where u.id=?1")
    void updateAddress(Long id, String newAddress);
    
	@Lock(LockModeType.READ)
    // Name Query
 	@Query(value = "select u from User u where u.gender=:gender")
     List<User> getUsersByGenderAndSort(@Param("gender")String gender1,Sort sort);
    
}
	
	
