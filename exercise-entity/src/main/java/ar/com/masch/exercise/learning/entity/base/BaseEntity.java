package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.EqualsBuilder;

@MappedSuperclass
public class BaseEntity {
//
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	public BaseEntity() {
		super();
	}
	
	public BaseEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		String result = "Hash: " + this.hashCode() + 
				        "\nId: " + this.getId();
		return result;
	}	

	@Override
	public boolean equals(Object obj) {

		BaseEntity rhs = (BaseEntity) obj;

		return new EqualsBuilder().
			append(id, rhs.getId()).
			isEquals();
	}

}
