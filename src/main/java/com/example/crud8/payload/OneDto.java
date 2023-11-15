package com.example.crud8.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OneDto {
    private Long id;

    @NotEmpty
    @Size(min = 5, message = "you have least 5 characters")
    private String name;

    private String number = "10";

    private Long oneId;
}
