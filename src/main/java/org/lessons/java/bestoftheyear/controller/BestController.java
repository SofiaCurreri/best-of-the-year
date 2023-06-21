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

    @GetMapping("/template")
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
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Pedro"));
        songs.add(new Song(2, "Crave you"));
        songs.add(new Song(3, "Can I call you tonight?"));
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

//    @GetMapping("/{id}")
//    public String movieDetail(@PathVariable("id") String movieId, Model model) {
//        model.addAttribute("movieDetail", service.getDetail(bookId));
//
//        return "/detail";
//
//    }
//
//    @GetMapping("/{id}")
//    public String songDetail(@PathVariable("id") String songId, Model model) {
//        model.addAttribute("songDetail", service.getDetail(bookId));
//
//        return "/detail";
//
//    }
}
