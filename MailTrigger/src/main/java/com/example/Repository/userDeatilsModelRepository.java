package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.UserDetailsModel;

@Repository
public interface userDeatilsModelRepository extends CrudRepository<UserDetailsModel, Long> {
	
	Optional<UserDetailsModel> findByemail(String email);

}
