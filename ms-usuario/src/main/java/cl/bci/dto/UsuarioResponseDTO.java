package cl.bci.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioResponseDTO {
	@JsonProperty(value="id", index=3)
	private String id;
	@JsonProperty(value="created", index=3)
	private Date created;
	@JsonProperty(value="modified", index=3)
	private Date modified;
	@JsonProperty(value="last_login", index=3)
	private Date last_login;
	@JsonProperty(value="token", index=3)
	private String token;
	@JsonProperty(value="isactive", index=3)
	private boolean isactive;
	@JsonProperty(value="email", index=3)
	private String email;
	@JsonProperty(value="name", index=3)
	private String name;
	@JsonProperty(value="phone", index=3)
	private List<PhoneDTO> phone;
}
