package com.hamburgerproject.burgerManager.dao;

import com.hamburgerproject.burgerManager.entity.BreadType;
import com.hamburgerproject.burgerManager.entity.Burger;
import com.hamburgerproject.burgerManager.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao {

    private final EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    // Transactional anatasyonu ; eğer bir işlem başarılı olarak tamamlanır ise veritabanına kalıcı olarak kaydeder ama bir hata olur ise rollback yeni işlemi geri alır.
    // EntityManager JPA nın ana bileşenlerinden biridir ve veritabanına etkileşime geçmek için kullanılır. Veritabanını yönetimini sağlar.
    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger); // persist -- yeni bir kaydı veritabanına ekler.
        return burger;
    }


    // TypedQuery --- JPA Query API kullanarak veritabanında veri sorgulamak için kullanılır.
    // createQuery --- JPQL formatında veritabanın da sorgulama yapar.
    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> foundAll = entityManager.createQuery("SELECT b FROM Burger b",Burger.class);
        return foundAll.getResultList();
    }

    @Override
    public Burger findById(long id) {
        Burger burger = entityManager.find(Burger.class,id);
        if (burger == null){
            throw new BurgerException("Burger with given id is not exist: "+id, HttpStatus.NOT_FOUND);
        }
        return burger;
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger); // merge --- var olan bir kaydı günceller.
    }

    @Transactional
    @Override
    public Burger remove(long id) {
        Burger foundBurger = findById(id);
        entityManager.remove(foundBurger);
        return foundBurger;
    }

    @Override
    public List<Burger> findByPrice(Integer price) {
        TypedQuery<Burger> foundListQuery = entityManager.createQuery("SELECT b FROM Burger b where b.price > :price ORDER BY b.price desc", Burger.class);
        foundListQuery.setParameter("price",price);
        return foundListQuery.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b where b.breadType = :breadType ORDER BY b.name desc", Burger.class);
        query.setParameter("breadType",breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b where b.contents like CONCAT('%', :content,'%') ORDER BY b.name", Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }
}
