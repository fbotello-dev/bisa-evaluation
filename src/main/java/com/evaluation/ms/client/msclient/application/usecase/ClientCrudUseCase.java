package com.evaluation.ms.client.msclient.application.usecase;

import com.evaluation.ms.client.msclient.domain.model.ClientModel;

import java.util.List;

public interface ClientCrudUseCase {
    ClientModel create(ClientModel model);

    ClientModel update(Long id ,ClientModel model);

    void delete(Long id);

    List<ClientModel> findAll();

    ClientModel findById(Long id);
}
