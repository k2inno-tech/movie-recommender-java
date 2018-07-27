package app.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.User;
import app.model.Movie;
import app.controller.MovieRecommender;

@Controller
public class SiteController {

    @GetMapping("/recommend-movie")
    public String recommendMovieByFriends(
    	@RequestParam(name="name", required=false, defaultValue="World") 
    	String name, 
    	Model model) {

    	MovieRecommender movieRecommender = new MovieRecommender();

    	User user = new User("David");
    	user.seedSampleData();
    	List<String> recommendedMovies = movieRecommender.recommendMovies(user, 3);

    	/*
    	for(Movie movie : recommendedMovies) {
    		System.out.println("Recommended movie: " + movie.getTitle());
    	}

    	for(User friend : user.getFriends()) {
    		System.out.println("Friends: " + friend.getName());	
    		for(Movie movie : friend.getMoviesWatched()) {
    			System.out.println("Watched: " + movie.getTitle());	
    		}
    	}
    	*/

        model.addAttribute("name", name);
        model.addAttribute("recommendedMovies", recommendedMovies);

        return "movie/recommend";
    }

}