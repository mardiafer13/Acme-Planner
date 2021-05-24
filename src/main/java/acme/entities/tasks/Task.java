package acme.entities.tasks;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.Manager;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Task extends DomainEntity{

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotBlank  
	@Length(min=0, max=80)
	protected String         title;
	
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date           periodInitial;
	
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date           periodFinal;
	
	@NotBlank  
	@Length(min=0, max=500)
	protected String         description;
	
	@URL
	protected String        link;

	@NotNull
	protected Boolean       isPublic;
	

	
	@NotNull
	@Min(0)
	protected Double        workloadInHours;
	

	
	// Derived attributes -----------------------------------------------------
	public Double workloadInMinutes() {
		Double result;
		result=this.workloadInHours*60;
		
		return result;
	}

	
	public Long durationPeriodInHours() {
		Long duracion;
		
		final long diferenceInMiliseconds = Math.abs(this.periodFinal.getTime() - this.periodInitial.getTime());
		duracion = TimeUnit.HOURS.convert(diferenceInMiliseconds, TimeUnit.MILLISECONDS);
		return duracion;
	}

	public Long durationPeriodInMinutes() {
		Long duracion;
		
		final long diferenceInMiliseconds = Math.abs(this.periodFinal.getTime() - this.periodInitial.getTime());
		duracion = TimeUnit.MINUTES.convert(diferenceInMiliseconds, TimeUnit.MILLISECONDS);
		return duracion;
	}
	
	// Relationships ----------------------------------------------------------
	@ManyToOne
	Manager manager;
	
}
