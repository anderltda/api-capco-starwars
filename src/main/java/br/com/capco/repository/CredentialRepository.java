package br.com.capco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.com.capco.entity.UserCredential;

@Transactional(readOnly = true)
public interface CredentialRepository extends JpaRepository<UserCredential, Long> {

    UserCredential findByCode(String code);
	
    UserCredential findByEmail(String email);
	
    UserCredential findByCodeOrEmail(String code, String email);
}
