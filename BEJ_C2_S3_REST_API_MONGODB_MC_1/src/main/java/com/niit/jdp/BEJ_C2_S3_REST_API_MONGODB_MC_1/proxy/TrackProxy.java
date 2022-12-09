package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.proxy;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "authentication-service", url = "authentication-service:8082")
public interface TrackProxy {
    @PostMapping("/api/v2/register/")
    public ResponseEntity<?> saveUser(@RequestBody Track user);

}
