package broome.com.nastaavgang.nearbystations.impl.view;

import android.broome.com.nastaavgang.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import broome.com.nastaavgang.di.CustomApplication;
import broome.com.nastaavgang.nearbydeparture.impl.model.Departure;
import broome.com.nastaavgang.nearbydeparture.impl.view.MainActivity;
import broome.com.nastaavgang.nearbystations.impl.adapter.StationAdapter;
import broome.com.nastaavgang.nearbystations.impl.model.Station;
import broome.com.nastaavgang.nearbystations.impl.presenter.NearbyStationsPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by robin on 05/09/15.
 */
public class NearbyStationsActivity extends FragmentActivity implements OnMapReadyCallback,NearbyStationsPresenter.View,AdapterView.OnItemClickListener {


    @Bind(R.id.helloworld)
    ListView listViewOfStations;
    @Bind(R.id.connection_error_view)
    LinearLayout connectionError;
    @Bind(R.id.no_stations_error)
    LinearLayout noStationsError;
    @Bind(R.id.pb_loading)
    ProgressBar pb;
    @Bind(R.id.tool_bar)
    Toolbar toolbar;
    @Bind(R.id.map_and_list_stations)
    LinearLayout mapAndList;


    private List<Station> stations;
    private StationAdapter stationAdapter;
    private NearbyStationsPresenter presenter;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearbystations);
        ButterKnife.bind(this);
        toolbar.setTitle(getResources().getText(R.string.choose_station));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        presenter = ((CustomApplication)getApplication()).Component().nearbyStationsPresenter();
        presenter.setView(this);

        stations = new ArrayList<Station>();
        stationAdapter = new StationAdapter(this,stations);

        listViewOfStations.setAdapter(stationAdapter);
        listViewOfStations.setOnItemClickListener(this);


        mapFragment.getMapAsync(this);
        presenter.getGetNearbyStations();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.setMyLocationEnabled(true);
        map.getUiSettings().setMapToolbarEnabled(false);
        this.map = map;
    }

    @Override
    public void showLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mapAndList.setVisibility(View.GONE);
                connectionError.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);

            }
        });


    }

    @Override
    public void showConnectionError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mapAndList.setVisibility(View.GONE);
                connectionError.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);

            }
        });

    }

    @Override
    public void showStationsNotFound() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mapAndList.setVisibility(View.GONE);
                connectionError.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
                noStationsError.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void showStationsFound(final List<Station> stations) {
        this.stations.clear();
        this.stations.addAll(stations);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                stationAdapter.notifyDataSetChanged();
                mapAndList.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
                connectionError.setVisibility(View.GONE);
                if(map!=null){
                    for(Station s : stations) {
                        map.addMarker(new MarkerOptions().position(s.getLocation()).title(s.getName()));
                    }
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(stations.get(0).getLocation(), 15));
                }
            }
        });

    }

    @Override
    public void showDeparturesFound(List<Departure> departures) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, MainActivity.class);
        String strName = getResources().getString(R.string.current_station);
        String cityPath = getResources().getString(R.string.current_city);
        String stationId = stations.get(position).getId();
        String city = stations.get(position).getCity();
        intent.putExtra(strName, stationId);
        intent.putExtra(cityPath, city);
        startActivity(intent);
    }
}

