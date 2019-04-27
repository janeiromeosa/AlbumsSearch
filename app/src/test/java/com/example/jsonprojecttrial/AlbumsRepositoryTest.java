package com.example.jsonprojecttrial;

import com.example.jsonprojecttrial.data.AlbumsResponse;
import com.example.jsonprojecttrial.repo.AlbumsRepository;
import com.example.jsonprojecttrial.repo.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlbumsRepositoryTest {

    @Mock
    private DataSource localDataSource;

    @Mock
    private DataSource remoteDataSource;

    @Mock
    private AlbumsResponse albumsResponse;

    List<AlbumsResponse> albumsResponseList = new ArrayList<>();

    private AlbumsRepository albumsRepository;

    @Before
    public void setup(){
        //MockitoAnnotations.initMocks(this);
        albumsRepository = new AlbumsRepository(remoteDataSource, localDataSource);
    }

    @Test
    public void testGetAlbumsWhenDeviceIsOnline(){
        albumsResponseList.add(albumsResponse);
        //Given
        when(remoteDataSource.getAlbumsSearch())
                .thenReturn(Single.just(albumsResponseList));
        when(localDataSource.getAlbumsSearch())
                .thenReturn(Single.just(albumsResponseList));

        //When
        TestObserver testObserver = albumsRepository.getAlbumsSearch().test();
        testObserver.assertResult(albumsResponseList);
        testObserver.assertValueCount(1);

        //Then
        Mockito.verify(remoteDataSource).getAlbumsSearch();
        Mockito.verify(localDataSource).addAlbum(albumsResponse);
        Mockito.verify(localDataSource).getAlbumsSearch();

        Mockito.verifyNoMoreInteractions(remoteDataSource, localDataSource);

    }
    @Test
    public void getAlbumsWhenAlbumsIsOffline(){
        //Given
        when(remoteDataSource.getAlbumsSearch())
                .thenReturn(Single.error(new IOException()));
        when(localDataSource.getAlbumsSearch())
                .thenReturn(Single.just(albumsResponseList));
        //When
        albumsRepository.getAlbumsSearch().test();

        //Then
        verify(remoteDataSource).getAlbumsSearch();
        verify(localDataSource).getAlbumsSearch();
        verify(localDataSource, Mockito.times(0))
                .addAlbum(Mockito.any());

        //Mockito.verifyZeroInteractions(localDataSource.addAlbum();
    }
}
