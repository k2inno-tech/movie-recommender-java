package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.lang.String;

import app.model.Movie;

public class User {

	// Initiate some sample data
	public static final Integer SAMPLE_SIZE = 300;
	public String name;
	public List<User> friendList = new ArrayList<User>();
	public Map<String, Movie> moviesWatchedMap = new HashMap<String, Movie>();

	public void seedSampleData() {
		// Seed sample data
		setSampleFriends();
		setSampleMovieWatched();
	}

	// Set some dummy data
	public void setSampleFriends() {

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

	public List<Movie> getSampleMovies() {
		Movie movie = new Movie("sample");
		movie.init();
		return movie.getSampleMovies();
	}

	public void setSampleMovieWatched() {
		Random rand = new Random();

		List<Movie> sampleMovies = getSampleMovies();

		for(int i = 0; i < rand.nextInt(SAMPLE_SIZE); i++) {
			Movie watchedMovie = sampleMovies.get(rand.nextInt(sampleMovies.size()));
			String userWatchedMovieKey = getUserMovieWatchedKey(friendList.get(rand.nextInt(friendList.size())), watchedMovie);

			//System.out.println("SampleMovieWatched: " + userWatchedMovieKey);

			this.moviesWatchedMap.put(userWatchedMovieKey, watchedMovie);

		}
	}

	public void setUserFriends() {
		List<User> friends = this.getFriends();
		for(User friend : friends) {
			friend.seedSampleData();

			List<User> friend_friends = friend.getFriends();
			for(User friend_friend : friend_friends) {
				friend_friend.seedSampleData();
			}
		}
	}

	public String getUserMovieWatchedKey(User user, Movie movie) {
		return user.getName() + "~" + movie.getTitle();
	}

	public String getUserNameFromKey(String key) {
		try {
			String[] parts = key.split("~", 2);
			return parts[0];
		} catch (Exception ex) {
			return null;
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

		for (Map.Entry<String, Movie> entry : moviesWatchedMap.entrySet()) {
			String key = entry.getKey();
			String watchedUserName = getUserNameFromKey(key);

			Movie movie = entry.getValue();
			if(name.equals(watchedUserName)) {
				movieList.add(movie);
			}
		}

		return movieList;
	};
}