package cl.bci.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.dto.LoginRequestDTO;
import cl.bci.dto.LoginResponseDTO;
import cl.bci.dto.UsuarioRequestDTO;
import cl.bci.dto.UsuarioResponseDTO;
import cl.bci.service.MsUsuarioService;
import io.swagger.annotations.ApiOperation;

@RestController
public class MsUsuarioController {

	@Autowired
	private MsUsuarioService usuarioService;
	
	@ApiOperation("Permite la creacion de usuarios con sus telefonos")
	@PostMapping(value="/usuario/crear",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioResponseDTO> registrarUsuario(@RequestBody @Valid UsuarioRequestDTO request) {
		return new ResponseEntity(usuarioService.registrarUsuario(request), HttpStatus.OK);
	}
	
	@ApiOperation("Obtiene la informacion de usuarios con sus telefonos")
	@PostMapping(value="/usuario/consulta",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@RequestBody @Valid UsuarioRequestDTO request) {
		return new ResponseEntity(usuarioService.obtenerUsuario(request), HttpStatus.OK);
	}
	
	@ApiOperation("Permite la autenticacion")
	@PostMapping(value="login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO request) {
		return new ResponseEntity(usuarioService.login(request), HttpStatus.OK);
	}
}
