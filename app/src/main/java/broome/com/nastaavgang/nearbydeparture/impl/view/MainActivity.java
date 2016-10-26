package broome.com.nastaavgang.nearbydeparture.impl.view;

import android.broome.com.nastaavgang.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.di.CustomApplication;
import broome.com.nastaavgang.nearbydeparture.impl.adapter.DepartureRecycleAdapter;
import broome.com.nastaavgang.nearbydeparture.impl.model.Departure;
import broome.com.nastaavgang.nearbydeparture.impl.presenter.StationListPresenter;
import broome.com.nastaavgang.nearbystations.impl.model.Station;
import broome.com.nastaavgang.nearbystations.impl.view.NearbyStationsActivity;
import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity implements StationListPresenter.View ,OnStreetViewPanoramaReadyCallback{

    @Bind(R.id.map_and_list)
    LinearLayout mapAndList;
    @Bind(R.id.pb_loading)
    ProgressBar pb;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.connection_error_view)
    LinearLayout connectionError;
    @Bind(R.id.no_departure_found)
    LinearLayout departureNotFound;
    @Bind(R.id.helloworld)
    RecyclerView recyclerView;

    @Inject
    StationListPresenter presenter;

    android.location.Location mLastLocation;
    List<Departure> departures;
    //DepartureAdapter departureAdapter;
    DepartureRecycleAdapter departureAdapter;
    StreetViewPanorama panorama;


    @Inject
    LocationInteractor ls;

    GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        departures = new ArrayList<Departure>();

        ButterKnife.bind(this);


        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);


        //departureAdapter = new DepartureAdapter(this,departures);

        //listViewOfDepartures.setAdapter(departureAdapter);

        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

        presenter = ((CustomApplication) getApplication()).Component().stationListPrestener();
        presenter.setView(this);
        loadDepartures();
        departureAdapter = new DepartureRecycleAdapter(recyclerView,departures);
        recyclerView.setAdapter(departureAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void loadDepartures(){
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String currentStationId= extras.getString(getResources().getString(R.string.current_station));
            String currentCity = extras.getString(getResources().getString(R.string.current_city));
            if(currentStationId != null && !currentStationId.isEmpty())
                presenter.getNearbyDepartures(currentStationId,currentCity);
            else
                presenter.getGetNearbyStations();

        } else {
            presenter.getGetNearbyStations();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {
        mapAndList.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);
        pb.setVisibility(View.VISIBLE);

    }
    private void showContent(){
        mapAndList.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
    }

    @Override
    public void showConnectionError() {
        final Context c = this;
        Log.d("CONNECTION ERROR","CONNERR");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mapAndList.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
                connectionError.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public void showStationsNotFound() {
        final Context c = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mapAndList.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
                connectionError.setVisibility(View.GONE);
                departureNotFound.setVisibility(View.VISIBLE);

            }
        });

    }

    @Override
    public void showStationsFound(List<Station> stations) {
        presenter.getNearbyDepartures();

    }

    @Override
    public void showDeparturesFound(final List<Departure> departures) {
        this.departures.clear();
        this.departures.addAll(departures);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                departureAdapter.notifyDataSetChanged();
                showContent();
                Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
                toolbar.setTitle(departures.get(0).getFromStation());
                if (panorama != null) {
                    //TODO: only update panorma when activity is run for the first time.
                    Log.i("asfaf", "setting panorama at " + departures.get(0).getLocation());
                    panorama.setPosition(departures.get(0).getLocation());
                }
            }
        });


    }


    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(57.689951, 11.972932));
        panorama = streetViewPanorama;

    }
    public void fabClicked(View v){
        Intent intent = new Intent(this, NearbyStationsActivity.class);
        startActivity(intent);

    }
    public void reconnect(View v){
        loadDepartures();
    }

}
