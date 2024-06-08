package com.demo.externalApi.postalCode.controller;

import com.demo.externalApi.postalCode.output.PostOfficeResponseBean;
import com.demo.externalApi.postalCode.serviceImpl.PostalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/postal")
public class PostDetailsController {
    @Autowired
    PostalServiceImpl postalServiceImpl;
    @RequestMapping(value="/byCity", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PostOfficeResponseBean getPostalbyCity(@RequestParam String city)
    {
        PostOfficeResponseBean postOfficeResponseBean = postalServiceImpl.fetchPostOfficeDetailsByCity(city);
        return postOfficeResponseBean;
    }
}
