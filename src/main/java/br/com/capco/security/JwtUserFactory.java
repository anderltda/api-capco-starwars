package br.com.capco.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import br.com.capco.entity.UserCredential;
import br.com.capco.enums.ProfileEnum;


public class JwtUserFactory {

    /**
     * Converte e gera um JwtUser com base nos dados de um userCredential.
     * 
     * @param credential
     * @return JwtUser
     */
    public static JwtUser create(UserCredential credential) {
        return new JwtUser(credential.getId(), credential.getCode(),
                credential.getPassword(), mapToGrantedAuthorities(credential.getProfile()));
    }

    /**
     * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
     * 
     * @param profile
     * @return List<GrantedAuthority>
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profile) {
        
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
    	authorities.add(new SimpleGrantedAuthority(profile.toString()));
        
    	return authorities;
    }

}
