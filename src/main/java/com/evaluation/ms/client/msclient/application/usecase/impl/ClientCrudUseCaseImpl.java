package com.evaluation.ms.client.msclient.application.usecase.impl;


import com.evaluation.ms.client.msclient.application.usecase.ClientCrudUseCase;
import com.evaluation.ms.client.msclient.domain.model.ClientModel;
import com.evaluation.ms.client.msclient.infrastructure.service.ClientCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientCrudUseCaseImpl implements ClientCrudUseCase {
    private final ClientCrudService clientCrudService;

    @Override
    public ClientModel create(ClientModel client) {

        return clientCrudService.save(client);
    }

    @Override
    public ClientModel update(Long id, ClientModel client) {
        return clientCrudService.update(id, client);
    }

    @Override
    public void delete(Long id) {
        clientCrudService.delete(id);
    }

    @Override
    public List<ClientModel> findAll() {
        return clientCrudService.findAll();
    }

    @Override
    public ClientModel findById(Long id) {
        return clientCrudService.findById(id);
    }
}
