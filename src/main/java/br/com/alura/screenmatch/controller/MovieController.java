package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.model.movie.Movie;
import br.com.alura.screenmatch.model.movie.MoviePostData;
import br.com.alura.screenmatch.model.movie.MoviePutData;
import br.com.alura.screenmatch.model.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController
{
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String getMovieList(Model model)
    {
        model.addAttribute("list", movieRepository.findAll());
        return "movies/list";
    }

    @GetMapping("/register")
    public String getMovieRegister(Long id, Model model)
    {
        if(id != null)
        {
            model.addAttribute("movie", movieRepository.getReferenceById(id));
        }

        return "movies/form";
    }

    @PostMapping
    @Transactional
    public String postMovie(MoviePostData moviePostData)
    {
        Movie movie = new Movie(moviePostData);
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @PutMapping
    @Transactional
    public String putMovie(MoviePutData moviePutData)
    {
        movieRepository.getReferenceById(moviePutData.id()).dataUpdate(moviePutData);

        return "redirect:/movies";
    }

    @DeleteMapping
    @Transactional
    public String deleteMovie(Long id)
    {
        movieRepository.deleteById(id);
        return "redirect:/movies";
    }
}