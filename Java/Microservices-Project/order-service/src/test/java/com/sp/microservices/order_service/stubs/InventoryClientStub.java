package com.sp.microservices.order_service.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.WireMockServer;


public class InventoryClientStub {

    public static void stubInventoryCall(String skuCode, Integer quantity) {

        stubFor(get(urlEqualTo("/api/inventory?skuCode=" +skuCode + "&quantity=" +quantity))

        .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("true")));

    }
}
