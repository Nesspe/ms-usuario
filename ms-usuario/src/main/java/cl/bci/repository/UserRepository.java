package cl.bci.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bci.service.entidad.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public Optional<UserEntity> findById(String idUsuario);
	public Optional<UserEntity> findByNameAndPassword(String name, String password);
	public Optional<UserEntity> findByName(String name);
	public Optional<UserEntity> findByEmail(String email);
}
