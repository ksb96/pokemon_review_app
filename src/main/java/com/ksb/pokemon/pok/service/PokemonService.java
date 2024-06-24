package com.ksb.pokemon.pok.service;

import java.util.List;

import com.ksb.pokemon.pok.dto.PokemonDto;

public interface PokemonService {

	//POST
	PokemonDto createPokemon(PokemonDto pokemonDto);
	
	//GET ALL
	List<PokemonDto> getAllPokemon();
	
	//GET BY ID
	PokemonDto getPokemonById(int id);
	
	//UPDATE BY ID
	PokemonDto updatePokemon(PokemonDto pokemonDto, int id);
}
