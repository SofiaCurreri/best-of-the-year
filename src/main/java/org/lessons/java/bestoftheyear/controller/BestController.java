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
        movies.add(new Movie(1, "Labyrinth", "https://m.media-amazon.com/images/M/MV5BMjM2MDE4OTQwOV5BMl5BanBnXkFtZTgwNjgxMTg2NzE@._V1_FMjpg_UX1000_.jpg"));
        movies.add(new Movie(2, "Aladdin", "https://images.moviesanywhere.com/b1007cc8f77aea276c123b2cc543e8ec/05edd7b6-f452-4396-b547-71967c64a057.jpg"));
        movies.add(new Movie(3, "Paprika", "https://m.media-amazon.com/images/M/MV5BNDI4MGEwZDAtZDg0Yy00MjFhLTg1MjctODdmZTMyNTUyNDI3L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_.jpg"));
        movies.add(new Movie(4, "Coraline", "https://i.etsystatic.com/27984084/r/il/dd51ec/3307341054/il_fullxfull.3307341054_4xo6.jpg"));
        movies.add(new Movie(5, "Odio l' estate", "https://pad.mymovies.it/filmclub/2019/07/250/locandina1000.jpg"));
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Pedro", "https://i.scdn.co/image/ab67616d0000b2738b90b371248a27daa7e3d774"));
        songs.add(new Song(2, "Crave you", "https://i.scdn.co/image/ab67616d0000b273bb0ba14641d1c0b6b61a5234"));
        songs.add(new Song(3, "Can I call you tonight?", "https://lastfm.freetls.fastly.net/i/u/ar0/cad2d300376ed1e482123ca2bcadb0a3.jpg"));
        songs.add(new Song(4, "The Shade", "https://i.scdn.co/image/ab67616d0000b2735b656d32ea6b0b9c54c2d2e0"));
        songs.add(new Song(5, "Sanctuary", "https://i.scdn.co/image/ab67616d0000b27323c552a7a4fdafac02e08c34"));
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
