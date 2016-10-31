package broome.com.nastaavgang.trafiklab2.impl.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import broome.com.nastaavgang.base.interfaces.GetNearbyDepartures;
import broome.com.nastaavgang.executor.impl.ThreadExecutor;
import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;
import broome.com.nastaavgang.trafiklab2.interfaces.TrafikLab2Service;
import retrofit.RetrofitError;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by robin on 29/10/16.
 */
public class GetNearbyDeparturesInteractorTest extends TrafikLabBaseTest{

    private static final String ID = null;
    GetNearbyDeparturesInteractor interactor;

    @Mock
    TrafikLab2Service ts;
    @Mock
    GetNearbyDepartures.Callback cb;

    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        when(ts.getArrivals(ID)).thenReturn(getArrivals());
        when(ts.getDepartures(ID)).thenReturn(getDepartures());

        interactor = new GetNearbyDeparturesInteractor(new ThreadExecutor(),ts);
    }

    @Test
    public void departuresFoundTest(){
        //GIVEN
        interactor.setCallback(cb);
        //WHEN
        interactor.run();
        //THEN

        Departure actual = interactor.getDepartures().get(0);


        verify(cb,never()).onConnectionError();
        verify(cb,times(1)).onDeparturesFound(anyList());
        verify(cb,never()).onDeparturesNotFound();
        assertThat(interactor.getDepartures().isEmpty(),is(false));
        assertThat(getDepartures().getDeparture().get(0).getDirection(),containsString(actual.getToStation()));
        assertThat(getDepartures().getDeparture().get(0).getTransportNumber(),is(actual.getNumber()));
    }
    @Test
    public void noDeparturesFoundTest(){
        //GIVEN
        when(ts.getArrivals(ID)).thenReturn(getEmptyArrivals());
        when(ts.getDepartures(ID)).thenReturn(getEmptyDepartures());
        interactor.setCallback(cb);
        //WHEN
        interactor.run();
        //THEN
        verify(cb,never()).onConnectionError();
        verify(cb,never()).onDeparturesFound(anyList());
        verify(cb,times(1)).onDeparturesNotFound();
        assertThat(interactor.getDepartures().isEmpty(),is(true));
    }

    @Test
    public void connectionErrorTest() {
        //GIVEN
        when(ts.getArrivals(ID)).thenThrow(RetrofitError.class);
        when(ts.getDepartures(ID)).thenThrow(RetrofitError.class);

        interactor.setCallback(cb);
        //WHEN
        interactor.run();
        //THEN
        verify(cb, never()).onDeparturesNotFound();
        verify(cb, never()).onDeparturesFound(anyList());
        verify(cb, times(1)).onConnectionError();
        assertThat(interactor.getDepartures().isEmpty(), is(true));
    }


}
