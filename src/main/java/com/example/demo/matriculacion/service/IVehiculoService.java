package com.example.demo.matriculacion.service;

import com.example.demo.matriculacion.modelo.Vehiculo;

public interface IVehiculoService {
	public void crear(Vehiculo vehiculo);
	public void eliminar(String placa);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo vehiculo);
}
