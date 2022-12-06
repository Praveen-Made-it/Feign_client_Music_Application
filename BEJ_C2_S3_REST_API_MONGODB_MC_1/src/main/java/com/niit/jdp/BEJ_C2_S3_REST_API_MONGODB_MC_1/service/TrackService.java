package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.ArtistNotFoundException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackAlreadyExistsException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    Track saveTrack(Track track) throws TrackAlreadyExistsException;

    List<Track> getAllTracks();

    boolean deleteTrack(int trackId) throws TrackNotFoundException;

    List<Track> getAllTracksByRatingGreaterThan4();

    List<Track> getAllTracksByArtistName(String artistName) throws ArtistNotFoundException;
}
