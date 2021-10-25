package cl.bci.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import cl.bci.dto.PhoneDTO;
import cl.bci.service.entidad.PhoneEntity;
import cl.bci.service.entidad.UserEntity;

@Mapper
public interface PhoneMapper {
	List<PhoneEntity> PhoneDTOtoEntity(List<PhoneDTO> phone, UserEntity user);
	List<PhoneDTO> PhoneEntitytoDTO(List<PhoneEntity> phone);
}
