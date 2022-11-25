package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MovieController {
    @Autowired
    private BestMovieService bestMovieService;

    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model) {
        model.addAttribute("BestMovie", bestMovieService.getBestMovie().getTitle());
        return "bestMovie";
    }

    @RequestMapping("/voteForTheBestMovieForm")
    public String voteForTheBestMovieForm(Model model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction().commit();
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        session.getTransaction().commit();
        model.addAttribute("movies", movieEntityList);
        return "voteForTheBestMovie";
    }

    @RequestMapping("/voteForTheBestMovie")
    public String voteForTheBestMovie(HttpServletRequest request, Model model) {
        String movieId = request.getParameter("movieID");
        String voterName = request.getParameter("voterName");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        VoteEntity newVote = new VoteEntity();
        newVote.setVoterName(voterName);
        movieEntity.addVote(newVote);
        session.update(movieEntity);
        session.getTransaction().commit();
        return "voteForTheBestMovie";
    }

    @Autowired
    private SessionFactory sessionFactory;
    @RequestMapping("/addMovieForm")
    public String addMovieForm(){
        return "addMovie";
    }
}
