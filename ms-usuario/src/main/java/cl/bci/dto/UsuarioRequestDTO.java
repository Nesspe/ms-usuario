package cl.bci.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
	@JsonProperty(value="name", index=1)
	private String name;
	@JsonProperty(value="email", index=2)
	private String email;
	@JsonProperty(value="password", index=3)
	private String password;
	@JsonProperty(value="phones", index=4)
	private List<PhoneDTO> phones;
}
