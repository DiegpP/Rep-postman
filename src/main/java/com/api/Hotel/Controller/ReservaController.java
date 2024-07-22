package com.api.Hotel.Controller;

import com.api.Hotel.Model.Reserva;
import com.api.Hotel.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService serviceR;

    //GET
    @GetMapping
    public List<Reserva> listarTodo(){
        return  serviceR.getAllReservas();
    }

    //POST
    @PostMapping
    public Reserva crear(@RequestBody Reserva reserva){
        return serviceR.createReserva(reserva);
    }

    //PUT
    @PostMapping("editar/{id}")
    public Reserva actualizar(@RequestBody Reserva reserva, @PathVariable Long id){
        reserva.setIdReserva(id);
        return serviceR.updateReserva(reserva);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        serviceR.deleteReservaById(id);
    }
}