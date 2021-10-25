package cl.bci.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cl.bci.dto.PhoneDTO;
import cl.bci.service.entidad.PhoneEntity;
import cl.bci.service.entidad.UserEntity;

@Component
public class PhoneMapperImpl implements PhoneMapper {

	@Override
	public List<PhoneEntity> PhoneDTOtoEntity(List<PhoneDTO> phone, UserEntity user) {
		if (null == phone || phone.isEmpty()) {
			return new ArrayList<PhoneEntity>();
		}
		List<PhoneEntity> entityList = new ArrayList<>();
		phone.stream().forEach(p-> {
			PhoneEntity entity = new PhoneEntity();
			entity.setCity_code(p.getCitycode());
			entity.setCountry_code(p.getCountrycode());
			entity.setNumber(p.getNumber());
			entity.setUser(user);
			entityList.add(entity);
		});
		return entityList;
	}

	@Override
	public List<PhoneDTO> PhoneEntitytoDTO(List<PhoneEntity> phone) {
		if (null == phone || phone.isEmpty()) {
			return new ArrayList<PhoneDTO>();
		}
		List<PhoneDTO> dtoList = new ArrayList<>();
		phone.stream().forEach(p-> {
			dtoList.add(PhoneDTO.builder()
			.citycode(p.getCity_code())
			.number(p.getNumber())
			.countrycode(p.getCountry_code())
			.build());
		});
		return dtoList;
	}

}
