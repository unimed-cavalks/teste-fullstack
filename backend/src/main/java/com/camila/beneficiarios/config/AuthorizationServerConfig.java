package com.camila.beneficiarios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    public static final String MY_ANGULAR_APP = "my-angular-app";
    @Autowired
    private AuthenticationManager authenticationManager;

    private static final String SIGNING_KEY = "dGV1IGN1IGFycm9tYmFkbw==";

    public TokenStore tokeStore(){
        return new JwtTokenStore( accessTokenConverter() );
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey( SIGNING_KEY );
        return tokenConverter;
    }

    @Override
    public void configure( AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(  tokeStore() )
                .accessTokenConverter( accessTokenConverter() )
                .authenticationManager( authenticationManager );
    }

    @Override
    public void configure( ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient( MY_ANGULAR_APP )
                .secret( "@123" )
                .scopes( "read", "write" )
                .authorizedGrantTypes( "password" )
                .accessTokenValiditySeconds( 1800 );
    }

}
