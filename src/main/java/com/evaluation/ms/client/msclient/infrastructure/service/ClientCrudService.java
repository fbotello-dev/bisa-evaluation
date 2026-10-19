package com.evaluation.ms.client.msclient.infrastructure.service;

import com.evaluation.ms.client.msclient.domain.model.ClientModel;

import java.util.List;

public interface ClientCrudService {

    ClientModel save(ClientModel model);

    ClientModel update(Long id, ClientModel model);

    void delete(Long id);

    List<ClientModel> findAll();

    ClientModel findById(Long id);

}
