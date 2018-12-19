package edu.mum.service;

import edu.mum.dao.UserCredentialsDAO;
import edu.mum.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

/**
 * Created by: Ganbat Bayar
 * On: 12/17/2018
 * Project: Ticket_Booker
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserCredentialsDAO credentailsDAO;

    public UserCredentials getUser(String username) {
        System.out.println("working");
        System.out.println(username);
        UserCredentials userCredentials = credentailsDAO.findByUsername(username);
//        System.out.println(userCredentials.getUsername());
        return userCredentials;
    }

    public ResponseEntity resetPassword(String username) {
        UserCredentials user = getUser(username);
        String newPass = generatePass();
        System.out.println(newPass);
        user.setPassword(newPass);
        return ResponseEntity.ok().build();
    }

    private String generatePass() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

}
