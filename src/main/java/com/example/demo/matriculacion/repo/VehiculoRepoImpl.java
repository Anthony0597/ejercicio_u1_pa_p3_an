package com.example.demo.matriculacion.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matriculacion.modelo.Vehiculo;

@Repository
public class VehiculoRepoImpl implements IVehiculoRepo {

	private static List <Vehiculo> baseDatos = new ArrayList<>();
	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		baseDatos.add(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		for(Vehiculo v: baseDatos) {
			if(v.getPlaca().equals(placa)) {
				baseDatos.remove(v);
			}
		}
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo temp=null;
		for(Vehiculo v: baseDatos) {
			if(v.getPlaca().equals(placa)) {
				temp=v; 
			}
		}
		return temp;
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		Vehiculo temp=null;
		for(Vehiculo v: baseDatos) {
			if(v.getPlaca().equals(vehiculo.getPlaca())) {
				temp=v; 
			}
		}
		baseDatos.remove(temp);
		baseDatos.add(vehiculo);
	}

}
