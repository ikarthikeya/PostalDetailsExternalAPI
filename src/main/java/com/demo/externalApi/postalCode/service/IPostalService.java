package com.demo.externalApi.postalCode.service;

import com.demo.externalApi.postalCode.output.PostOfficeDetails;
import com.demo.externalApi.postalCode.output.PostOfficeResponseBean;

public interface IPostalService {
    public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String city);
}
