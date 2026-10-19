package com.evaluation.ms.client.msclient.infrastructure.service.impl;


import com.evaluation.ms.client.msclient.domain.exception.BusinessApiException;
import com.evaluation.ms.client.msclient.domain.model.ClientModel;
import com.evaluation.ms.client.msclient.infrastructure.persistence.entity.Client;
import com.evaluation.ms.client.msclient.infrastructure.persistence.repository.ClientRepository;
import com.evaluation.ms.client.msclient.infrastructure.service.ClientCrudService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCrudServiceImpl implements ClientCrudService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientCrudServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientModel save(ClientModel client) {
        Client clientResponse = clientRepository.save(modelMapper.map(client, Client.class));
        return modelMapper.map(clientResponse, ClientModel.class);
    }

    @Override
    public ClientModel update(Long id, ClientModel client) {
        Client clientExist = clientRepository.findById(id)
                .orElseThrow(() -> new BusinessApiException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        modelMapper.map(client, clientExist);
        return modelMapper.map(clientRepository.save(clientExist), ClientModel.class);
    }

    @Override
    public void delete(Long id) {
        if (clientRepository.existsById(id))
            throw new BusinessApiException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientModel> findAll() {
        return clientRepository.findAll().stream().map(c -> modelMapper.map(c, ClientModel.class)).toList();
    }

    @Override
    public ClientModel findById(Long id) {
        return modelMapper.map(clientRepository.findById(id), ClientModel.class);
    }
}
