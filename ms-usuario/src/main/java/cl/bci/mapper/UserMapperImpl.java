package cl.bci.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.bci.dto.UsuarioResponseDTO;
import cl.bci.service.entidad.UserEntity;

@Component
public class UserMapperImpl implements UserMapper {

	@Autowired
	private PhoneMapper phoneMapper;
	
	@Override
	public List<UserEntity> usuarioResponseDTOtoEntity(List<UsuarioResponseDTO> userDTO) {
		return null;
	}

	@Override
	public List<UsuarioResponseDTO> listUserEntitytoDTO(List<UserEntity> userEntity) {
		if (null == userEntity || userEntity.isEmpty()) {
			return new ArrayList<>();	
		}
		List<UsuarioResponseDTO> dtoList = new ArrayList<>();
		userEntity.stream().forEach(u-> {
			dtoList.add(UsuarioResponseDTO.builder()
				.id(u.getId())
				.isactive(u.isIsactive())
				.created(u.getCreated())
				.email(u.getEmail())
				.last_login(u.getLast_login())
				.modified(u.getModified())
				.name(u.getName())
				.phone(phoneMapper.PhoneEntitytoDTO(u.getPhone()))
				.build());
		});
		return dtoList;
	}

	@Override
	public UsuarioResponseDTO userEntityToDTO(UserEntity userEntity) {
		return UsuarioResponseDTO.builder()
				.id(userEntity.getId())
				.isactive(userEntity.isIsactive())
				.created(userEntity.getCreated())
				.email(userEntity.getEmail())
				.last_login(userEntity.getLast_login())
				.modified(userEntity.getModified())
				.name(userEntity.getName())
				.token(userEntity.getToken())
				.phone(phoneMapper.PhoneEntitytoDTO(userEntity.getPhone()))
				.build();
	}

}
