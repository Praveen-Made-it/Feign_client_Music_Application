///*
// *Author Name:Praveen Kumar
// *Date: 28-Nov-22
// *Created With IntelliJ Idea Community Edition
// */
//
//package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Artist;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackNotFoundException;
//import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.service.TrackServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class TrackControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private TrackServiceImpl trackService;
//
//    @InjectMocks
//    private TrackController trackController;
//    private Track track;
//    private Artist artist;
//
//    @BeforeEach
//    void setUp() {
//        artist = new Artist(105, "SPB");
//        track = new Track(36, "SPB", 4, artist);
//        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
//    }
//
//    @AfterEach
//    void tearDown() {
//        track = null;
//    }
//
//    private static String jsonToString(final Object ob) throws JsonProcessingException {
//        String result;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonContent = mapper.writeValueAsString(ob);
//            result = jsonContent;
//        } catch (JsonProcessingException e) {
//            result = "JSON processing error";
//        }
//
//        return result;
//    }
//
//    @Test
//    public void saveTrackSuccess() throws Exception {
//        when(trackService.saveTrack(any())).thenReturn(track);
//        mockMvc.perform(post("/trackData/track/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(track)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(trackService, times(1)).saveTrack(any());
//
//    }
//
//    @Test
//    public void deleteTrackSuccess() throws Exception, TrackNotFoundException {
//        when(trackService.deleteTrack(anyInt())).thenReturn(true);
//        mockMvc.perform(delete("/trackData/track/36")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(track)))
//                .andExpect(status().is2xxSuccessful())
//                .andDo(MockMvcResultHandlers.print());
//        verify(trackService, times(1)).deleteTrack(anyInt());
//    }
//}
