package com.Backend_First.Library_Management_System.Controller;

import com.Backend_First.Library_Management_System.RequestDTO.IssueBookRequestDto;
import com.Backend_First.Library_Management_System.ResponseDTO.IssueBookResponseDto;
import com.Backend_First.Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

//    @PostMapping("/issue")
//    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
//        try {
//            return transactionService.issueBook(issueBookRequestDto);
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }

    @PostMapping("/issue")
    public ResponseEntity issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        IssueBookResponseDto issueBookResponseDto;
        try {
            issueBookResponseDto = transactionService.issueBook(issueBookRequestDto);
            return new ResponseEntity(issueBookResponseDto, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("/get")
    public String getAllTransactions(@RequestBody int cardId)
    {
        return transactionService.getAllTransactions(cardId);
    }
}
