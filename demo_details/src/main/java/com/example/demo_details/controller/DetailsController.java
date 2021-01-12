package com.example.demo_details.controller;

import com.example.demo_details.dto.DetailsDTO;
import com.example.demo_details.service.DetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className DetailsController
 * @description 아래 예제는 Details Service 콘트롤러입니다. GET Method 메소드를 갖고 있습니다.
 */
@CrossOrigin(origins="*")
@RestController
public class DetailsController {
    Logger logger = LoggerFactory.getLogger(DetailsController.class);

    @Autowired
    private DetailsService service;

    /**
     * @methodName getProductpageInfo
     * @throws     Exception
     * @description GET Request를 받아서 전체 Productpage 정보를 조회하는 메소드
     */
    @RequestMapping(value="/detailsInfo", method=RequestMethod.GET)
    public ResponseEntity<DetailsDTO.Response> getDetailsInfo(@RequestHeader HttpHeaders requestHeader,  @RequestParam String prodCode) throws Exception{
        DetailsDTO.Response responseBody = null;
        try {
            responseBody = service.getDetailsInfo(prodCode);
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ResponseEntity.ok().body(responseBody);
    }
}
