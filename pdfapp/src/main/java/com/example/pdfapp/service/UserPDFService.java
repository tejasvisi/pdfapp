package com.example.pdfapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdfapp.models.UserPDF;
import com.example.pdfapp.repository.UserPDFRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class UserPDFService {

    @Autowired
    private UserPDFRepository userPDFRepository;
    private final static Logger log = LoggerFactory.getLogger(UserPDFService.class);
    public void saveUserPDF(String userID, String filename, byte[] pdfBytes) {
      //  String fileName = examType + "_" + AIR + ".pdf";
    	System.out.println("inside log of saveUserPDF, filename:"+filename);
        UserPDF userPDF = new UserPDF(userID, filename, pdfBytes);
        userPDFRepository.save(userPDF);
    }
}

