package br.com.capco.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.capco.response.Response;
import br.com.capco.service.CharacterService;
import br.com.capco.util.ApiStarWarsConstants;
import br.com.capco.vo.CharacterVo;
import br.com.capco.vo.MovieVo;
import br.com.capco.vo.SpecieVo;
import br.com.capco.vo.SwapiVo;

@Service
public class CharacterServiceImpl implements CharacterService {

	private static final Logger log = LoggerFactory.getLogger(CharacterServiceImpl.class);

	@Override
	public Response<SwapiVo> listarTodosPersonagens(Integer page) {
		
		Response<SwapiVo> response = new Response<SwapiVo>();

		try {
			
			log.info("Obter todos os personagens e ordená-los por quantidade de filmes que aparecem, usando "
					+ "nome do personagem como segundo critério de ordenação (ordem alfabética) page:", page);

			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();

			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			headers.add("user-agent", ApiStarWarsConstants.HEADER);

			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

			final ResponseEntity<SwapiVo> swapiDTOs = restTemplate.exchange(ApiStarWarsConstants.URL_LISTAGEM_PERSONAGENS, HttpMethod.GET,
					entity, SwapiVo.class, page);

			response.setData(swapiDTOs.getBody());
			
		} catch (Exception ex) {
			List<String> errors = new ArrayList<String>();
			errors.add(ex.getLocalizedMessage());
			response.setErrors(errors);
		}

		return response;
	}

	@Override
	public Response<CharacterVo> buscarPorId(Integer id) {
		
		Response<CharacterVo> response = new Response<CharacterVo>();

		try {
			
			log.info("Obter um personagem por ID e trazer nome do personagem, ano de nascimento e nome dos filmes que está. ID: {}", id);
			
			List<String> films = new ArrayList<String>();
			
			ResponseEntity<MovieVo> movie = null;

			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();

			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			headers.add("user-agent", ApiStarWarsConstants.HEADER);

			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

			final ResponseEntity<CharacterVo> character = restTemplate.exchange(ApiStarWarsConstants.URL_BUSCAR_PERSONAGEM, HttpMethod.GET,
					entity, CharacterVo.class, String.valueOf(id));

			response.setData(character.getBody());
			
			for (String film : response.getData().getFilms()) {
				
				movie = restTemplate.exchange(film, HttpMethod.GET,
						entity, MovieVo.class);
				
				films.add(movie.getBody().getTitle());
			}
			
			response.getData().setFilms(films);
			
		} catch (Exception ex) {
			List<String> errors = new ArrayList<String>();
			errors.add(ex.getLocalizedMessage());
			response.setErrors(errors);
		}

		return response;
	}

	@Override
	public Response<SpecieVo> listarTodosHumanos() {
		
		Response<SpecieVo> response = new Response<SpecieVo>();

		try {
			
			log.info("Obter a lista de todos os personagens humanos e calcular a média de peso dentre eles.");
			
			List<String> peoples = new ArrayList<String>();
			
			ResponseEntity<CharacterVo> character = null;

			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();

			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			headers.add("user-agent", ApiStarWarsConstants.HEADER);

			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

			final ResponseEntity<SpecieVo> specie = restTemplate.exchange(ApiStarWarsConstants.URL_LISTAGEM_PERSONAGENS_HUMANOS, HttpMethod.GET,
					entity, SpecieVo.class);

			response.setData(specie.getBody());
			
			int count_human = response.getData().getPeople().size();
			int count_height = 0;
			double media = 0d;
			
			for (String people : response.getData().getPeople()) {
				
				character = restTemplate.exchange(people, HttpMethod.GET, entity, CharacterVo.class);
				
				peoples.add(character.getBody().getName());
				
				try {
					count_height += (Integer.parseInt(character.getBody().getHeight()));
				} catch (Exception e) {
					count_height += 0;
				}
			}
			
			media = (count_height/count_human);
			
			response.getData().setMedia(media);
			response.getData().setPeople(peoples);
			
		} catch (Exception ex) {
			List<String> errors = new ArrayList<String>();
			errors.add(ex.getLocalizedMessage());
			response.setErrors(errors);
		}

		return response;
	}
	
	
	
	
}
