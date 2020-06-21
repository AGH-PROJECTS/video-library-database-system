package api;

import exception.FetchDataException;
import javafx.collections.ObservableList;
import models.entities.*;

public interface DataHandler  {
    void getAllUsers( ObservableList<UserRecord> data) throws FetchDataException;
    void getAllFilms( ObservableList<FilmRecord> data) throws FetchDataException;
    void getAllOrders( ObservableList<OrderRecord> data) throws FetchDataException;
    ObservableList<UserRecord> getUserById(String user_id) throws FetchDataException;
    ObservableList<FilmRecord> getFilmById(String id_film) throws FetchDataException;
    ObservableList<OrderRecord> getOrderById(String id_order) throws FetchDataException;
    void addUser(String name,String surname,String address,String yoj,String pesel, String role)throws FetchDataException;
    void addFilm(String title,String yop,String age_category,String NameDirector,String SurnameDirector, String genre, String country)throws FetchDataException;
    void addOrder(String user_pesel,String title,String rental_date,String id_emp)throws FetchDataException;
    void updateUser(UserRecord userRecord)throws FetchDataException;
    void deleteUser(Integer id) throws FetchDataException;
    void updateFilm(FilmRecord filmRecord)throws FetchDataException;
    void deleteFilm(Integer id)throws FetchDataException;
    void updateOrder(OrderRecord orderRecord) throws FetchDataException;
    ObservableList<OpinionRecord>  getOpinions(Integer id_film)throws FetchDataException;
    ObservableList<ActorRecord> getActors(Integer id) throws FetchDataException;
    ObservableList<FilmRecord> getFilmByGenre(String genre)throws FetchDataException;
    ObservableList<FilmRecord> getFilmByCountry(String country)throws FetchDataException;
    ObservableList<FilmRecord> getFilmByGenreAndCountry(String genre,String Country)throws FetchDataException;
}
