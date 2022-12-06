///*
// *Author Name:Praveen Kumar
// *Date: 25-Nov-22
// *Created With IntelliJ Idea Community Edition
// */
//
//
//package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.service;
//
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Artist;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackAlreadyExistsException;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackNotFoundException;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.repository.TrackRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//@ExtendWith(MockitoExtension.class)
//public class TrackServiceImplTest {
//    Artist artist1, artist2;
//    List<Track> trackList;
//    @Mock
//    private TrackRepository trackRepository;
//    @InjectMocks
//    private TrackServiceImpl trackService;
//    private Track track1, track2;
//
//    @BeforeEach
//    void setUp() {
//        artist1 = new Artist(1, "arjun");
//        artist2 = new Artist(2, "Sneha");
//        track1 = new Track(1, "chitra", 9, artist1);
//        track2 = new Track(2, "ragava", 5, artist2);
//        trackList = Arrays.asList(track1, track2);
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    //Test case for saving the track success.
//    @Test
//    public void saveTrackSuccess() throws TrackAlreadyExistsException {
//        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(null));
//        when(trackRepository.save(any())).thenReturn(track1);
//        assertEquals(track1, trackService.saveTrack(track1));
//        verify(trackRepository, times(1)).save(any());
//        verify(trackRepository, times(1)).findById(any());
//    }
//
//    //Test case for saving the track failure.
//    @Test
//    public void saveTrackFailure() throws TrackAlreadyExistsException {
//        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(null));
//        when(trackRepository.save(any())).thenReturn(track2);
//        assertNotEquals(track1, trackService.saveTrack(track1));
//        verify(trackRepository, times(1)).save(any());
//        verify(trackRepository, times(1)).findById(any());
//    }
//
//    //Test case for deleting the track Success.
//    @Test
//    public void deleteTrackSuccess() throws TrackNotFoundException {
//        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(track1));
//        boolean flag = trackService.deleteTrack(track1.getTrackId());
//        assertEquals(true, flag);
//
//        verify(trackRepository, times(1)).deleteById(any());
//        verify(trackRepository, times(1)).findById(any());
//    }
//
//    //Test case for deleting the track Failure.
//    @Test
//    public void deleteTrackFailure() throws TrackNotFoundException {
//        when(trackRepository.findById(track1.getTrackId())).thenReturn(Optional.ofNullable(track1));
//        boolean flag = trackService.deleteTrack(track1.getTrackId());
//        assertNotEquals(false, flag);
//
//        verify(trackRepository, times(1)).deleteById(any());
//        verify(trackRepository, times(1)).findById(any());
//    }
//}