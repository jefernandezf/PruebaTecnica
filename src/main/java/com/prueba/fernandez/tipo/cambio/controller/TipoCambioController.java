package com.prueba.fernandez.tipo.cambio.controller;


import com.prueba.fernandez.tipo.cambio.model.TipoCambio;
import com.prueba.fernandez.tipo.cambio.model.TipoCambioRequest;
import com.prueba.fernandez.tipo.cambio.model.TipoCambioResponse;
import com.prueba.fernandez.tipo.cambio.repository.TipoCambioRepository;
import com.prueba.fernandez.tipo.cambio.service.TipoCambioService;
import com.prueba.fernandez.tipo.cambio.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TipoCambioController {

    @Autowired
    TipoCambioService tipoCambioService;

    @PostMapping(value = "/actualizar")
    public ResponseEntity<TipoCambio> updateTipoCambio(@RequestBody TipoCambio tipoCambio) {
        Optional<TipoCambio> tipoCambio1 = tipoCambioService.findById(tipoCambio.getId());
        if (tipoCambio1.isPresent()) {
            TipoCambio tipCambio = tipoCambio1.get();
            tipCambio.setValor(tipoCambio.getValor());
            return new ResponseEntity<>(tipoCambioService.save(tipCambio), HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No existe tipo de cambio para actualizar"), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/convertir")
    public ResponseEntity<TipoCambioResponse> conversion(@RequestBody TipoCambioRequest tipoCambioRequest) {
        TipoCambioResponse conversionResult = tipoCambioService.convert(tipoCambioRequest);
        if (conversionResult != null) {
            return new ResponseEntity<TipoCambioResponse>(conversionResult, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No existe tipo de cambio para calcular"), HttpStatus.NOT_FOUND);
        }
    }
}