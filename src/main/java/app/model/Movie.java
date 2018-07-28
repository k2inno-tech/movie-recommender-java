package app.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	public String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Movie> sampleMovies = new ArrayList<Movie>();

	public void init() {
		setSampleMovies();
	}

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

	public List<Movie> getSampleMovies() {
		return sampleMovies;
	};

}