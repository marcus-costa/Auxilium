package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Favorito;
import com.example.cardapio.food.FavoritoRepository;
import com.example.cardapio.food.FavoritoRequestDTO;
import com.example.cardapio.food.FavoritoResponseDTO;
// * importa todo o pacote
//import com.example.cardapio.food.*;
@RestController
@RequestMapping("favorito")


public class FavoritoController {
	@Autowired
    private FavoritoRepository repository;
	
	  @CrossOrigin(origins = "*", allowedHeaders = "*")
	    @PostMapping
	    
	    public void saveFavorito(@RequestBody FavoritoRequestDTO data){
	        Favorito favoritoData = new Favorito(data);
	        repository.save(favoritoData);
	    }
		public void removeFavorito(@RequestBody FavoritoRequestDTO data, long id1){
			repository.deleteById(id1);
		}
		public void editFavorito(@RequestBody FavoritoRequestDTO data, long id1){
			repository.deleteById(id1);
			Favorito favoritoData = new Favorito(data);
			repository.save(favoritoData);
		}
	        @CrossOrigin(origins = "*", allowedHeaders = "*")
	        @GetMapping
	        public List<FavoritoResponseDTO> getAll(){
	            List<FavoritoResponseDTO> favoritoList = repository.findAll().stream().map(FavoritoResponseDTO::new).toList();
	            return favoritoList;
	        
	    }

}
