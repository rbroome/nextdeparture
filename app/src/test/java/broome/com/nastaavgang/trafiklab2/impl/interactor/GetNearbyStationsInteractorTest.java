package broome.com.nastaavgang.trafiklab2.impl.interactor;

import android.location.Location;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import broome.com.nastaavgang.base.interfaces.GetLastLocation;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.executor.impl.ThreadExecutor;
import broome.com.nastaavgang.trafiklab2.interfaces.TrafikLab2Service;
import retrofit.RetrofitError;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by robin on 30/10/16.
 */

public class GetNearbyStationsInteractorTest extends TrafikLabBaseTest{

    private static final String ID = null;
    GetNearbyStationsInteractor interactor;

    @Mock
    TrafikLab2Service ts;
    @Mock
    GetNearbyStations.Callback cb;
    @Mock
    GetLastLocation loc;

    @Mock
    Location location;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(ts.getArrivals(ID)).thenReturn(getArrivals());
        when(ts.getDepartures(ID)).thenReturn(getDepartures());
        when(location.getLongitude()).thenReturn(1.0);
        when(location.getLatitude()).thenReturn(1.0);
        interactor = new GetNearbyStationsInteractor(new ThreadExecutor(),ts,loc);
        interactor.setLastLocation(location);

    }
    @Test
    public void noStationsFoundTest(){
        //GIVEN
        when(ts.getNearbyStation("1.0","1.0")).thenReturn(getEmptyStations());
        interactor.setCallback(cb);
        //WHEN
        interactor.run();
        //THEN
        verify(cb,never()).onConnectionError();
        verify(cb,never()).onStationsFound(anyList());
        verify(cb,times(1)).onStationsNotFound();
        assertThat(interactor.getStations().isEmpty(),is(true));
    }
    @Test
    public void noInternetConnectionTest(){
        //GIVEN
        when(ts.getNearbyStation("1.0","1.0")).thenThrow(RetrofitError.class);
        interactor.setCallback(cb);
        //WHEN
        interactor.run();
        //THEN
        verify(cb,times(1)).onConnectionError();
        verify(cb,never()).onStationsFound(anyList());
        verify(cb,never()).onStationsNotFound();
        assertThat(interactor.getStations().isEmpty(),is(true));
    }
    @Test
    public void getStationsTest(){
        //GIVEN
        when(ts.getNearbyStation("1.0","1.0")).thenReturn(getStations());
        interactor.setCallback(cb);
        //WHEN
        interactor.run();
        //THEN
        verify(cb,never()).onConnectionError();
        verify(cb,times(1)).onStationsFound(anyList());
        verify(cb,never()).onStationsNotFound();
        assertThat(interactor.getStations().size(),is(1));
    }
}
