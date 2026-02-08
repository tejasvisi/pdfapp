package com.example.pdfapp;



import com.example.pdfapp.dao.Neet;
import com.example.pdfapp.service.PdfService;
import com.example.pdfapp.service.UserPDFService;
import com.example.pdfapp.models.UserPDF;
import com.example.pdfapp.repository.UserPDFRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.pdfapp.dao.*;
import java.util.List;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    private final PdfService pdfService;
    private final UserPDFService userPdfService;
    private final UserPDFRepository userPDFRepository;
    public PdfController(PdfService pdfService,UserPDFService userPdfService, UserPDFRepository userPDFRepository) {
        this.pdfService = pdfService;
        this.userPdfService = userPdfService;
        this.userPDFRepository=userPDFRepository;
    }

    /**
     * Generate PDF for NEET data
     */
@GetMapping("/pdfdownload")
	
	ResponseEntity downloadPDF(@RequestParam String userID) {
	System.out.println("pdfcontroller, downloadPDF");
		List<UserPDF> pdfs=userPDFRepository.findByUserID(userID);
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_PDF);
        
		//byte[] arrresp=pdf.getFile();
        return ResponseEntity.ok()
                //.headers(headers)
                .body(pdfs);
	}

    @PostMapping("/neet")
    public byte[] generateNeetPdf(@RequestBody NeetRequest neetRequest) {
    	List<Neet> nirf=neetRequest.getNirf();
        byte[] pdfBytes = pdfService.createNeetPDF(nirf);
        String userID=neetRequest.getUserId();
        String filename=neetRequest.getFileName();
       /* HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename("NEET_Report.pdf")
                        .build()
        );*/
        userPdfService.saveUserPDF(userID, filename, pdfBytes);
        return pdfBytes;
    }

    /**
     * Generate PDF for AKTU data (nirf, placement, recommended)
     */
    @PostMapping("/aktu")
    public byte[] generateAktuPdf(
            @RequestBody AktuRequest request) {
    	String userID=request.getUserId();
    	String filename=request.getFileName();
    	System.out.println("hi i am filename:"+filename);
        byte[] pdfBytes = pdfService.createAktuPDF(
                request.getNirf(),
                request.getPlacement(),
                request.getRecommended()
        );

       /* HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename("AKTU_Report.pdf")
                        .build()
        );*/
        userPdfService.saveUserPDF(userID, filename, pdfBytes);
        return pdfBytes;
    }

    /**
     * General endpoint (if you want a simple createPDF method)
     */
    @PostMapping("/general")
    public ResponseEntity<byte[]> createGeneralPdf(@RequestBody List<Neet> result) {
        byte[] pdfBytes = pdfService.createPDF(result);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename("General_Report.pdf")
                        .build()
        );

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

 
    
}
