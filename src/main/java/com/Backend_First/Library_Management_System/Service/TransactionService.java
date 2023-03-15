package com.Backend_First.Library_Management_System.Service;

import com.Backend_First.Library_Management_System.Entity.Book;
import com.Backend_First.Library_Management_System.Entity.LibraryCard;
import com.Backend_First.Library_Management_System.Entity.Transaction;
import com.Backend_First.Library_Management_System.Enum.CardStatus;
import com.Backend_First.Library_Management_System.Enum.TransactionStatus;
import com.Backend_First.Library_Management_System.Repository.BookRepository;
import com.Backend_First.Library_Management_System.Repository.LibraryCardRepository;
import com.Backend_First.Library_Management_System.Repository.TransactionRepository;
import com.Backend_First.Library_Management_System.RequestDTO.IssueBookRequestDto;
import com.Backend_First.Library_Management_System.ResponseDTO.IssueBookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    LibraryCardRepository libraryCardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;


    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        // get the info of book and card because requestDto is having both

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);


        LibraryCard card;
        try {
            card = libraryCardRepository.findById(issueBookRequestDto.getCardId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Card Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Card Id");
        }

        Book book;
        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }

        // set the card and book in the transaction
        transaction.setBook(book);
        transaction.setCard(card);

        if(card.getCardStatus() != CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Card is Expired or Blocked");
            transactionRepository.save(transaction);
            throw new Exception("Card is Expired or Blocked");
        }

        if(book.isIssued())
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Book is already issued");
            transactionRepository.save(transaction);
            throw new Exception("Book is already issued");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was Successful");

        // set book parameters
        book.setIssued(true);
        book.getTransaction().add(transaction);
        book.setCard(card);

        // set card parameters
        card.getBookList().add(book);
        card.getTransactionList().add(transaction);


        libraryCardRepository.save(card);

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
        issueBookResponseDto.setTransactionId(transaction.getTransactionNumber());


        // these are the steps to send the email.
        String text = "Congrats !!. "+ card.getStudent().getName() + " You have been issued " + book.getTitle() + " book." ;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("chiragmittal36279@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issue Book Notification");
        message.setText(text);
        emailSender.send(message);


        return issueBookResponseDto;
    }


    public String getAllTransactions(int cardId)
    {
        List<Transaction> transactionList = transactionRepository.getAllSuccessfulTransactionsWithCardNo(cardId);
        String ans = "";
        for(Transaction t : transactionList)
        {
            ans += t.getTransactionNumber();
            ans += "\n";
        }
        return ans;
    }
}
