package com.hamburgerproject.burgerManager.dao;

import com.hamburgerproject.burgerManager.entity.BreadType;
import com.hamburgerproject.burgerManager.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);

    List<Burger> findAll();

    Burger findById(long id);

    Burger update(Burger burger);

    Burger remove(long id);

    List<Burger> findByPrice( Integer price);


    List<Burger> findByBreadType(BreadType breadType);

    List<Burger> findByContent(String content);



}
