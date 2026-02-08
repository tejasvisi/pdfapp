package com.example.pdfapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pdfapp.models.UserPDF;

public interface UserPDFRepository extends MongoRepository<UserPDF,String>{
	@Query("{ 'userID': ?0 }")
	List<UserPDF> findByUserID(@Param("userID") String userID);

}
