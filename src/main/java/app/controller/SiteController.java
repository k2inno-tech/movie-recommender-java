package app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    	@RequestParam(name="name", required=false, defaultValue="World") String name, 
    	@RequestParam(name="cutoff", required=false, defaultValue="10") String cutoff,
    	Model model) {

    	MovieRecommender movieRecommender = new MovieRecommender();

    	User user = new User("David");
    	user.seedSampleData();
    	user.setUserFriends();

    	List<String> recommendedMovies = movieRecommender.recommendMovies(user, Integer.valueOf(cutoff));

    	List<User> friends = user.getFriends();
    	List<Movie> sampleMovies = user.getSampleMovies();

        model.addAttribute("name", user.getName());
        model.addAttribute("friends", friends);
        model.addAttribute("sampleMovies", sampleMovies);
        model.addAttribute("recommendedMovies", recommendedMovies);

        return "movie/recommend";
    }

}