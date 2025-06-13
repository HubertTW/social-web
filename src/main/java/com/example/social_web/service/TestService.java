package com.example.social_web.service;

import com.example.social_web.exception.MyServiceException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class TestService {

    // if parse json failed --> rollback
    //@Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> test(String data) {
        String res;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(data);

           // get() could trigger nullpointer exception instead of path()
           res = root.get("or").asText();

        } catch (Exception e){
            throw new MyServiceException(e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(res);

        }

    }
