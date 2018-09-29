package xyz.godi.popularmovies.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import xyz.godi.popularmovies.model.Movie;

/**
 * Movie database class used to store favorite movie data
 */
@Database(entities = {Movie.class}, version = 1)
public abstract class MovieDataBase extends RoomDatabase {

    private static volatile MovieDataBase INSTANCE;

    public static MovieDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDataBase.class,"movie_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract MovieDAO movieDAO();
}