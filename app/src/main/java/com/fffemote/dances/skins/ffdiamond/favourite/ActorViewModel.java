package com.fffemote.dances.skins.ffdiamond.favourite;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ActorViewModel extends AndroidViewModel {

    private ActorRepository actorRespository;
    private LiveData<List<Actor>> getAllActors;

    public ActorViewModel(@NonNull Application application) {
        super(application);
        actorRespository=new ActorRepository(application);
        getAllActors=actorRespository.getAllActors();
    }

    public void insert(List<Actor> list)
    {
        actorRespository.insert(list);
    }

    public void delete(String name)
    {
        actorRespository.delete(name);
    }

    public LiveData<List<Actor>> getAllActor()
    {
        return getAllActors;
    }

}
