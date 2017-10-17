/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.dao;

/**
 *
 * @author Hansome
 */
public interface Dao {
    
    public void save(Object object);
    public void update(Object object);
    public void delete(Object object);
    public void getAllData(Object object);
   
}
