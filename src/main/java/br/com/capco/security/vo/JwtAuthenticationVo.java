package br.com.capco.security.vo;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class JwtAuthenticationVo {
	
	private String cpf;
	private String senha;
	
    /**
     * @return the cpf
     */
	@NotEmpty(message = "Cpf é obrigatório.")
	@CPF(message = "Cpf inválido.")
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the senha
     */
    @NotEmpty(message = "Senha é obrigatório.")
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
