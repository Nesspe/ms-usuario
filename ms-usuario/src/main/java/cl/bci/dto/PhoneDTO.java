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
public class PhoneDTO {
	@JsonProperty(value="number", index=1)
	private int number;
	@JsonProperty(value="citycode", index=2)
	private String citycode;
	@JsonProperty(value="countrycode", index=3)
	private String countrycode;
}
