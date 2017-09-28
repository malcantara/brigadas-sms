package mx.brigadas.sms.brigadassms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "help_request")
@SequenceGenerator(name = "help_request_id_seq_gen", sequenceName = "help_request_id_seq", allocationSize = 1)
public class HelpRequest implements Serializable {
	private static final long serialVersionUID = -12038774538148365L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "help_request_id_seq_gen")
	private Long id;

	@Column(name = "contact_phone_number")
	private String contactPhoneNumber;

	private String town;

	private String municipality;

	private String state;

	private String status;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
}
