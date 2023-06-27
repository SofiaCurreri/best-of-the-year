package org.lessons.java.bestoftheyear.controller;

import org.lessons.java.bestoftheyear.model.Movie;
import org.lessons.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/") //a quale rotta rispondono i metodi di questo controller
public class BestController {

    @GetMapping
    public String template(Model model){
        String name = "Sofia";
        model.addAttribute("name", name);
        return "index";
    }

    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Labyrinth"));
        movies.add(new Movie(2, "Aladdin"));
        movies.add(new Movie(3, "Paprika"));
        movies.add(new Movie(4, "Coraline"));
        movies.add(new Movie(5, "Odio l' estate"));
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Pedro"));
        songs.add(new Song(2, "Crave you"));
        songs.add(new Song(3, "Can I call you tonight?"));
        songs.add(new Song(4, "The Shade"));
        songs.add(new Song(5, "Sanctuary"));
        return songs;
    }

    @GetMapping("/movies")
    public String getMovies(Model model){
        List<Movie> moviesList = getBestMovies();
//        String listTitles = "";
//        for (Movie movie: moviesList) {
//            listTitles += movie.getTitle();
//            if (movie.getId() != moviesList.size()){
//                listTitles += ", ";
//            }
//        }
        model.addAttribute("moviesList", moviesList);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model){
        List<Song> songsList = getBestSongs();
//        String listTitles = "";
//        for (Song song: songsList) {
//            listTitles += song.getTitle();
//            if (song.getId() != songsList.size()){
//                listTitles += ", ";
//            }
//        }
        model.addAttribute("songsList", songsList);
        return "songs";
    }

    @GetMapping("movies/{id}")
    public String movieDetail(@PathVariable("id") Integer movieId, Model model) {
        Movie currentMovie = null;
        for (Movie movie : getBestMovies()){
            if(movie.getId() == movieId){
                currentMovie = movie;
            }
        }
        model.addAttribute("movieDetail", currentMovie);

        return "detailMovie";

    }

    @GetMapping("songs/{id}")
    public String songDetail(@PathVariable("id") Integer songId, Model model) {
        Song currentSong = null;
        for (Song song : getBestSongs()){
            if(song.getId() == songId){
                currentSong = song;
            }
        }
        model.addAttribute("songDetail", currentSong);

        return "detailSong";

    }
}
