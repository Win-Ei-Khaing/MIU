/**
 * 
 */
package com.students.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "{null.validation}")
	@Digits(integer = 3, fraction = 0, message = "{digits.length.validation}")
 	private Integer area;

	@NotNull(message = "{null.validation}")
	@Digits(integer = 3, fraction = 0, message = "{digits.length.validation}")
 	private Integer prefix;

	@NotNull(message = "{null.validation}")
	@Digits(integer = 4, fraction = 0, message = "{digits.length.validation}")
 	private Integer number;

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
