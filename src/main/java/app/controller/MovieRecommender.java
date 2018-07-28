package app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import app.model.Movie;
import app.model.User;

public class MovieRecommender {	

	public List<String> recommendMovies(User user, int returnCount) {
		// Implementation here

		Map<String, Integer> sortedMovieWatchedCount = doUserMovieCounting(user);

		ArrayList<String> recommendedMovies = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : sortedMovieWatchedCount.entrySet()) {
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

	public Map<String, Integer> doUserMovieCounting(User user) {
		List<Movie> countingMovies = getMovieWatchedCountingList(user);
		Map<String, Integer> movieWatchedCount = getMovieWatchedCountMap(countingMovies);
		return sortByValue(movieWatchedCount);
	}

	private List<Movie> getMovieWatchedCountingList(User user) {
		List<Movie> countingMovies = new ArrayList<Movie>();
		List<User> friends = user.getFriends();

		for(User friend : friends) {
			countingMovies.addAll(friend.getMoviesWatched());

			List<User> friend_friends = friend.getFriends();
			for(User friend_friend : friend_friends) {
				countingMovies.addAll(friend_friend.getMoviesWatched());
			}
		}

		return countingMovies;
	}

	private Map<String, Integer> getMovieWatchedCountMap(List<Movie> countingMovies) {
		Map<String, Integer> movieWatchedCount = new HashMap<String, Integer>();

		for(Movie movie : countingMovies) {
			if(movieWatchedCount.get(movie.getTitle()) == null) {
				movieWatchedCount.put(movie.getTitle(), 1);
			} else {
				Integer currentCount = movieWatchedCount.get(movie.getTitle()) + 1;
				movieWatchedCount.put(movie.getTitle(), currentCount);
			}
		}

		return movieWatchedCount;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		List<Map.Entry<String, Integer>> list =
		new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
			Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
}
