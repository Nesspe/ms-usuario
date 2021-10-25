package cl.bci.service;

import cl.bci.dto.LoginRequestDTO;
import cl.bci.dto.LoginResponseDTO;
import cl.bci.dto.UsuarioRequestDTO;
import cl.bci.dto.UsuarioResponseDTO;

public interface MsUsuarioService {

	UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO request);
	UsuarioResponseDTO obtenerUsuario(UsuarioRequestDTO request);
	LoginResponseDTO login(LoginRequestDTO login);
}
