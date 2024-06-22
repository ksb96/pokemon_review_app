package com.ksb.pokemon.pok.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ksb.pokemon.pok.models.Pokemon;

@RestController
@RequestMapping("/api/")
public class PokemonController {

	@GetMapping("pokemon")
	public ResponseEntity<List<Pokemon>> getPokemons(){
		List<Pokemon> pokemons = new ArrayList<>();
		//adding
		pokemons.add(new Pokemon(1,"pikachu","electric"));
		pokemons.add(new Pokemon(2,"charmander","fire"));
		pokemons.add(new Pokemon(3,"squirtle","water"));
		
		return ResponseEntity.ok(pokemons);
	}
	
	@GetMapping("pokemon/{id}")
	public Pokemon pokemonDetail(@PathVariable int id) {
		return new Pokemon(id, "gasly", "ghost");
	}
	
	@PostMapping("pokemon/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pokemon> creratePokemon(@RequestBody Pokemon pokemon){
		return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
	}
	
	@PutMapping("pokemon/{id}/update")
	public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") int pokemonId){
		return ResponseEntity.ok(pokemon);
	}
	
	@DeleteMapping("pokemon/{id}/delete")
	public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){
		return ResponseEntity.ok("Pokemon deleted successfully");
	}
}
