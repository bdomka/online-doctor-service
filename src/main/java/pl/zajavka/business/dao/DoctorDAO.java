package pl.zajavka.business.dao;

import pl.zajavka.domain.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorDAO {

    Optional<Doctor> findDoctor(String licenseNumber);

}
