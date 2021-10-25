package cl.bci.service.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Table(name="Phone")
@Entity
@ToString
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idphone;
	private int number;
	private String city_code;
	private String country_code;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private UserEntity user;

	
}
