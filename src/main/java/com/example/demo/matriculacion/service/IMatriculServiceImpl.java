package com.example.demo.matriculacion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matriculacion.modelo.Matricula;
import com.example.demo.matriculacion.modelo.Vehiculo;
import com.example.demo.matriculacion.repo.IMatriculaRepo;

@Service
public class IMatriculServiceImpl implements IMatriculaService {

	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private IMatriculaRepo matriculaRepo;
	
	@Override
	public void registrar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Matricula matricula = new Matricula();
		matricula.setFecha(LocalDateTime.now());
		matricula.setPropietario(this.propietarioService.buscar(cedula));
		matricula.setVehiculo(this.vehiculoService.buscar(placa));
		matricula.setValor(this.calcularValor(this.vehiculoService.buscar(placa)));
		this.matriculaRepo.insestar(matricula);
		System.out.println("Se registro la matricula:"+this.matriculaRepo.buscar(placa));
	}
	
	private BigDecimal calcularValor(Vehiculo vehiculo){
		BigDecimal valor = null;
		if(vehiculo.getTipo().equals("liviano")) {
			valor = vehiculo.getPrecio().multiply(new BigDecimal(0.1));
		}else if (vehiculo.getTipo().equals("pesado")) {
			valor = vehiculo.getPrecio().multiply(new BigDecimal(0.15));
		}
		
		if(valor.compareTo(new BigDecimal(2000))==1) {
			valor = valor.subtract(valor.multiply(new BigDecimal(0.07)));
		}
		return valor;
	}

}
