package br.com.capco.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.capco.entity.UserCredential;
import br.com.capco.service.CredentialService;

@RestController
@RequestMapping("/credential")
@CrossOrigin(origins = "*")
public class UserCredentialController {

    private static final Logger log = LoggerFactory.getLogger(UserCredentialController.class);

    @Autowired
    private CredentialService credentialService;

    /**
     * Retornar todos os usuários e perfis salvos no banco de dados.
     *
     */
    @GetMapping(value = "/all/users")
    public ResponseEntity<List<UserCredential>> buscarUsuariosTodos() {

        log.info("Obter a lista de todos os usuários e perfis salvos no banco de dados.");

        List<UserCredential> users = getCredentialService().listarTodosUsers();

        return ResponseEntity.ok(users);
    }


    /**
     * @return the credentialService
     */
    public CredentialService getCredentialService() {
        return credentialService;
    }
}
