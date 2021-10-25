package cl.bci.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import cl.bci.dto.UsuarioResponseDTO;
import cl.bci.service.entidad.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	List<UserEntity> usuarioResponseDTOtoEntity(List<UsuarioResponseDTO> userDTO);
	List<UsuarioResponseDTO> listUserEntitytoDTO(List<UserEntity> userEntity);
	UsuarioResponseDTO userEntityToDTO(UserEntity userEntity);
}