package edu.baylor.GroupFive.database.services;

import edu.baylor.GroupFive.util.exceptions.InvalidCredentialsException;
import edu.baylor.GroupFive.util.logging.G5Logger;
import edu.baylor.GroupFive.database.daos.UserDAO;
import edu.baylor.GroupFive.models.User;

/**
 * The LoginService class provides static methods for logging in.
 *
 * @author Icko
 * */
public class LoginService {

     /**
      * Logs in a user. This function takes in two strings, a username and a 
      * hashed password. 
      *
      * @param username The username of the user attempting to login.
      * @param password The hashed password of the user attempting to login.
      * @return The authenticated User object of login is successful.
      * @throws InvalidCredentialsException If user does not exist in database
      *     or if password does not match credentials.
      * */
    public static User login(String username, String password) throws InvalidCredentialsException {
        UserDAO udao = new UserDAO();
        User dbUser = udao.getByUsername(username);
        System.out.println("[pswd-compare]=" + password);
        if (dbUser == null || !dbUser.verify(password)) {
            // TODO implement logger
            G5Logger.logger.error("invalid credentials provided to LoginService");
            throw new InvalidCredentialsException();
        }
        return dbUser;
    }

}
