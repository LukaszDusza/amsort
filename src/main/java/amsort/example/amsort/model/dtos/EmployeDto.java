package amsort.example.amsort.model.dtos;

import lombok.*;

import java.math.BigDecimal;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDto {

    private String name;
    private BigDecimal account;
//    private double loan;
}
