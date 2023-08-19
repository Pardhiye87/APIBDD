package com.Api.GitHub.Model;

import java.util.Objects;

public class RepositoryPojo {
	
	private String name;
	
	private String description;
	
	private String homepage;
	
	private boolean is_template;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public boolean isIs_template() {
		return is_template;
	}

	public void setIs_template(boolean is_template) {
		this.is_template = is_template;
	}

	@Override
	public String toString() {
		return "RepositoryPojo [name=" + name + ", description=" + description + ", homepage=" + homepage
				+ ", is_template=" + is_template + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, homepage, is_template, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepositoryPojo other = (RepositoryPojo) obj;
		return Objects.equals(description, other.description) && Objects.equals(homepage, other.homepage)
				&& is_template == other.is_template && Objects.equals(name, other.name);
	}

	public RepositoryPojo(String name, String description, String homepage, boolean is_template) {
		super();
		this.name = name;
		this.description = description;
		this.homepage = homepage;
		this.is_template = is_template;
	}

	public RepositoryPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
