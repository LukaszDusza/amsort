package amsort.example.amsort.service;

import amsort.example.amsort.mapper.EmployeMapper;
import amsort.example.amsort.model.Employe;
import amsort.example.amsort.model.dtos.EmployeDto;
import amsort.example.amsort.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    private EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getEmployeList() {
        return employeRepository.findAll();
    }

    public Optional<Employe> getEmployeByName(String name) {
        return employeRepository.findByName(name);
    }

    public double add(double loan){
        return employeRepository.findAccount().get().getAccount()+loan;
    }

    public double substraction(double loan){
        return employeRepository.findAccount().get().getAccount()-loan;
    }

    public void updateAccount(EmployeDto employeDto){
        employeRepository.findByName(employeDto.getName())
                .ifPresent(p -> {
                    p.setAccount(employeDto.getAccount());

                    employeRepository.save(p);
                });
    }

}
