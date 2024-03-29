package br.com.capco.security.controller;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.capco.response.Response;
import br.com.capco.security.config.WebSecurityConfig;
import br.com.capco.security.util.JwtTokenUtil;
import br.com.capco.security.vo.JwtAuthenticationVo;
import br.com.capco.security.vo.TokenVo;

@RestController
@RequestMapping(WebSecurityConfig.PATH_REQUEST_MAPPING)
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String TOKEN_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Gera e retorna um novo token JWT.
     * 
     * @param jwtAuthenticationVo
     * @param result
     * @return ResponseEntity<Response<TokenVo>>
     * @throws AuthenticationException
     */
    @PostMapping
    public ResponseEntity<Response<TokenVo>> gerarTokenJwt(
            @Valid @RequestBody JwtAuthenticationVo jwtAuthenticationVo, BindingResult result)
            throws AuthenticationException {
        Response<TokenVo> response = new Response<TokenVo>();

        if (result.hasErrors()) {
            log.error("Erro validando lançamento: {}", result.getAllErrors());
            result.getAllErrors()
                    .forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        log.info("Gerando token para o email {}.", jwtAuthenticationVo.getCpf());
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        jwtAuthenticationVo.getCpf(), jwtAuthenticationVo.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(jwtAuthenticationVo.getCpf());
        String token = jwtTokenUtil.obterToken(userDetails);
        response.setData(new TokenVo(token));

        return ResponseEntity.ok(response);
    }

    /**
     * Gera um novo token com uma nova data de expiração.
     * 
     * @param request
     * @return ResponseEntity<Response<TokenVo>>
     */
    @PostMapping(value = "/refresh")
    public ResponseEntity<Response<TokenVo>> gerarRefreshTokenJwt(HttpServletRequest request) {
        log.info("Gerando refresh token JWT.");
        Response<TokenVo> response = new Response<TokenVo>();
        Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));

        if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
            token = Optional.of(token.get().substring(7));
        }

        if (!token.isPresent()) {
            response.getErrors().add("Token não informado.");
        } else if (!jwtTokenUtil.tokenValido(token.get())) {
            response.getErrors().add("Token inválido ou expirado.");
        }

        if (!response.getErrors().isEmpty()) {
            return ResponseEntity.badRequest().body(response);
        }

        String refreshedToken = jwtTokenUtil.refreshToken(token.get());
        response.setData(new TokenVo(refreshedToken));
        return ResponseEntity.ok(response);
    }
}
