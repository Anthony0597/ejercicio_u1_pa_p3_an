package com.example.demo.matriculacion.repo;

import com.example.demo.matriculacion.modelo.Vehiculo;

public interface IVehiculoRepo {
	//CRUD
	public void insertar(Vehiculo vehiculo);
	public void eliminar(String placa);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo vehiculo);
}
