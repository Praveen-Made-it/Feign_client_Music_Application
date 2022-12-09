/*
 *Author Name:Praveen Kumar
 *Date: 24-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.ArtistNotFoundException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackNotFoundException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.proxy.UserProxy;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;
    private UserProxy userProxy;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository, UserProxy userProxy) {
        this.trackRepository = trackRepository;
        this.userProxy = userProxy;
    }
    //    @Override
//    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
//        if (trackRepository.findById(track.getTrackId()).isPresent()) {
//            throw new TrackAlreadyExistsException();
//        }
//        return trackRepository.save(track);
//    }


    @Override
    public Track saveTrack(Track track) {
        userProxy.saveUser(track);
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFoundException {
        boolean flag = false;
        if (trackRepository.findById(trackId).isEmpty()) {
            throw new TrackNotFoundException();
        } else {
            trackRepository.deleteById(trackId);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Track> getAllTracksByRatingGreaterThan4() {
        return trackRepository.findAllTracksFromRating();
    }

    @Override
    public List<Track> getAllTracksByArtistName(String artistName) throws ArtistNotFoundException {
        if (trackRepository.findAllTracksFromArtistName(artistName).isEmpty()) {
            throw new ArtistNotFoundException();
        }
        return trackRepository.findAllTracksFromArtistName(artistName);
    }
}