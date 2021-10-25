package cl.bci.service.entidad;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="User")
@ToString
public class UserEntity {

	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private boolean isactive;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	@PrimaryKeyJoinColumn
	private List<PhoneEntity> phone;

	public UserEntity() {
		this.id = UUID.randomUUID().toString();
	}

}
