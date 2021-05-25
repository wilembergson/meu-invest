package com.wilembergson.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilembergson.domain.Categoria;
import com.wilembergson.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
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
	
	@DeleteMapping
	public void remove(@PathVariable Long codigo) {
		repository.deleteById(codigo);
	}
	
	@PostMapping
	public Categoria cadastrar(@RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
}
