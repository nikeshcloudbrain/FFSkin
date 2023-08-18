package com.fffemote.dances.skins.ffdiamond.favourite;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ActorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Actor> actorList);


    @Delete
    void delete(Actor model);

    @Query("DELETE FROM actor WHERE name = :name")
    void deleteById(String name);

    @Query("SELECT * FROM actor")
    LiveData<List<Actor>> getAllActors();

    @Query("DELETE FROM actor")
    void deleteAll();
}
