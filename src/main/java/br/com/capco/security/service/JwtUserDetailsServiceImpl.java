package br.com.capco.security.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.capco.entity.UserCredential;
import br.com.capco.security.JwtUserFactory;
import br.com.capco.service.CredentialService;
import br.com.capco.util.HelpUtil;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CredentialService credentialService;

	@Override
	public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
		Optional<UserCredential> userCredential = credentialService.buscarPorCode(HelpUtil.somenteNumeros(code));

		if (userCredential.isPresent()) {
			return JwtUserFactory.create(userCredential.get());
		}

		throw new UsernameNotFoundException("CPF não encontrado.");
	}

}
