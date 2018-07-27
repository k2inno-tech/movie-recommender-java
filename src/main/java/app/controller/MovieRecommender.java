package app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import app.model.Movie;
import app.model.User;

public class MovieRecommender {	

	public List<String> recommendMovies(User user, int returnCount) {
		// Implementation here

		List<Movie> countingMovies = new ArrayList<Movie>();
		List<User> friends = user.getFriends();
		for(User friend : friends) {

			//System.out.println("MovieRecommender Friend: " + friend.getName());

			friend.seedSampleData();

			countingMovies.addAll(friend.getMoviesWatched());

			List<User> friend_friends = friend.getFriends();
			for(User friend_friend : friend_friends) {
				friend_friend.seedSampleData();
				countingMovies.addAll(friend_friend.getMoviesWatched());
			}
		}

		Map<String, Integer> movieWatchedCount = new HashMap<String, Integer>();

		for(Movie movie : countingMovies) {
			if(movieWatchedCount.get(movie.getTitle()) == null) {
				movieWatchedCount.put(movie.getTitle(), 1);
			} else {
				System.out.println(movie.getTitle() + " - Trigger more than 1");
				Integer currentCount = movieWatchedCount.get(movie.getTitle()) + 1;
				movieWatchedCount.put(movie.getTitle(), currentCount);
			}
		}

		ArrayList<String> recommendedMovies = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : movieWatchedCount.entrySet()) {
			String movieTitle = entry.getKey();
			Integer watchedCount = entry.getValue();

			System.out.println(movieTitle + ": " + watchedCount);

			if(watchedCount >= returnCount) {
				recommendedMovies.add(movieTitle);
			}
		}

		System.out.println("===== Recommended Movies =====");
		for(String out : recommendedMovies) {
			System.out.println(out);	
		}

		return recommendedMovies;
	}


}