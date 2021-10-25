package cl.bci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bci.service.entidad.PhoneEntity;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer>{

}
