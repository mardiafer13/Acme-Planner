/*
 * UserIdentity.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.datatypes;

import java.beans.Transient;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import acme.framework.datatypes.DomainDatatype;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class UserIdentity extends DomainDatatype {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	protected String			name;

	@NotBlank
	protected String			surname;

	@NotBlank
	@Email
	protected String			email;

	@Valid
	protected Phone				phone;

	// Derived attributes -----------------------------------------------------


	@Transient
	public String getFullName() {
		StringBuilder result;

		result = new StringBuilder();
		result.append(this.surname);
		result.append(", ");
		result.append(this.name);

		return result.toString();
	}

}
