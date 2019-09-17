package br.com.capco.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String height;
	private String birth_year;
	private Integer count_films;
	private List<String> films;
	
	public CharacterVo() {
		super();
	}

	public CharacterVo(String id, String name, String height, String birth_year, List<String> films) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.birth_year = birth_year;
		this.films = films;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the birth_year
	 */
	public String getBirth_year() {
		return birth_year;
	}

	/**
	 * @param birth_year the birth_year to set
	 */
	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	/**
	 * @return the count_films
	 */
	public Integer getCount_films() {
		
		if(films != null) {
			count_films = films.size();
		}
		
		return count_films;
	}

	/**
	 * @param count_films the count_films to set
	 */
	public void setCount_films(Integer count_films) {
		this.count_films = count_films;
	}

	/**
	 * @return the films
	 */
	public List<String> getFilms() {
		return films;
	}

	/**
	 * @param films the films to set
	 */
	public void setFilms(List<String> films) {
		this.films = films;
	}
}
