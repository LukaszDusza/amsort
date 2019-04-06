package amsort.example.amsort.service;

import amsort.example.amsort.model.Employe;
import amsort.example.amsort.model.Payload;
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

//    public Optional<Employe> getEmployeByName(String name) {
//        return employeRepository.findByName(name);
//    }

//    public double add(double loan) {
//        return employeRepository.findAccount().get().getAccount() + loan;
//    }
//
//    public double substraction(double loan) {
//        return employeRepository.findAccount().get().getAccount() - loan;
//    }

//    public void updateAccount(EmployeDto employeDto) {
//        employeRepository.findByName(employeDto.getName())
//                .ifPresent(p -> {
//                    p.setAccount(employeDto.getAccount());
//
//                    employeRepository.save(p);
//                });
//    }


    public void exchange(Payload payload) {

        Employe emplFrom = employeRepository.findByName(payload.getFrom()).get();
        Employe emplTo = employeRepository.findByName(payload.getTo()).get();

        emplFrom.setAccount(emplFrom.getAccount().subtract(payload.getValue()));
        emplTo.setAccount(emplTo.getAccount().add(payload.getValue()));

        employeRepository.save(emplFrom);
        employeRepository.save(emplTo);

    }


}
