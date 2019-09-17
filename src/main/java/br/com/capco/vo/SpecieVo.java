package br.com.capco.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecieVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private Double media;
	private List<String> people;

	public SpecieVo() {
		super();
	}

	public SpecieVo(String name, Double media, List<String> people) {
		super();
		this.name = name;
		this.media = media;
		this.people = people;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the media
	 */
	public Double getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(Double media) {
		this.media = media;
	}

	/**
	 * @return the people
	 */
	public List<String> getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(List<String> people) {
		this.people = people;
	}
}
