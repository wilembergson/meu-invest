package com.wilembergson.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wilembergson.domain.Categoria;
import com.wilembergson.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public List<Categoria> listarTodos(){
		return repository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Long codigo) {
		return repository.findById(codigo).orElse(null);
	}
	
	@DeleteMapping("/{codigo}")
	public void remove(@PathVariable Long codigo) {
		repository.deleteById(codigo);
	}
	
	@PostMapping
	public Categoria cadastrar(@RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
}
