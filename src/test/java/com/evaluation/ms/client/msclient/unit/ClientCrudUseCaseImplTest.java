package com.evaluation.ms.client.msclient.unit;

import com.evaluation.ms.client.msclient.application.usecase.ClientCrudUseCase;
import com.evaluation.ms.client.msclient.application.usecase.impl.ClientCrudUseCaseImpl;
import com.evaluation.ms.client.msclient.domain.model.ClientModel;
import com.evaluation.ms.client.msclient.infrastructure.persistence.entity.Client;
import com.evaluation.ms.client.msclient.infrastructure.service.ClientCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientCrudUseCaseImplTest {
    @Mock
    private ClientCrudService clientCrudService;

    @InjectMocks
    private ClientCrudUseCaseImpl clientCrudUseCaseImpl;

    private ClientModel clientModel;

    @BeforeEach
    void setUp() {
        clientModel = ClientModel.builder()
                .id(1L)
                .nombres("Juan Esteban")
                .apellidoPaterno("Perez")
                .apellidoMaterno("Garcia")
                .documento("1234")
                .correo("jepg@gmail.com")
                .build();
    }

    @Test
    void givenClient_whenCreate_thenreturnsCreated(){
        Mockito.when(clientCrudService.save(any(ClientModel.class))).thenReturn(clientModel);

        ClientModel result = clientCrudUseCaseImpl.create(clientModel);

        assertNotNull(result);
        assertEquals("Juan Esteban", clientModel.getNombres());
    }

    @Test
    void givenClient_whenUpdateClient_thenCorrect() {
        ClientModel updateClientModel =  ClientModel.builder()
                .id(1L)
                .nombres("Juan Maria")
                .apellidoPaterno("Perez")
                .apellidoMaterno("Garcia")
                .documento("987654")
                .correo("jepg@gmail.com")
                .build();

        Mockito.when(clientCrudService.update(anyLong(), any(ClientModel.class))).thenReturn(updateClientModel);

        ClientModel result = clientCrudUseCaseImpl.update(1L, updateClientModel);

        assertNotNull(result);
        assertEquals("Juan Maria", result.getNombres());

        verify(clientCrudService, times(1)).update(1L, updateClientModel);
    }
}
