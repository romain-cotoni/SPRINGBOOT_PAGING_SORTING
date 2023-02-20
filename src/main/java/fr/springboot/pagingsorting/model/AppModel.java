package fr.springboot.pagingsorting.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "level")
	private Integer level;
	
	@Column(name = "lastModified")
	private Date lastModified;
 
	public AppModel() {
	}
	
	public AppModel(String label, Integer level) {
		super();
		this.label = label;
		this.level = level;
	}

	public AppModel(String label, Integer level, Date lastModified) {
		this.label = label;
		this.level = level;
		this.lastModified = lastModified;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "AppModel [id=" + id + ", label=" + label + ", level=" + level + ", lastModified=" + lastModified + "]";
	}

	
	
	
}
