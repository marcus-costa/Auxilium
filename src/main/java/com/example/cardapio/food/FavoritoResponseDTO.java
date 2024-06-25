package com.example.cardapio.food;

public record FavoritoResponseDTO(Long id, String nome, String image, String url, String descri) {
    public FavoritoResponseDTO(Favorito favorito){
        this(favorito.getId(), favorito.getNome(), favorito.getImage(), favorito.getUrl(), favorito.getDescri());
    }
}
