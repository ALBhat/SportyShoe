package com.simplilearn.SportyShoes.service;

import com.simplilearn.SportyShoes.model.Shoe;

import java.util.List;

public interface ShoeService {
    List<Shoe> getAllShoes();
    void saveShoes(Shoe shoes);
    Shoe getShoebyId(long id);
    void deleteShoeById(long id);
}
