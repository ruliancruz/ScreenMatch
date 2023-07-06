package br.com.alura.screenmatch.model.movie;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer year;
    private Integer duration;
    private String genre;

    public Movie(MoviePostData moviePostData)
    {
        this.title = moviePostData.title();
        this.year = moviePostData.year();
        this.duration = moviePostData.duration();
        this.genre = moviePostData.genre();
    }

    public Movie(){}

    @Override
    public String toString()
    {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                '}';
    }

    public Long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public Integer getYear()
    {
        return year;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public String getGenre()
    {
        return genre;
    }

    public void dataUpdate(MoviePutData moviePutData)
    {
        this.title = moviePutData.title();
        this.year = moviePutData.year();
        this.duration = moviePutData.duration();
        this.genre = moviePutData.genre();
    }
}
