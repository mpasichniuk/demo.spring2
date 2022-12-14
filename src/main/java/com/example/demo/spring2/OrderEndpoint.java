package com.example.demo.spring2;

import com.flamexander.spring.ws.services.GroupService;
import com.flamexander.spring.ws.soap.groups.GetGroupByTitleRequest;
import com.flamexander.spring.ws.soap.groups.GetGroupByTitleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class OrderEndpoint {
    private static final String NAMESPACE_URI = "http://www.flamexander.com/spring/ws/orders";
    private final OrderService orderService;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetOrderByTitleResponse getOrderByTitle(@RequestPayload GetOrderByTitleRequest request) {
        GetOrderByTitleResponse response = new GetOrderByTitleResponse();
        response.setOrder(groupService.getByTitle(request.getTitle()));
        return response;
    }
}
