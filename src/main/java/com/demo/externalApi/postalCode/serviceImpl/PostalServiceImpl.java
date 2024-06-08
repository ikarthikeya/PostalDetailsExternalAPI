package com.demo.externalApi.postalCode.serviceImpl;

import com.demo.externalApi.postalCode.output.PostOfficeResponseBean;
import com.demo.externalApi.postalCode.service.IPostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("postalServiceImpl")
public class PostalServiceImpl implements IPostalService {
    @Autowired
    RestTemplate restTemplate;
    @Override
    public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String cityValue) {
        String url = "https://api.postalpincode.in/postoffice/{city}";
        url = url.replace("{city}", cityValue);
        System.out.println("Url is "+ url);
        ResponseEntity<PostOfficeResponseBean[]> postalResponseEntity = restTemplate
                .getForEntity(url, PostOfficeResponseBean[].class);
        System.out.println(postalResponseEntity.getStatusCode()+" "+postalResponseEntity.getBody());
        PostOfficeResponseBean[] responseBeans = postalResponseEntity.getBody();
        return responseBeans[0];
    }
}
