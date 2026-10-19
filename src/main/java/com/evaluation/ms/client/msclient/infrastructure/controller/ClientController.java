package com.evaluation.ms.client.msclient.infrastructure.controller;

import com.evaluation.ms.client.msclient.application.usecase.ClientCrudUseCase;
import com.evaluation.ms.client.msclient.domain.model.ClientModel;
import com.evaluation.ms.client.msclient.infrastructure.controller.dto.RequestClientDTO;
import com.evaluation.ms.client.msclient.infrastructure.controller.dto.ResponseClientDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor
public class ClientController {
    private final ModelMapper modelMapper;
    private final ClientCrudUseCase clientCrudUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseClientDTO create (@RequestBody @Valid RequestClientDTO client){
        ClientModel clientModel = clientCrudUseCase.create(modelMapper.map(client, ClientModel.class));
        return modelMapper.map(clientModel, ResponseClientDTO.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseClientDTO update (@PathVariable Long id, @RequestBody @Valid RequestClientDTO student) {
        ClientModel studentModel = clientCrudUseCase.update(id, modelMapper.map(student, ClientModel.class));
        return modelMapper.map(studentModel, ResponseClientDTO.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete (@PathVariable Long id) {
        clientCrudUseCase.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseClientDTO> finAll(){
        return clientCrudUseCase.findAll().stream().map(s -> modelMapper.map(s, ResponseClientDTO.class)).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseClientDTO finById(@PathVariable Long id) {
        return modelMapper.map(clientCrudUseCase.findById(id), ResponseClientDTO.class);
    }


}
