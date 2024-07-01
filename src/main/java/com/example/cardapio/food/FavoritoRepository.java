package com.example.cardapio.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  FavoritoRepository extends JpaRepository<Favorito, Long> {

    @Query("SELECT f FROM favoritos f WHERE f.url = :url")
    Favorito findByUrl(String url);
}
