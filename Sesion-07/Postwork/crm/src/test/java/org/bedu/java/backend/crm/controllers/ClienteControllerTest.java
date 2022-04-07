package org.bedu.java.backend.crm.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.java.backend.crm.model.Cliente;
import org.bedu.java.backend.crm.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    void getCliente() throws Exception {
        given(clienteService.obtenCliente(anyLong())).willReturn(Optional.of(Cliente.builder().id(1L).nombre("Nombre").correoContacto("cliente@contacto.com").build()));

        mockMvc.perform(get("/cliente/1")
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.correoContacto", is("cliente@contacto.com")))
                .andExpect(jsonPath("$.nombre", is("Nombre")));
    }

    @Test
    void getClientes() throws Exception {

        List<Cliente> clientes = Arrays.asList(
                Cliente.builder().id(1L).nombre("Nombre 1").direccion("Direccion 1").numeroEmpleados(10).correoContacto("contacto@cliente1.com").build(),
                Cliente.builder().id(2L).nombre("Nombre 2").direccion("Direccion 2").numeroEmpleados(10).correoContacto("contacto@cliente2.com").build(),
                Cliente.builder().id(3L).nombre("Nombre 3").direccion("Direccion 3").numeroEmpleados(10).correoContacto("contacto@cliente3.com").build()
        );

        given(clienteService.obtenClientes()).willReturn(clientes);

        mockMvc.perform(get("/cliente")
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[0].correoContacto", is("contacto@cliente1.com")))
                .andExpect(jsonPath("$[2].nombre", is("Nombre 3")));
    }

    @Test
    void creaCliente() throws Exception {
        Cliente clienteParametro = Cliente.builder().nombre("Nombre").direccion("Direccion").numeroEmpleados(10).correoContacto("contacto@cliente.com").build();
        Cliente clienteRespuesta = Cliente.builder().id(1L).nombre("Nombre").direccion("Direccion").numeroEmpleados(10).correoContacto("contacto@cliente.com").build();

        given(clienteService.guardaCliente(clienteParametro)).willReturn(clienteRespuesta);

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(clienteParametro)))
                .andExpect(status().isCreated());
    }

    @Test
    void actualizaCliente() throws Exception {

        Cliente clienteParametro = Cliente.builder().id(1L).nombre("Nombre").direccion("Direccion").numeroEmpleados(10).correoContacto("contacto@cliente.com").build();

        mockMvc.perform(put("/cliente/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(clienteParametro)))
                .andExpect(status().isNoContent());
    }

    @Test
    void eliminaCliente() throws Exception {
        mockMvc.perform(delete("/cliente/1")
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
    }
}