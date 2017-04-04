package co.edu.pdam.eci.persistenceapiintegration.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;
import co.edu.pdam.eci.persistenceapiintegration.data.exception.NetworkException;
import co.edu.pdam.eci.persistenceapiintegration.data.network.RequestCallback;
import co.edu.pdam.eci.persistenceapiintegration.data.network.RetrofitNetwork;
import co.edu.pdam.eci.persistenceapiintegration.data.ui.adapter.TeamsAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureRecyclerView();

        Background bkg = new Background();
        /*try {
            Model model = new OrmModel();
            model.init(this);//getApplicationContext()
            TeamDao teamDao = model.getTeamDao();
            teamDao.create(new Team());
            List<Team> teams = teamDao.getAll();
            System.out.println("Team: " + teams.get(1).toString());
        } catch (DBException e) {
            e.printStackTrace();
        }*/
    }


    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private class Background {
        private final RetrofitNetwork network;
        private final ExecutorService executorService;
        private List<Team> teams;

        public Background() {
            network = new RetrofitNetwork();
            executorService = Executors.newFixedThreadPool(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    network.getTeams(new RequestCallback<List<Team>>() {
                        @Override
                        public void onSuccess(List<Team> response) {
                            teams = response;
                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            teams = null;
                        }
                    });
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (teams != null) {
                                recyclerView.setAdapter(new TeamsAdapter(teams));
                            }
                        }
                    });
                }
            });
        }
    }
}
