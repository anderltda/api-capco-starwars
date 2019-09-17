package br.com.capco.vo.parse;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonObjectParse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String eye_color;
	private String birth_year;
	private String gender;
	private String homeworld;
	private String url;
	private List<String> films;
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
	 * @return the mass
	 */
	public String getMass() {
		return mass;
	}
	/**
	 * @param mass the mass to set
	 */
	public void setMass(String mass) {
		this.mass = mass;
	}
	/**
	 * @return the hair_color
	 */
	public String getHair_color() {
		return hair_color;
	}
	/**
	 * @param hair_color the hair_color to set
	 */
	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}
	/**
	 * @return the skin_color
	 */
	public String getSkin_color() {
		return skin_color;
	}
	/**
	 * @param skin_color the skin_color to set
	 */
	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}
	/**
	 * @return the eye_color
	 */
	public String getEye_color() {
		return eye_color;
	}
	/**
	 * @param eye_color the eye_color to set
	 */
	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the homeworld
	 */
	public String getHomeworld() {
		return homeworld;
	}
	/**
	 * @param homeworld the homeworld to set
	 */
	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
