package api;

import exception.FetchDataException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.entities.*;

import java.sql.*;

public class DataHandlerImpl implements DataHandler {
    private static final DataHandler _instance = new DataHandlerImpl();
    private final String url;
    private final String username;
    private final String password;
    private static final String SQL_GET_ALL_USERS =
            "SELECT * " +
                    "FROM user u " +
                    "ORDER BY u.id_user ASC";

    private static final String SQL_GET_USER_BY_ID =
            "SELECT * " +
                    "FROM user u " +
                    "WHERE u.id_user=";

    private static final String SQL_GET_FILM_BY_ID =
            "SELECT f.id_film,f.title,f.yop,f.age_cat,d.surname,g.genre_name,c.country_name " +
                    "FROM film f " +
                    "INNER  JOIN director d ON d.id_director=f.id_director " +
                    "INNER JOIN genre_film gf ON gf.id_film=f.id_film " +
                    "INNER JOIN genre g ON g.id_genre=gf.id_genre " +
                    "INNER JOIN country_film cf ON cf.id_film=f.id_film " +
                    "INNER JOIN country c ON c.id_country=cf.id_country " +
                    "WHERE f.id_film=";

    private static final String SQL_GET_ALL_FILMS =
            "SELECT f.id_film,f.title,f.yop,f.age_cat,d.name,d.surname,g.genre_name,c.country_name " +
                    "FROM film f " +
                    "INNER  JOIN director d ON d.id_director=f.id_director " +
                    "INNER JOIN genre_film gf ON gf.id_film=f.id_film " +
                    "INNER JOIN genre g ON g.id_genre=gf.id_genre " +
                    "INNER JOIN country_film cf ON cf.id_film=f.id_film " +
                    "INNER JOIN country c ON c.id_country=cf.id_country;";

    private static final String SQL_GET_ALL_ORDERS =
            "SELECT th.id_t_h, u.PESEL,u.name,u.surname,f.title,u.id_user,th.rental_date,th.return_date " +
                    "FROM transaction_hire th " +
                    "INNER JOIN user u ON u.id_user=th.id_user " +
                    "INNER JOIN product p ON th.id_product=p.id_product " +
                    "INNER JOIN film f ON f.id_film=p.id_film";

    private static final String SQL_GET_ORDER_BY_ID =
            "SELECT th.id_t_h, u.PESEL,u.name,u.surname,f.title,u.id_user,th.rental_date,th.return_date " +
                    "FROM transaction_hire th " +
                    "INNER JOIN user u ON u.id_user=th.id_user " +
                    "INNER JOIN product p ON th.id_product=p.id_product " +
                    "INNER JOIN film f ON f.id_film=p.id_film " +
                    "WHERE th.id_t_h=";

    public DataHandlerImpl() {
        url = "jdbc:mysql://remotemysql.com/CirtedsO7n";
        username = "CirtedsO7n";
        password = "558pTtiQE9";
    }

    public static DataHandler getInstance() {
        return _instance;
    }

