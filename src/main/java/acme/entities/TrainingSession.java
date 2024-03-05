
package acme.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrainingSession extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotNull
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "TS-[A-Z]{1,3}-\\d{3}")
	private String				code;

	//El periodo debe crearse con al menos una semana de antelación y tiene que durar como minimo una semana.
	@NotNull
	private Date				startPeriod;

	@NotNull
	private Date				endPeriod;

	@NotBlank
	@NotNull
	@Length(max = 75)
	private String				location;

	@NotBlank
	@NotNull
	@Length(max = 75)
	private String				instructor;

	@NotNull
	@Email
	private String				email;

	@URL
	@Length(max = 255)
	private String				link;

	// Relations  -------------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private TrainingModule		trainingModule;
}
