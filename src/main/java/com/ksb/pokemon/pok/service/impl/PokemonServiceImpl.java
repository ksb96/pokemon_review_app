package com.ksb.pokemon.pok.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksb.pokemon.pok.dto.PokemonDto;
import com.ksb.pokemon.pok.models.Pokemon;
import com.ksb.pokemon.pok.repository.PokemonRepository;
import com.ksb.pokemon.pok.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService{
	private PokemonRepository pokemonRepository;
	
	@Autowired
	public PokemonServiceImpl(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	@Override
	public PokemonDto createPokemon(PokemonDto pokemonDto) {
		Pokemon pokemon = new Pokemon();
		pokemon.setName(pokemonDto.getName());
		pokemon.setType(pokemonDto.getType());
		
		Pokemon newPokemon = pokemonRepository.save(pokemon);
		
		PokemonDto pokemonResponse = new PokemonDto();
		pokemonResponse.setId(newPokemon.getId());
		pokemonResponse.setName(newPokemon.getName());
		pokemonResponse.setType(newPokemon.getType());
				
		return pokemonResponse;
	}

}
