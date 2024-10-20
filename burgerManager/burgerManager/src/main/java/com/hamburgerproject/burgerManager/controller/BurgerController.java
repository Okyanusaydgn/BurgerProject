package com.hamburgerproject.burgerManager.controller;

import com.hamburgerproject.burgerManager.dao.BurgerDao;
import com.hamburgerproject.burgerManager.entity.BreadType;
import com.hamburgerproject.burgerManager.entity.Burger;
import com.hamburgerproject.burgerManager.util.BurgerValidation;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

// @CrossOrigin("*") // Tüm kaynaklardan gelen istekleri kabul eder. Güvenlik açısından biraz problem yaratır, bilgin olsun !!!
// @CrossOrigin(origins = "http://example.com") // Sadece example.com'dan gelen istekleri kabul eder

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable long id) {
        return burgerDao.findById(id);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id){
        return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBread(@PathVariable String breadType){
        BreadType bt = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(bt);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByPrice(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }

}
