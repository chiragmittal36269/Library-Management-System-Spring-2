package com.Backend_First.Library_Management_System.ResponseDTO;

import com.Backend_First.Library_Management_System.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {

    private String transactionId;
    private String bookName;
    private TransactionStatus transactionStatus;
    // here @Enumerated is not needed because we are not storing it and java understand enums.

}
