package com.example.demo.matriculacion.repo;

import com.example.demo.matriculacion.modelo.Propietario;

public interface IPropietarioRepo {
	public void insertar(Propietario propietario);
	public void eliminar(String cedula);
	public Propietario buscar(String cedula);
	public void actualizar(Propietario propietario);
}
