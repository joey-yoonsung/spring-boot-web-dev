package com.example.ch05.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel
public class User {
    int userNo;
    String userId;
    String email;
    String uname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date regDate;


}
