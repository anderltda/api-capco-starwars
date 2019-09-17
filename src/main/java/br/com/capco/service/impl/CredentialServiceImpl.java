package br.com.capco.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.capco.entity.UserCredential;
import br.com.capco.repository.CredentialRepository;
import br.com.capco.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService {

    private static final Logger log = LoggerFactory.getLogger(CredentialServiceImpl.class);

    @Autowired
    private CredentialRepository credentialRepository;


    @Override
    public Optional<UserCredential> buscarPorCode(String code) {
        log.info("Buscando UserCredential pelo CPF {}", code);
        return Optional.ofNullable(this.credentialRepository.findByCode(code));
    }

    @Override
    public Optional<UserCredential> buscarPorEmail(String email) {
        log.info("Buscando UserCredential pelo email {}", email);
        return Optional.ofNullable(this.credentialRepository.findByEmail(email));
    }

    @Override
    public Optional<UserCredential> buscarPorId(Long id) {
        log.info("Buscando UserCredential pelo ID {}", id);
        return this.credentialRepository.findById(id);
    }

    @Override
    public List<UserCredential> listarTodosUsers() {
        log.info("Buscando todos os UserCredential");
        return  this.credentialRepository.findAll();
    }
}
