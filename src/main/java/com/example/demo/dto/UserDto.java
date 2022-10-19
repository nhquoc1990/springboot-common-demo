package com.example.demo.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Long id;

    private String name;

    private Date birthDay;

    private String address;
}
