package cl.bci.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import cl.bci.dto.LoginRequestDTO;
import cl.bci.dto.LoginResponseDTO;
import cl.bci.dto.UsuarioRequestDTO;
import cl.bci.dto.UsuarioResponseDTO;
import cl.bci.exception.ErrorNegocioException;
import cl.bci.mapper.PhoneMapper;
import cl.bci.mapper.UserMapper;
import cl.bci.repository.UserRepository;
import cl.bci.service.entidad.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class MsUsuarioServiceImpl implements MsUsuarioService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PhoneMapper phoneMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Value("${pattern.password}")
	private String patronPassword;
	
	@Override
	public UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO request) {
		parameterValidation(request);
		Optional<UserEntity> filterByEmail = userRepository.findByEmail(request.getEmail());
		if (filterByEmail.isPresent()) {
			throw new ErrorNegocioException("El correo ya esta registrado");
		}
		UserEntity entity =  new UserEntity();
		entity.setName(request.getName());
		entity.setEmail(request.getEmail());
		entity.setCreated(new Date());
		entity.setPassword(request.getPassword());
		entity.setLast_login(new Date());
		entity.setPhone(phoneMapper.PhoneDTOtoEntity(request.getPhones(), entity));
		userRepository.saveAndFlush(entity);
		return obtenerUsuario(request);
	}

	private void parameterValidation(UsuarioRequestDTO request) {
		if (!request.getEmail().matches("^[\\w]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new ErrorNegocioException("El correo no cumple con el formato.");
		}
		if (!request.getPassword().matches(patronPassword)) {
			throw new ErrorNegocioException("La contraseña no cumple con el formato definido.");
		}
		
	}

	@Override
	public UsuarioResponseDTO obtenerUsuario(UsuarioRequestDTO request) {
		Optional<UserEntity> result = userRepository.findByName(request.getName());
		if (!result.isPresent()) {
			return UsuarioResponseDTO.builder().build();
		}
		return userMapper.userEntityToDTO(result.get());
	}

	@Override
	public LoginResponseDTO login(LoginRequestDTO login) {
		Optional<UserEntity> result = userRepository.findByNameAndPassword(login.getName(), login.getPassword());
		if (result.isPresent()) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
			
			String token = Jwts
					.builder()
					.setId("softtekJWT")
					.setSubject(login.getName())
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 150000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();
			UserEntity user = result.get();
			user.setLast_login(new Date());
			user.setToken(token);
			userRepository.saveAndFlush(user);
			return LoginResponseDTO.builder().userName(login.getName()).token(token).build();
		}
		
		throw new AccessDeniedException("Usuario inválido");
	}
}
