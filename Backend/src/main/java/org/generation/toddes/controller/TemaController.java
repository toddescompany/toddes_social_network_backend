package org.generation.toddes.controller;

import java.util.List;

import org.generation.toddes.model.Tema;
import org.generation.toddes.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class TemaController {
	@Autowired
	private TemaRepository tb_tema_from_db;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll()
	{
		return ResponseEntity.ok(tb_tema_from_db.findAll());
	}
	
	@GetMapping("/{idTema}")
	public ResponseEntity<Tema> getById(@PathVariable long idTema)
	{
		return tb_tema_from_db.findById(idTema).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nometema/{nomeTema}")
	public ResponseEntity<List<Tema>> getByNomeTema(@PathVariable String nomeTema)
	{
		return ResponseEntity.ok(tb_tema_from_db.findAllByNomeTemaContainingIgnoreCase(nomeTema));
	}
	
	//funcionando perfeitamente

	@PostMapping
	public ResponseEntity<Tema> postTema(@RequestBody Tema json_tema)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(tb_tema_from_db.save(json_tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema json_tema)
	{
		return ResponseEntity.status(HttpStatus.OK).body(tb_tema_from_db.save(json_tema));
	}
	
	@DeleteMapping("/{idTema}")
	public void deleteTema(@PathVariable long idTema)
	{
		tb_tema_from_db.deleteById(idTema);
	}
	
}
