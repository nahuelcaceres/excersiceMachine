package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.EqualsBuilder;

@MappedSuperclass
public class NameBaseEntity extends BaseEntity {

	public NameBaseEntity() {
		super();
	}
	
	public NameBaseEntity(Long id, String name) {
		super(id);
		this.name = name;
	}

	@Column(name="NAME", unique=true, nullable = false, length = 20, columnDefinition = "VARCHAR(20)")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String result = super.toString() + 
				        "\nName: " + this.getName();
		return result;
	}	
	
	@Override
	public boolean equals(Object obj) {
	
		NameBaseEntity rhs = (NameBaseEntity) obj;
        
        return new EqualsBuilder().
        	appendSuper(super.equals(obj)).        		
            append(name, rhs.getName()).
            isEquals();
	}
		

}
