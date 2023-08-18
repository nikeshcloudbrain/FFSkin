package com.fffemote.dances.skins.ffdiamond.favourite;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ActorRepository {
    private ActorDatabase database;
    private LiveData<List<Actor>> getAllActors;

    public ActorRepository(Application application) {
        database = ActorDatabase.getInstance(application);
        getAllActors = database.actorDao().getAllActors();
    }

    public void insert(List<Actor> actorList) {
        new InsertAsynTask(database).execute(actorList);
    }

    public void delete(String name) {
        // new DeleteCourseAsyncTask(database).execute(actorList);
        database.actorDao().deleteById(name);
    }

    public LiveData<List<Actor>> getAllActors() {
        return getAllActors;
    }

    static class InsertAsynTask extends AsyncTask<List<Actor>, Void, Void> {
        private ActorDao actorDao;

        InsertAsynTask(ActorDatabase actorDatabase) {
            actorDao = actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(List<Actor>... lists) {
            actorDao.insert(lists[0]);
            return null;
        }
    }


    private static class DeleteCourseAsyncTask extends AsyncTask<Actor, Void, Void> {
        private ActorDao actorDao;

        DeleteCourseAsyncTask(ActorDatabase actorDatabase) {
            actorDao = actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(Actor... models) {
            // below line is use to delete
            // our course modal in dao.
            actorDao.delete(models[0]);
            return null;
        }
    }


}
