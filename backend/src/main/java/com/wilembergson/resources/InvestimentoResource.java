package com.wilembergson.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wilembergson.domain.Investimento;
import com.wilembergson.repository.InvestimentoRepository;

@RestController
@RequestMapping("/investimentos")
@CrossOrigin(origins = "http://localhost:3000")
public class InvestimentoResource {

	@Autowired
	private InvestimentoRepository repository;
	
	@GetMapping
	public List<Investimento> listarTodos(){
		return repository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Investimento buscarPorCodigo(@PathVariable Long codigo) {
		return repository.findById(codigo).orElse(null);
	}
	
	@DeleteMapping("/{codigo}")
	public void remove(@PathVariable Long codigo) {
		repository.deleteById(codigo);
	}
	
	@PostMapping
	public Investimento cadastrar(@RequestBody Investimento investimento) {
		return repository.save(investimento);
	}
}
