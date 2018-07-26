package app;

import java.util.ArrayList;
import java.util.List;

import app.Movie;

public class User {
	// Return the list of users who are the current's user direct friends.
	public List<User> getFriends() {
		return new ArrayList<User>();
	};

	// Return a list of movies that the user has watched.
	public List<Movie> getMoviesWatched() {
		return new ArrayList<Movie>();
	};
}