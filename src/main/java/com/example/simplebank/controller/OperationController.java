package com.example.simplebank.controller;

import com.example.simplebank.model.OperationDetails;
import com.example.simplebank.service.OperationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-контроллер для основных операций со средствами на счете
 */
@RestController
@RequestMapping("/operations")
@AllArgsConstructor
public class OperationController {

    private OperationService operationService;

    @PutMapping("/{operationType}")
    public ResponseEntity<Object> execute(@PathVariable String operationType, @RequestBody OperationDetails operationDetails) {
        return operationService.execute(operationType, operationDetails);
    }


}
