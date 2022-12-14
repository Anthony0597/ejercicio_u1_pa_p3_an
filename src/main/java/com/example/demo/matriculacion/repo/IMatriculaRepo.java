package com.example.demo.matriculacion.repo;

import com.example.demo.matriculacion.modelo.Matricula;

public interface IMatriculaRepo {
	//CRUD
	public void insestar(Matricula matricula);
	public Matricula buscar(String placa);
	public void eliminar(String placa);
	public void actualizar(Matricula matricula);
}
