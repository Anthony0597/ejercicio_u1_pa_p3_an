package com.example.demo.matriculacion.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matriculacion.modelo.Propietario;

@Repository
public class PropietarioRepoImpl implements IPropietarioRepo {

	private static List<Propietario> baseDatos = new ArrayList<>();
	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		baseDatos.add(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		for(Propietario p : baseDatos) {
			if(p.getCedula().equals(cedula)) {
				baseDatos.remove(p);
			}
		}
	}

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		Propietario temp=null;
		for(Propietario p: baseDatos) {
			if(p.getCedula().equals(cedula)) {
				temp=p; 
			}
		}
		return temp;
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		Propietario temp=null;
		for(Propietario p: baseDatos) {
			if(p.getCedula().equals(propietario.getCedula())) {
				temp=p; 
			}
		}
		baseDatos.remove(temp);
		baseDatos.add(propietario);
	}

}
