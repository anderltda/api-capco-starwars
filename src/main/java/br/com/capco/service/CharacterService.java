package br.com.capco.service;

import br.com.capco.response.Response;
import br.com.capco.vo.CharacterVo;
import br.com.capco.vo.SpecieVo;
import br.com.capco.vo.SwapiVo;

public interface CharacterService {
	
	/**
	 * 
	 * Obter todos os personagens e ordená-los por quantidade de filmes que aparecem, usando 
	 * nome do personagem como segundo critério de ordenação (ordem alfabética). 
	 * 
	 * @param page
	 * @return Response<SwapiVo>
	 */
	Response<SwapiVo> listarTodosPersonagens(Integer page);
	
	/**
	 * Obter um personagem por ID e trazer nome do personagem, ano de nascimento e nome dos filmes que está.
	 * 
	 * @param id
	 * @return SwapiVo
	 */
	Response<CharacterVo> buscarPorId(Integer id);
	
	/**
	 * 
	 * Obter a lista de todos os personagens humanos e calcular a média de peso dentre eles. 
	 * 	
	 * @return Response<SwapiVo>
	 */
	Response<SpecieVo> listarTodosHumanos();
}
