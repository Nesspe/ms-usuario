package cl.bci.dto;

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
public class LoginResponseDTO {
	@JsonProperty(value="userName", index=1)
	private String userName;
	@JsonProperty(value="token", index=2)
	private String token;

}
