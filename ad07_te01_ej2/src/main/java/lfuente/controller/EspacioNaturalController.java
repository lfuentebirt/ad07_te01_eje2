package lfuente.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lfuente.domain.EspacioNatural;
import lfuente.repository.EspacioNaturalRepository;



// para si lo utilizamos con la APP de Angular
@CrossOrigin (origins= {"http://localhost:4201"})
//@CrossOrigin(origins = "*", allowedHeaders = "*")
// es un REST controller de la clase entidad EspacioNatural
@RestController
@RequestMapping("/api")
public class EspacioNaturalController {
	@Autowired
	EspacioNaturalRepository espacioNaturalRepository;
	
	// 1 - Endpoint de los espacios naturales (principal)
	@GetMapping("/espaciosnaturales")
	public ResponseEntity<List<EspacioNatural>> index() {
	    try {
	        List<EspacioNatural> espaciosNaturales = espacioNaturalRepository.findAll();
	        return new ResponseEntity<List<EspacioNatural>>(espaciosNaturales, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<EspacioNatural>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	// 2 - Endpoint tipos naturales (tipo de espacio natural)
	@GetMapping("/naturetype")
	public ResponseEntity<List<String>> getAllNatureTypes() {
	    try {
	    	// obtenemos todos los espacios naturales y de ellos, obtenemos los tipos distintos
	        List<EspacioNatural> espaciosNaturales = espacioNaturalRepository.findAll();
	        Set<String> tiposNaturalesDistintos = new HashSet<>();
	        // recorremos los espacios naturales para obtener los tipos
	        for (EspacioNatural espacio : espaciosNaturales) {
	        	tiposNaturalesDistintos.add(espacio.getProperties().getNaturetype());
	        }
	        // ordenamos los tipos
	        List<String> tiposNaturalesOrdenados = new ArrayList<>(tiposNaturalesDistintos);
	        Collections.sort(tiposNaturalesOrdenados);
	        // devolvemos los tipos
	        return new ResponseEntity<List<String>>(tiposNaturalesOrdenados, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// 3 - Endpoint municipio
	@GetMapping("/municipality")
	public ResponseEntity<List<String>> getAllMunicipality() {
	    try {
	    	// obtenemos todos los espacios naturales
	        List<EspacioNatural> espaciosNaturales = espacioNaturalRepository.findAll();
	        Set<String> municipiosNaturalesDistintos = new HashSet<>();
	        // recorremos los espacios naturales para obtener los municipios
	        for (EspacioNatural espacio : espaciosNaturales) {
	        	municipiosNaturalesDistintos.add(espacio.getProperties().getMunicipality());
	        }
	        // ordenamos 
	        List<String> municipiosNaturalesOrdenados = new ArrayList<>(municipiosNaturalesDistintos);
	        Collections.sort(municipiosNaturalesOrdenados);
	        // devolvemos los municipios
	        return new ResponseEntity<List<String>>(municipiosNaturalesOrdenados, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// 4 - Endpoint marcas
	@GetMapping("/marks")
	public ResponseEntity<List<String>> getAllMarks() {
	    try {
	    	// obtenemos todos los espacios naturales
	        List<EspacioNatural> espaciosNaturales = espacioNaturalRepository.findAll();
	        Set<String> marcasNaturalesDistintas = new HashSet<>();
	        // recorremos los espacios naturales para obtener las marcas
	        for (EspacioNatural espacio : espaciosNaturales) {
	        	marcasNaturalesDistintas.add(espacio.getProperties().getMarks());
	        }
	        // ordenamos 
	        List<String> marcasNaturalesOrdenadas = new ArrayList<>(marcasNaturalesDistintas);
	        Collections.sort(marcasNaturalesOrdenadas);
	        // devolvemos las marcas
	        return new ResponseEntity<List<String>>(marcasNaturalesOrdenadas, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
		
}
