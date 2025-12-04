package com.ecomm.order.clients.product;

import com.ecomm.order.entity.PurchaseRequest;
import com.ecomm.order.handler.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {
    private final RestTemplate restTemplate;
    @Value("${application.config.product-url}")
    private String productUrl;

    public List<PurchaseResponse> purchaseRequests(List<PurchaseRequest> purchaseRequests){
//        Prepare Header
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        Prepare Request
        HttpEntity<List<PurchaseRequest>> listHttpEntity=new HttpEntity<>(purchaseRequests,httpHeaders);
//        Prepare Response
        ParameterizedTypeReference<List<PurchaseResponse>> responseType=new ParameterizedTypeReference<List<PurchaseResponse>>(){};
//        Exchage Data
        ResponseEntity<List<PurchaseResponse>> listResponseEntity=restTemplate.exchange(
                productUrl +"/purchase",
                HttpMethod.POST,
                listHttpEntity,
                responseType
        );
        if(listResponseEntity.getStatusCode().isError()){
            throw new BusinessException("Error During Purchase products");
        }
return listResponseEntity.getBody();
    }

}
