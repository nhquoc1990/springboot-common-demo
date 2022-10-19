package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 255, min = 3)
    private String name;

    @Column(name = "birth_day")
    @NotNull(message = "Invalid Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @Size(max = 255, min = 3, message = "Please input address between 3 and 255")
    private String address;

    @NotNull
    @NotBlank
    private String password;
}
