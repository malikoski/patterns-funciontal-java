package br.com.malikoski.chainofresponsability;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsabilityPattern {

    static UnaryOperator<AuthenticatorProvider> oauthProcessor = (AuthenticatorProvider p) -> p instanceof OauthAuthenticationProvider oauth ? oauth.nameAuthenticator() : p;
    static UnaryOperator<AuthenticatorProvider> usernamePasswordProcessor = (AuthenticatorProvider p) -> p instanceof UserNamePasswordProvider userpass ? userpass.nameAuthenticator() : p;
    static UnaryOperator<AuthenticatorProvider> jwtTokenPasswordProcessor = (AuthenticatorProvider p) -> p instanceof JwtTokenAuthenticationProvider jwttoken ? jwttoken.nameAuthenticator() : p;


    public static void main(String[] args) {

        var oauthProvider = new OauthAuthenticationProvider();
        var userNameProvider = new UserNamePasswordProvider();
        var jwtProvider = new JwtTokenAuthenticationProvider();

        var processor = oauthProcessor.andThen(usernamePasswordProcessor).andThen(jwtTokenPasswordProcessor);


        processor.apply(jwtProvider);
        processor.apply(userNameProvider);
        processor.apply(oauthProvider);
    }


    interface AuthenticatorProvider {
        AuthenticatorProvider nameAuthenticator();
    }

    static class OauthAuthenticationProvider implements AuthenticatorProvider {
        @Override
        public OauthAuthenticationProvider nameAuthenticator() {
            System.out.println("Oauth Authenticator Provider");
            return this;
        }
    }

    static class UserNamePasswordProvider implements AuthenticatorProvider {

        @Override
        public UserNamePasswordProvider nameAuthenticator() {
            System.out.println("Username with password authenticator provider");
            return this;
        }
    }

    static class JwtTokenAuthenticationProvider implements AuthenticatorProvider {

        @Override
        public JwtTokenAuthenticationProvider nameAuthenticator() {
            System.out.println("Jwt token authentication provider");
            return this;
        }
    }


}
