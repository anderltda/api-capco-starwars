package br.com.capco.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.capco.vo.parse.JsonObjectParse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String count;
	private String next;
	private String previous;
	private List<JsonObjectParse> results;
	private List<CharacterVo> characteres;
	
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * @return the next
	 */
	public String getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(String next) {
		this.next = next;
	}
	/**
	 * @return the previous
	 */
	public String getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	/**
	 * @return the results
	 */
	public List<JsonObjectParse> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<JsonObjectParse> results) {
		this.results = results;
	}
	/**
	 * @return the characteres
	 */
	public List<CharacterVo> getCharacteres() {
		return characteres;
	}
	/**
	 * @param characteres the characteres to set
	 */
	public void setCharacteres(List<CharacterVo> characteres) {
		this.characteres = characteres;
	}
	
	
}
