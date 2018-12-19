package edu.mum.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import edu.mum.dao.UserCredentialsDAO;
import edu.mum.entity.Authority;
import edu.mum.entity.UserCredentials;
import edu.mum.model.TokenModel;
import edu.mum.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by: Ganbat Bayar
 * On: 12/18/2018
 * Project: Ticket_Booker
 */
@Service
public class TokenService {

    @Autowired
    UserCredentialsDAO userCredentialsDAO;

    public ResponseEntity getToken(UserModel userModel) {
        UserCredentials userCredentials = userCredentialsDAO.findByUsername(userModel.getUsername());
        if (userCredentials != null) {
            if (userCredentials.getPassword().equals(userModel.getPassword())) {
                Algorithm algorithm = Algorithm.HMAC256(userCredentials.getPassword());
                String[] ars = userCredentials.getAuthority().stream().map(Authority::getAuthority).toArray(String[]::new);
                String token = JWT.create().withIssuer("Ticket").withSubject(userCredentials.getUsername()).withArrayClaim("authorities", ars).sign(algorithm);
                TokenModel tokenModel = new TokenModel(token);
                return ResponseEntity.ok(tokenModel);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
