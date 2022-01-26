package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.services.iCarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.accept;

@ExtendWith(MockitoExtension.class)
class ControllerCarTest {

    ObjectMapper objectMapper;
    @InjectMocks
    private ControllerCar controllerCar;
    @Mock
    iCarService iCarService;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.controllerCar)
                .build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void postCar() throws Exception {
        when(iCarService.postCar(1L, 1234, "a", "a", "a", 1234, 123, 1234))
                .thenReturn("Car saved");

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("idClient", 1L);
        jsonObj.put("yearOfManufacture", 1234);
        jsonObj.put("manufacturer", "a");
        jsonObj.put("model", "a");
        jsonObj.put("version", "a");
        jsonObj.put("displacement", 1234);
        jsonObj.put("power", 123);
        jsonObj.put("mileage", 1234);

        MvcResult mvcResult = mockMvc.perform(post("/api/cars/postCar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj.toString()))
                .andExpect(status().isOk()).andReturn();
        assertEquals("Car saved", mvcResult.getResponse().getContentAsString());

    }

    @Test
    void deleteCar() throws Exception {
        when(iCarService.deleteCar(1L)).thenReturn("Car deleted");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/cars/deleteCar/{1}", 1L))
                .andExpect(status().isOk()).andReturn();
        assertEquals("Car deleted", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getCurrentCarsByClient() throws Exception {
        List<Car> carList = new ArrayList<>();
        when(iCarService.getCurrentCarsByClient(anyLong())).thenReturn(carList);
        MvcResult mvcResult = mockMvc.perform(get("/api/cars/getcurrentcarsbyclient/{1}", 1L))
                .andExpect(status().isOk()).andReturn();
        assertEquals(carList.toString(), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void putCar() throws Exception {
        when(iCarService.putCar(1L, "manufacturer", "model", "version", 250, 220000, 2000, 2010, 1L))
                .thenReturn("Car updated");


        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("idCar", 1L);
        jsonObj1.put("manufacturer", "manufacturer");
        jsonObj1.put("model", "model");
        jsonObj1.put("version", "version");
        jsonObj1.put("displacement", 2000);
        jsonObj1.put("power", 250);
        jsonObj1.put("mileage", 220000);
        jsonObj1.put("yearOfManufacture", 2010);
        jsonObj1.put("idClient", 1L);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/cars/putcar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObj1.toString()))
                .andExpect(status().isOk()).andReturn();
        assertEquals("Car updated", mvcResult.getResponse().getContentAsString());
    }
}