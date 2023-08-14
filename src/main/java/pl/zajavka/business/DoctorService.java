package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.business.dao.DoctorDAO;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorDAO doctorDAO;



}
