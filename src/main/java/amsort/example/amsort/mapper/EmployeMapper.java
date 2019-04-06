package amsort.example.amsort.mapper;

import amsort.example.amsort.model.Employe;
import amsort.example.amsort.model.dtos.EmployeDto;

public class EmployeMapper implements Mapper <EmployeDto, Employe> {
    @Override
    public Employe map(EmployeDto from) {
        return Employe.builder()
                .name(from.getName())
                .account(from.getAccount())
//                .loan(from.getLoan())
                .build();
    }

    @Override
    public EmployeDto reverseMap(Employe to) {
        return EmployeDto.builder()
                .name(to.getName())
                .account(to.getAccount())
//                .loan(to.getLoan())
                .build();
    }
}
