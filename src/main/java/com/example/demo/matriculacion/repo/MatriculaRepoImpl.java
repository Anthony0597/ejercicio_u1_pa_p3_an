package com.example.demo.matriculacion.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matriculacion.modelo.Matricula;

@Repository
public class MatriculaRepoImpl implements IMatriculaRepo {

	private static List<Matricula> baseDatos = new ArrayList<>();
	@Override
	public void insestar(Matricula matricula) {
		// TODO Auto-generated method stub
		baseDatos.add(matricula);
	}

	@Override
	public Matricula buscar(String placa) {
		// TODO Auto-generated method stub
		Matricula temp = null;
		for(Matricula m : baseDatos) {
			if(m.getVehiculo().getPlaca().equals(placa)) {
				temp = m;
			}
		}
		return temp;
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		for(Matricula m : baseDatos) {
			if(m.getVehiculo().getPlaca().equals(placa)) {
				baseDatos.remove(m);
			}
		}
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		Matricula temp = null;
		for(Matricula m : baseDatos) {
			if(m.equals(matricula)) {
				temp = m;
			}
		}
		baseDatos.remove(temp);
		baseDatos.add(matricula);
	}

}
