///*
// *Author Name:Praveen Kumar
// *Date: 25-Nov-22
// *Created With IntelliJ Idea Community Edition
// */
//
//
//package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.repository;
//
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Artist;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class TrackRepositoryTest {
//
//    @Autowired
//    private TrackRepository trackRepository;
//    private Artist artist;
//    private Track track;
//
//    @BeforeEach
//    void setUp() {
//        artist = new Artist(1, "Arun");
//        track = new Track(1, "donu", 7, artist);
//    }
//
//    @AfterEach
//    void tearDown() {
//        artist = null;
//        track = null;
//        trackRepository.deleteAll();
//
//    }
//
//    @Test
//    // Test case for retrieving all the track by Artist Name success
//    public void getTrackByArtistNameSuccess() {
//        artist = new Artist(5, "spb");
//        track = new Track(5, "mannil", 9, artist);
//        trackRepository.insert(track);
//        List<Track> tracks = trackRepository.findAllTracksFromArtistName(track.getTrackArtist().getArtistName());
//        assertEquals(1, tracks.size());
//        assertEquals(track.getTrackArtist().getArtistName(), tracks.get(0).getTrackArtist().getArtistName());
//    }
//
//    @Test
//    // Test case for retrieving all the track by Artist Name failure
//    public void getTrackByArtistNameFailure() {
//
//        artist = new Artist(3, "spb");
//        track = new Track(4, "mannil", 8, artist);
//        trackRepository.insert(track);
//        List<Track> tracks = trackRepository.findAllTracksFromArtistName(track.getTrackArtist().getArtistName());
//        assertNotEquals(3, tracks.size());
//        assertEquals(track.getTrackArtist().getArtistName(), tracks.get(0).getTrackArtist().getArtistName());
//    }
//    //Test case for retrieving all the track by Track Rating success
//    @Test
//
//    public void getTrackByTrackRatingSuccess() {
//        trackRepository.insert(track);
//        artist = new Artist(1, "kala");
//        track = new Track(7, "vanam", 5, artist);
//        trackRepository.insert(track);
//        List<Track> tracks = trackRepository.findAllTracksFromRating();
//        assertEquals(2, tracks.size());
//
//    }
//
//    //Test case for retrieving all the track by Track Rating failure
//    @Test
//
//    public void getTrackByTrackRatingFailure() {
//        trackRepository.insert(track);
//        artist = new Artist(1, "kala");
//        track = new Track(7, "vanam", 5, artist);
//        trackRepository.insert(track);
//        List<Track> tracks = trackRepository.findAllTracksFromRating();
//        assertNotEquals(7, tracks.size());
//
//    }
//
//
//}
//
//
