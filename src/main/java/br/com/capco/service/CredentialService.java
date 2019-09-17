package br.com.capco.service;

import java.util.List;
import java.util.Optional;
import br.com.capco.entity.UserCredential;

public interface CredentialService {
	
	/**
	 * Busca e retorna um funcionário dado um CPF.
	 * 
	 * @param code
	 * @return Optional<UserCredential>
	 */
	Optional<UserCredential> buscarPorCode(String code);
	
	/**
	 * Busca e retorna um funcionário dado um email.
	 * 
	 * @param email
	 * @return Optional<UserCredential>
	 */
	Optional<UserCredential> buscarPorEmail(String email);
	
	/**
	 * Busca e retorna um UserCredential por ID.
	 * 
	 * @param id
	 * @return Optional<UserCredential>
	 */
	Optional<UserCredential> buscarPorId(Long id);
	   
    /**
     * 
     * Obter todos os usuários e perfis salvos no banco de dados.
     *  
     * @return List<UserCredential>
     */
    List<UserCredential> listarTodosUsers();

}
