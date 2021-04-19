package com.bionexo.contract.v1;

import com.bionexo.contract.facade.UbsFacade;
import com.bionexo.contract.v1.stub.StubUbsContract;
import com.bionexo.ubs.Application;
import com.bionexo.ubs.impl.UbsService;
import com.bionexo.ubs.impl.repository.UbsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static com.bionexo.contract.v1.stub.StubUbsContract.StubPageableRequest;
import static com.bionexo.contract.v1.stub.StubUbsContract.stubGeoCodeRequest;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootConfiguration
class UbsContractTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Mock
    private UbsRepository repository;

    @MockBean
    private UbsContract contract;

    @MockBean
    private UbsFacade facade;
    @MockBean
    private UbsService service;


    @Test
    void findUbs() throws Exception {

        when(repository.findByGeoCode(stubGeoCodeRequest(),StubPageableRequest()))
                .thenReturn(StubUbsContract.stubPageUbsResponse());

        mockMvc.perform(get("/api/v1/find_ubs?query=-10,-10")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON)
                .queryParam("query", "-10,-10")
                .queryParam("page", "1")
                .queryParam("per_page", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(StubUbsContract.pageableUbsContractStub())));
    }
}