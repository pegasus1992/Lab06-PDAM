package co.edu.pdam.eci.persistenceapiintegration.data.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;

/**
 * Created by Julian Gonzalez Prieto (Avuuna, la Luz del Alba) on 11/16/16.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private final List<Team> teams;
    private Context context;

    public TeamsAdapter(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public TeamsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.team_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamsAdapter.ViewHolder viewHolder, int position) {
        Team team = teams.get(position);
        viewHolder.name.setText(team.getName());
        viewHolder.shortName.setText(team.getShortName());
        Picasso.with(context).load(team.getImageUrl()).into(viewHolder.logo);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, shortName;
        ImageView logo;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            shortName = (TextView) view.findViewById(R.id.shortName);
            logo = (ImageView) view.findViewById(R.id.logo);
        }
    }
}

