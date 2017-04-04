package co.edu.pdam.eci.persistenceapiintegration.data.exception;

/**
 * Created by Julian Gonzalez Prieto (Avuuna la Luz del Alba) on 3/9/17.
 */
public class NetworkException extends Exception {

    public NetworkException(int code, String message, Throwable e) {
        super(message, e);
    }
}
