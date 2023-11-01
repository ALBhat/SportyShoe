package com.simplilearn.SportyShoes.service;

import com.simplilearn.SportyShoes.model.Shoe;
import com.simplilearn.SportyShoes.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoeServiceImpl implements ShoeService{
    @Autowired
    private ShoeRepository shoerepository;
    @Override
    public List<Shoe> getAllShoes() {
        return shoerepository.findAll();
    }

    @Override
    public void saveShoes(Shoe shoes) {
        shoerepository.save(shoes);
    }

    @Override
    public Shoe getShoebyId(long id) {
        if(!shoerepository.existsById(id))
        {
            throw new RuntimeException("Shoe Not Found for id :: " +id);
        }
        return shoerepository.findById(id).get();
    }

    @Override
    public void deleteShoeById(long id) {
        shoerepository.deleteById(id);
    }
}
