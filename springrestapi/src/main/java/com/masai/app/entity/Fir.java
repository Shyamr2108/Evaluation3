package com.masai.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fir")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Fir {

    @Id
    @GeneratedValue

    private int Fid;

    @Size(min=10,max = 10)
    private String  mobileNumber;
    @Pattern(regexp = "^[a-zA-Z]{6,12}$",
            message = "name shoud be only alphabet")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z]{6,12}$",
            message = "name shoud be only alphabet")
    private String lastName;

    private String address;
    @Min(value=8,message="Invalid age")
    private int age;
    private String gender;
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$", message ="worng password pattern" )
    private  String password ;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


}
