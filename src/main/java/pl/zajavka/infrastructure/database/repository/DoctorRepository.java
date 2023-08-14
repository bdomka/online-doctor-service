package pl.zajavka.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.zajavka.business.dao.DoctorDAO;
import pl.zajavka.domain.Doctor;
import pl.zajavka.infrastructure.database.repository.jpa.DoctorJpaRepository;
import pl.zajavka.infrastructure.database.repository.mapper.DoctorEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DoctorRepository implements DoctorDAO {

   private final DoctorJpaRepository doctorJpaRepository;

   private final DoctorEntityMapper doctorEntityMapper;


   @Override
   public Optional<Doctor> findDoctor(String licenseNumber) {
      return doctorJpaRepository.findByLicenseNumber(licenseNumber)
              .map(doctorEntityMapper::mapFromEntity);
   }
}
