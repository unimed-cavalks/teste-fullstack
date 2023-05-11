package com.unimed.avaliacaoBack.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final String secretKey = "Un1m3dK3y123!";    

    @SuppressWarnings("unused")
	private final JwtTokenUtil jwtTokenUtil;
    @SuppressWarnings("unused")
	private final UserDetailsService userDetailsService;
    @SuppressWarnings("unused")
	private final AuthenticationManager authenticationManager;

    @Autowired
    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }    
        
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String jwtToken = extractJwtToken(request);

        if (StringUtils.hasText(jwtToken) && validateJwtToken(jwtToken)) {
            Authentication authentication = getAuthenticationFromJwt(jwtToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    private String extractJwtToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); //REMOVE PREFIXO "Bearer " PARA OBTER O TOKEN JWT
        }
        return null;
    }
    
    private boolean validateJwtToken(String jwtToken) {
        try {
            Jwts.parserBuilder().setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes())).build()
                    .parseClaimsJws(jwtToken);
            return true;
        } catch (Exception ex) {
            //AQUI PODEMOS DETALHAR O TRATAMENTO DEPENDENDO DE CADA CASO 
        	//ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException
        }
        return false;
    }    

    private Authentication getAuthenticationFromJwt(String jwtToken) {
        Claims claims = Jwts.parserBuilder().setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
                .build().parseClaimsJws(jwtToken).getBody();
        
        String username = claims.getSubject(); // PEGAR DETALHES DO USUARIO DO TOKEN JWT E CRIAR INSTANCIA DE AUTH
        return new UsernamePasswordAuthenticationToken(username, null, null);
    }

	@Override
	protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
			throws jakarta.servlet.ServletException, IOException {		
		
	}
}
