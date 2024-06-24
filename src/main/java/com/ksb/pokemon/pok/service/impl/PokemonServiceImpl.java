package com.ksb.pokemon.pok.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksb.pokemon.pok.dto.PokemonDto;
import com.ksb.pokemon.pok.exception.PokemonNotFoundException;
import com.ksb.pokemon.pok.models.Pokemon;
import com.ksb.pokemon.pok.repository.PokemonRepository;
import com.ksb.pokemon.pok.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {
	private PokemonRepository pokemonRepository;

	@Autowired
	public PokemonServiceImpl(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	@Override
	// POST
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

	@Override
	// GET ALL
	public List<PokemonDto> getAllPokemon() {
		List<Pokemon> pokemon = pokemonRepository.findAll();
		return pokemon.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
	}

	private PokemonDto mapToDto(Pokemon pokemon) {
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setId(pokemon.getId());
		pokemonDto.setName(pokemon.getName());
		pokemonDto.setType(pokemon.getType());

		return pokemonDto;
	}

	private Pokemon mapToEntity(PokemonDto pokemonDto) {
		Pokemon pokemon = new Pokemon();
		pokemon.setName(pokemonDto.getName());
		pokemon.setType(pokemonDto.getType());

		return pokemon;
	}

	@Override
	// GET BY ID
	public PokemonDto getPokemonById(int id) {
		Pokemon pokemon = pokemonRepository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException("Pokemon not found!!"));
		return mapToDto(pokemon);
	}

	@Override
	// UPDATE BY ID
	public PokemonDto updatePokemon(PokemonDto pokemonDto, int id) {
		Pokemon pokemon = pokemonRepository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException("Pokemon not found, so its not updated!!"));
		pokemon.setName(pokemonDto.getName());
		pokemon.setType(pokemonDto.getType());

		Pokemon updatePokemon = pokemonRepository.save(pokemon);

		return mapToDto(updatePokemon);
	}

}