    @Override
    public ObservableList<UserRecord> getUserById(String user_id) throws FetchDataException {
        ObservableList<UserRecord> userList = FXCollections.observableArrayList();
        int id = -1;
        try {
            id = Integer.parseInt(user_id);
        } catch (Exception e) {
            e.getMessage();
        }
        if (id > 0) {
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL_GET_USER_BY_ID + id)) {

                while (rs.next()) {
                    int i = 1;
                    UserRecord userRecord = new UserRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i));
                    System.out.println(userRecord);
                    userList.add(userRecord);
                }

            } catch (SQLException e) {
                throw new FetchDataException(e);
            }
        }
        return userList;
    }

    @Override
    public ObservableList<FilmRecord> getFilmById(String id_film) throws FetchDataException {
        ObservableList<FilmRecord> filmRecords = FXCollections.observableArrayList();
        int id = -1;
        try {
            id = Integer.parseInt(id_film);
        } catch (Exception e) {
            e.getMessage();
        }
        if (id > 0) {
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL_GET_FILM_BY_ID + id)) {

                while (rs.next()) {
                    int i = 1;
                    FilmRecord filmRecord = new FilmRecord(rs.getInt(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i));
                    System.out.println(filmRecord);
                    filmRecords.add(filmRecord);
                }

            } catch (SQLException e) {
                throw new FetchDataException(e);
            }
        }
        return filmRecords;
    }

    @Override
    public ObservableList<OrderRecord> getOrderById(String id_order) throws FetchDataException {
        ObservableList<OrderRecord> orderRecords = FXCollections.observableArrayList();
        int id = -1;
        try {
            id = Integer.parseInt(id_order);
        } catch (Exception e) {
            e.getMessage();
        }
        if (id > 0) {
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL_GET_ORDER_BY_ID + id)) {

                while (rs.next()) {
                    int i = 1;
                    OrderRecord orderRecord = new OrderRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getInt(i++), rs.getString(i));
                    System.out.println(orderRecord);
                }

            } catch (SQLException e) {
                throw new FetchDataException(e);
            }
        }
        return orderRecords;
    }

    @Override
    public void addUser(String name, String surname, String address, String yoj, String pesel, String role) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            String sql_insert_user = "INSERT INTO user(name,surname,address,yoj,PESEL,role) " +
                    "VALUES('" + name + "','" + surname + "','" + address + "','" + yoj + "','" + pesel + "','" + role + "');";
            stmt.executeUpdate(sql_insert_user);

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void addFilm(String title, String yop, String age_category, String NameDirector, String SurnameDirector, String genre, String country) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            ResultSet rs_director = null;
            ResultSet rs_genre = null;
            ResultSet rs_country = null;
            ResultSet rs_film = null;
            Statement stmt = conn.createStatement();

            String sql_check_director = "SELECT id_director FROM director WHERE name='" + NameDirector + "'AND surname='" + SurnameDirector + "';";
            rs_director = stmt.executeQuery(sql_check_director);

            int last_director_id = 0;
            if (!rs_director.next()) {
                //jesli nie istnieje rezyser;
                String sql_insert_director =
                        "Insert Into director(name,surname) VALUES('" + NameDirector + "','" + SurnameDirector + "');";
                stmt.executeUpdate(sql_insert_director, Statement.RETURN_GENERATED_KEYS);
                rs_director = stmt.getGeneratedKeys();

                if (rs_director.next()) {
                    last_director_id = rs_director.getInt(1);
                }
            } else {
                last_director_id = rs_director.getInt(1);
            }

            String sql_check_genre = "SELECT id_genre FROM genre WHERE genre_name='" + genre + "';";
            rs_genre = stmt.executeQuery(sql_check_genre);

            int last_genre_id = 0;
            if (!rs_genre.next()) {
                //jesli gatunek nie istenieje
                String sql_insert_genre =
                        "Insert Into genre(genre_name) VALUES('" + genre + "');";
                stmt.executeUpdate(sql_insert_genre, Statement.RETURN_GENERATED_KEYS);

                rs_genre = stmt.getGeneratedKeys();

                if (rs_genre.next()) {
                    last_genre_id = rs_genre.getInt(1);
                }
            } else {
                last_genre_id = rs_genre.getInt(1);
            }

            String sql_check_country = "SELECT id_country FROM country WHERE country_name='" + country + "';";
            rs_country = stmt.executeQuery(sql_check_country);

            int last_country_id = 0;
            if (!rs_country.next()) {
                //jesli kraj nie istenieje
                String sql_insert_genre =
                        "Insert Into country(country_name) VALUES('" + country + "');";
                stmt.executeUpdate(sql_insert_genre, Statement.RETURN_GENERATED_KEYS);

                rs_country = stmt.getGeneratedKeys();

                if (rs_country.next()) {
                    last_country_id = rs_country.getInt(1);
                }
            } else {
                last_country_id = rs_country.getInt(1);
            }

            //tu wstawiamy film
            int last_film_id = 0;
            String sql_insert_film =
                    "Insert into film(yop,id_director,title,age_cat) VALUES('" + yop + "'," + last_director_id + ",'" + title + "','" + age_category + "');";
            stmt.executeUpdate(sql_insert_film, Statement.RETURN_GENERATED_KEYS);
            rs_film = stmt.getGeneratedKeys();

            if (rs_film.next()) {
                last_film_id = rs_film.getInt(1);
            }

            String sql_insert_genre_film =
                    "Insert Into genre_film(id_genre,id_film) Values(" + last_genre_id + "," + last_film_id + ");";

            stmt.executeUpdate(sql_insert_genre_film);

            String sql_insert_country_film =
                    "Insert Into country_film(id_country,id_film) Values(" + last_country_id + "," + last_film_id + ");";
            stmt.executeUpdate(sql_insert_country_film);


        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void updateUser(UserRecord userRecord) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            String sql_update_user = "UPDATE user SET name='" + userRecord.getName() + "',surname='" + userRecord.getSurname() + "',PESEL='" + userRecord.getPesel() + "' WHERE id_user=" + userRecord.getUser_id() + ";";
            stmt.executeUpdate(sql_update_user);

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void deleteUser(Integer id) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            String sql_delete_user = "DELETE FROM user WHERE id_user=" + id + ";";
            stmt.executeUpdate(sql_delete_user);

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void updateFilm(FilmRecord filmRecord) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            ResultSet rs = null;

            Statement stmt = conn.createStatement();
            ResultSet rs_director = null;
            ResultSet rs_genre = null;
            ResultSet rs_country = null;

            //film + director
            String sql_check_director = "SELECT id_director FROM director WHERE name='" + filmRecord.getDirector_name() + "'AND surname='" + filmRecord.getDirector_surname() + "';";
            rs_director = stmt.executeQuery(sql_check_director);

            int last_director_id = 0;
            if (!rs_director.next()) {
                //jesli nie istnieje rezyser;
                String sql_insert_director =
                        "Insert Into director(name,surname) VALUES('" + filmRecord.getDirector_surname() + "','" + filmRecord.getDirector_surname() + "');";
                stmt.executeUpdate(sql_insert_director, Statement.RETURN_GENERATED_KEYS);
                rs_director = stmt.getGeneratedKeys();

                if (rs_director.next()) {
                    last_director_id = rs_director.getInt(1);
                }
            } else {
                last_director_id = rs_director.getInt(1);
            }

            String sql_update_user= "UPDATE film SET title='"+filmRecord.getTitle()+"', yop='"+filmRecord.getYop()+"', age_cat='"+filmRecord.getAge_category()+"'," +
                    " id_director="+last_director_id+";";

            //genre
            String sql_check_genre = "SELECT id_genre FROM genre WHERE genre_name='" + filmRecord.getGenre() + "';";
            rs_genre = stmt.executeQuery(sql_check_genre);

            int last_genre_id = 0;
            if (!rs_genre.next()) {
                //jesli gatunek nie istenieje
                String sql_insert_genre =
                        "Insert Into genre(genre_name) VALUES('" + filmRecord.getGenre() + "');";
                stmt.executeUpdate(sql_insert_genre, Statement.RETURN_GENERATED_KEYS);

                rs_genre = stmt.getGeneratedKeys();

                if (rs_genre.next()) {
                    last_genre_id = rs_genre.getInt(1);
                }
            } else {
                last_genre_id = rs_genre.getInt(1);
            }

            String sql_update_user3="UPDATE genre_film SET id_genre="+last_genre_id+" WHERE id_film="+filmRecord.getId_film()+";";

            //country
            String sql_check_country = "SELECT id_country FROM country WHERE country_name='" + filmRecord.getCountry() + "';";
            rs_country = stmt.executeQuery(sql_check_country);
            int last_country_id = 0;
            if (!rs_country.next()) {
                //jesli kraj nie istenieje
                String sql_insert_genre =
                        "Insert Into country(country_name) VALUES('" + filmRecord.getCountry() + "');";
                stmt.executeUpdate(sql_insert_genre, Statement.RETURN_GENERATED_KEYS);

                rs_country = stmt.getGeneratedKeys();

                if (rs_country.next()) {
                    last_country_id = rs_country.getInt(1);
                }
            } else {
                last_country_id = rs_country.getInt(1);
            }

            String sql_update_user2="UPDATE country_film SET id_country="+last_country_id+"WHERE id_film="+filmRecord.getId_film()+";";



            stmt.executeUpdate(sql_update_user);
            stmt.executeUpdate(sql_update_user2);
            stmt.executeUpdate(sql_update_user3);

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void updateOrder(OrderRecord orderRecord) throws FetchDataException{
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            String sql_update_order = "polecenie";
            stmt.executeUpdate(sql_update_order);

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }
    @Override
    public void deleteFilm(Integer id) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            String sql_delete_user = "DELETE FROM film WHERE id_film=" + id + ";";
            stmt.executeUpdate(sql_delete_user);
        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void addOrder(String user_pesel, String title, String rental_date, String id_emp) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            ResultSet rs_user = null;
            ResultSet rs_film = null;
            Statement stmt = conn.createStatement();

            String sql_get_id_user = "SELECT id_user FROM user WHERE PESEL='" + user_pesel + "';";
            rs_user = stmt.executeQuery(sql_get_id_user);


            int get_id_user = 0;
            if (rs_user.next()) {
                get_id_user = rs_user.getInt(1);
            }

            String sql_get_id_film = "SELECT id_film FROM film WHERE title='" + title + "';";
            rs_film = stmt.executeQuery(sql_get_id_film);

            int get_id_film = 0;
            if (rs_film.next()) {
                get_id_film = rs_film.getInt(1);
            }

            ResultSet rs_product = null;

            String sql_insert_product = "SELECT id_product FROM product WHERE id_film=" + get_id_film + " LIMIT 1;";
            rs_product = stmt.executeQuery(sql_insert_product);

            int get_id_product = 0;
            if (rs_product.next()) {
                get_id_product = rs_product.getInt(1);
            }

            String sql_insert_user =
                    "INSERT INTO transaction_hire(id_user,id_emp,id_product,rental_date) " +
                            "VALUES(" + get_id_user + "," + id_emp + "," + get_id_product + ",'" + rental_date + "');";
            stmt.executeUpdate(sql_insert_user);

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void getAllUsers(ObservableList<UserRecord> data) throws FetchDataException {


        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_ALL_USERS)) {
            int i;

            while (rs.next()) {
                i = 1;
                UserRecord userRecord = new UserRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i));
                System.out.println(userRecord);
                data.add(userRecord);

            }

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void getAllFilms(ObservableList<FilmRecord> data) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_ALL_FILMS)) {
            int i;
            while (rs.next()) {
                i = 1;

                FilmRecord filmRecord = new FilmRecord(rs.getInt(i++),  rs.getString(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i));
                System.out.println("!");
                System.out.println(filmRecord);
                data.add(filmRecord);

            }

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public void getAllOrders(ObservableList<OrderRecord> data) throws FetchDataException {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_ALL_ORDERS)) {
            int i;
            while (rs.next()) {
                i = 1;
                OrderRecord orderRecord = new OrderRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getInt(i++), rs.getString(i));
                System.out.println(orderRecord);
                data.add(orderRecord);
            }

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
    }

    @Override
    public ObservableList<OpinionRecord> getOpinions(Integer id) throws FetchDataException {

        String sql_get_opinions = "select id_user, description, opinion_date from opinion where id_film=" + id + ";";
        ObservableList<OpinionRecord> data=FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql_get_opinions)) {
            int i;

            while (rs.next()) {
                i = 1;
                OpinionRecord opinionRecord = new OpinionRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i));
                System.out.println(opinionRecord);
                data.add(opinionRecord);
            }
        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
        return data;
    }

    @Override
    public ObservableList<ActorRecord> getActors(Integer id) throws FetchDataException {

        String sql_get_actors ="select a.id_actor, a.name, a.surname from actor a "+
        "Inner join actor_film af on af.id_actor=a.id_actor "+
        "Where af.id_film=" + id + ";";

        ObservableList<ActorRecord> data=FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql_get_actors)) {
            int i;

            while (rs.next()) {
                i = 1;
                ActorRecord actorRecord = new ActorRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i));
                System.out.println(actorRecord);
                data.add(actorRecord);
            }
        } catch (SQLException e) {
            throw new FetchDataException(e);
        }
        return data;
    }

    @Override
    public ObservableList<FilmRecord> getFilmByGenre(String genre)throws FetchDataException{
        ObservableList<FilmRecord> filmRecords = FXCollections.observableArrayList();

        String get_film_by_genre="SELECT f.id_film,f.title,f.yop,f.age_cat,d.surname,g.genre_name,c.country_name " +
                "FROM film f " +
                "INNER  JOIN director d ON d.id_director=f.id_director " +
                "INNER JOIN genre_film gf ON gf.id_film=f.id_film " +
                "INNER JOIN genre g ON g.id_genre=gf.id_genre " +
                "INNER JOIN country_film cf ON cf.id_film=f.id_film " +
                "INNER JOIN country c ON c.id_country=cf.id_country " +
                "WHERE g.genre_name='"+genre+"';";
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(get_film_by_genre)) {

                while (rs.next()) {
                    int i = 1;
                    FilmRecord filmRecord = new FilmRecord(rs.getInt(i++),  rs.getString(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i));
                    filmRecords.add(filmRecord);
                }

            } catch (SQLException e) {
                throw new FetchDataException(e);
            }

        return filmRecords;
    }
    @Override
    public ObservableList<FilmRecord> getFilmByCountry(String country)throws FetchDataException{
        ObservableList<FilmRecord> filmRecords = FXCollections.observableArrayList();

        String get_film_by_country="SELECT f.id_film,f.title,f.yop,f.age_cat,d.surname,g.genre_name,c.country_name " +
                "FROM film f " +
                "INNER  JOIN director d ON d.id_director=f.id_director " +
                "INNER JOIN genre_film gf ON gf.id_film=f.id_film " +
                "INNER JOIN genre g ON g.id_genre=gf.id_genre " +
                "INNER JOIN country_film cf ON cf.id_film=f.id_film " +
                "INNER JOIN country c ON c.id_country=cf.id_country " +
                "WHERE c.country_name='"+country+"';";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(get_film_by_country)) {

            while (rs.next()) {
                int i = 1;
                FilmRecord filmRecord = new FilmRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i));
                filmRecords.add(filmRecord);
            }

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }

        return filmRecords;
    }
    @Override
    public ObservableList<FilmRecord> getFilmByGenreAndCountry(String genre,String country)throws FetchDataException{
        ObservableList<FilmRecord> filmRecords = FXCollections.observableArrayList();

        String get_film_by_genre_and_country="SELECT f.id_film,f.title,f.yop,f.age_cat,d.surname,g.genre_name,c.country_name " +
                "FROM film f " +
                "INNER  JOIN director d ON d.id_director=f.id_director " +
                "INNER JOIN genre_film gf ON gf.id_film=f.id_film " +
                "INNER JOIN genre g ON g.id_genre=gf.id_genre " +
                "INNER JOIN country_film cf ON cf.id_film=f.id_film " +
                "INNER JOIN country c ON c.id_country=cf.id_country " +
                "WHERE g.genre_name='"+genre+"' AND c.country_name='"+country+"';";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(get_film_by_genre_and_country)) {

            while (rs.next()) {
                int i = 1;
                FilmRecord filmRecord = new FilmRecord(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i));
                filmRecords.add(filmRecord);
            }

        } catch (SQLException e) {
            throw new FetchDataException(e);
        }

        return filmRecords;
    }
}
