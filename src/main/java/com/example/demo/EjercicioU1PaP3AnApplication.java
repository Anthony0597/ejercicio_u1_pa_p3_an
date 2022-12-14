package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.matriculacion.modelo.Propietario;
import com.example.demo.matriculacion.modelo.Vehiculo;
import com.example.demo.matriculacion.service.IMatriculaService;
import com.example.demo.matriculacion.service.IPropietarioService;
import com.example.demo.matriculacion.service.IVehiculoService;

@SpringBootApplication
public class EjercicioU1PaP3AnApplication implements CommandLineRunner{

	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private IMatriculaService matriculaService;
	
	public static void main(String[] args){
		SpringApplication.run(EjercicioU1PaP3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Toyota");
		vehiculo.setPlaca("PDF-4587");
		vehiculo.setTipo("liviano");
		vehiculo.setPrecio(new BigDecimal(19000));
		this.vehiculoService.crear(vehiculo);
		vehiculo.setPrecio(new BigDecimal(18500));
		vehiculo.setPlaca("PDF-791");
		this.vehiculoService.actualizar(vehiculo);
		
		Propietario propietario = new Propietario();
		propietario.setNombre("Mauricio");
		propietario.setApellido("Cacuango");
		propietario.setCedula("1789452675");
		propietario.setfNacimiento(LocalDateTime.of(1999, 7, 12, 9, 30));
		this.propietarioService.crear(propietario);
		
		this.matriculaService.registrar(propietario.getCedula(), vehiculo.getPlaca());
	}

}
