package co.edu.pdam.eci.persistenceapiintegration.data.service;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Julian Gonzalez Prieto (Avuuna la Luz del Alba) on 3/9/17.
 */

public interface TeamsService {

    @GET("teams.json")
    Call<List<Team>> getTeamsList();
}
