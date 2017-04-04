package co.edu.pdam.eci.persistenceapiintegration.data.network;

import co.edu.pdam.eci.persistenceapiintegration.data.exception.NetworkException;

/**
 * Created by Julian Gonzalez Prieto (Avuuna la Luz del Alba) on 3/9/17.
 */

public interface RequestCallback<T> {

    void onSuccess(T response);

    void onFailed(NetworkException e);

}
