/**
 * 
 */
package pro.budthapa.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author budthapa
 * Mar 8, 2017
 * 
 */
@Entity
public class Category implements Serializable{
	
	private static final long serialVersionUID = -2570159053239510400L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name", unique=true)
	@NotBlank(message="{category.name.invalid}")
	private String name;

	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private List<Blog> blog;

	public Category(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Blog> getBlog() {
		return blog;
	}

	public void setBlog(List<Blog> blog) {
		this.blog = blog;
	}
	
	
}
