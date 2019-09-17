package br.com.capco.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.capco.response.Response;
import br.com.capco.service.CharacterService;
import br.com.capco.util.HelpUtil;
import br.com.capco.vo.CharacterVo;
import br.com.capco.vo.SpecieVo;
import br.com.capco.vo.SwapiVo;
import br.com.capco.vo.parse.JsonObjectParse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiCapcoStarwarsController {

    private static final Logger log = LoggerFactory.getLogger(ApiCapcoStarwarsController.class);

    @Autowired
    private CharacterService characterService;

    @Value("${paginacao.qtd_por_pagina}")
    private int size;

    /**
     * Obter todos os personagens e ordená-los por quantidade de filmes que aparecem, usando nome do
     * personagem como segundo critério de ordenação (ordem alfabética).
     *
     */
    @GetMapping(value = "/all/character")
    public ResponseEntity<List<CharacterVo>> buscarApiAll(@RequestParam(value = "page") int page) {

        log.info(
                "Obter todos os personagens e ordená-los por quantidade de filmes que aparecem, usando "
                        + "nome do personagem como segundo critério de ordenação (ordem alfabética). page: {}",
                page);

        Response<SwapiVo> response = getCharacterService().listarTodosPersonagens(page);

        List<JsonObjectParse> results = response.getData().getResults();

        List<CharacterVo> characteres = results.stream()
                .map(ps -> convertJsonObjectParseForCharacterVo(ps)).collect(Collectors.toList());

        characteres.sort((ch1, ch2) -> ch1.getCount_films().compareTo(ch2.getCount_films()));

        return ResponseEntity.ok(characteres);
    }

    /**
     * Obter um personagem por ID e trazer nome do personagem, ano de nascimento e nome dos filmes
     * que está
     *
     */
    @GetMapping(value = "/find")
    public ResponseEntity<String> buscarApiId(@RequestParam(value = "id") int id) {

        log.info(
                "Obter um personagem por ID e trazer nome do personagem, ano de nascimento e nome dos "
                        + "filmes que está ID: {}",
                id);

        Response<CharacterVo> response = getCharacterService().buscarPorId(id);

        if (response.getData() == null) {
            return new ResponseEntity<String>("{ \"erro\": \"Nenhum registro encontrado.\" }",
                    HttpStatus.BAD_REQUEST);
        }

        response.getData().setId(String.valueOf(id));

        return ResponseEntity.ok(HelpUtil.convertObjectForJson(response.getData()));
    }

    /**
     * Obter a lista de todos os personagens humanos e calcular a média de peso dentre eles
     *
     */
    @GetMapping(value = "/all/human")
    public ResponseEntity<Response<SpecieVo>> buscarApiHumanAll() {

        log.info(
                "Obter a lista de todos os personagens humanos e calcular a média de peso dentre eles");

        Response<SpecieVo> response = getCharacterService().listarTodosHumanos();

        return ResponseEntity.ok(response);
    }

    private CharacterVo convertJsonObjectParseForCharacterVo(JsonObjectParse parse) {

        String id = HelpUtil.somenteNumeros(parse.getUrl());

        return new CharacterVo(id, parse.getName(), parse.getHeight(), parse.getBirth_year(), parse.getFilms());
    }

    /**
     * @return the characterService
     */
    public CharacterService getCharacterService() {
        return characterService;
    }
}
