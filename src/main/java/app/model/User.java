package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import app.Movie;

public class User {

	// Initiate some sample data
	public static final Integer SAMPLE_SIZE = 10;
	public String username;
	public List<User> friendList = new ArrayList<User>();
	public List<Movie> sampleMovies = new ArrayList<Movie>();
	public Map<String, Movie> moviesWatchedMap = new HashMap<String, Movie>();

	public void init() {
		setFriends();
		setSampleMovies();
		setSampleMovieWatched();
	}

	// Set some dummy data
	public void setFriends() {

		this.friendList.add(new User("Abu"));
		this.friendList.add(new User("Ahmad"));
		this.friendList.add(new User("Cheong Mun"));
		this.friendList.add(new User("David"));
		this.friendList.add(new User("Ellen"));
		this.friendList.add(new User("Farida"));
		this.friendList.add(new User("Gregor"));
		this.friendList.add(new User("Haris"));
		this.friendList.add(new User("Iris"));
		this.friendList.add(new User("James"));
		this.friendList.add(new User("Kelvin"));
		this.friendList.add(new User("Louis"));

	};

	// Set some dummy data
	public void setSampleMovies() {
		this.sampleMovies.add(new Movie("Iron Man"));
		this.sampleMovies.add(new Movie("The Incredible Hulk"));
		this.sampleMovies.add(new Movie("Iron Man 2"));
		this.sampleMovies.add(new Movie("Thor"));
		this.sampleMovies.add(new Movie("Captain America: The First Avenger"));
		this.sampleMovies.add(new Movie("Marvel\'s The Avengers"));
		this.sampleMovies.add(new Movie("Iron Man 3"));
		this.sampleMovies.add(new Movie("Thor: The Dark World"));
		this.sampleMovies.add(new Movie("Captain America: The Winter Soldier"));
		this.sampleMovies.add(new Movie("Guardians of the Galaxy"));
		this.sampleMovies.add(new Movie("Avengers: Age of Ultron"));
		this.sampleMovies.add(new Movie("Ant-Man"));
		this.sampleMovies.add(new Movie("Captain America: Civil War"));
		this.sampleMovies.add(new Movie("Doctor Strange"));
		this.sampleMovies.add(new Movie("Guardians of the Galaxy Vol. 2"));
		this.sampleMovies.add(new Movie("Spider-Man: Homecoming"));
		this.sampleMovies.add(new Movie("Thor: Ragnarok"));
		this.sampleMovies.add(new Movie("Black Panther"));
		this.sampleMovies.add(new Movie("Avengers: Infinity War"));
		this.sampleMovies.add(new Movie("Ant-Man and the Wasp"));
	};

	public void setSampleMovieWatched() {
		Random rand = new Random();

		for(int i = 0; i < rand.nextInt(SAMPLE_SIZE); i++) {
			this.moviesWatchedMap.put(
				friendList.get(rand.nextInt(friendList.size())), 
				sampleMovies.get(rand.nextInt(sampleMovies.size()))
			);
		}
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Return the list of users who are the current"s user direct friends.
	public List<User> getFriends() {
		return friendList;
	};

	// Return a list of movies that the user has watched.
	public List<Movie> getMoviesWatched() {
		List<Movie> movieList = new ArrayList<Movie>();

		for(int i = 0; i < moviesWatchedMap.size(); i++) {
			movieList.add()
		}

		return movieList;
	};
}