package dao;
import dao.People;
import org.example.model.Person;
import org.example.model.Mysqlconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PeopleDAO implements People {
    @Override
    public Person create(Person person) {

        String sql = "INSERT INTO person(first_name, last_name) VALUES(?, ?)";

        try (Connection conn = Mysqlconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, person.getFirstname());
            stmt.setString(2, person.getLastname());

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted == 0) {
                throw new RuntimeException("Could not insert person into the database!");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next())
                {
                    return new Person(generatedKeys.getInt(1), person.getFirstname(), person.getLastname());
                } else
                {
                    throw new RuntimeException("No generated keys returned from the database");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to create person");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try (Connection conn = Mysqlconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM person");
             ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                people.add(Person.fromResultSet(result));
            }
        } catch (SQLException e) {
            System.err.println("Failed to fetch all people");
            throw new RuntimeException(e);
        }

        return people;

    }

    @Override
    public Person findById(int id) {
        try (Connection conn = Mysqlconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM person WHERE person_id = ?")) {

            stmt.setInt(1, id);

            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    return Person.fromResultSet(result);
                } else {
                    return null; // Not found
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to find by id");
            throw new RuntimeException(e);
        }
    }



    @Override
    public Collection<Person> findByName(String name) {
        List<Person> people = new ArrayList<>();

        try (Connection conn = Mysqlconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM person WHERE first_name = ? OR last_name = ?")) {

            stmt.setString(1, name);
            stmt.setString(2, name);

            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    people.add(Person.fromResultSet(result));
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to find by name");
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    public Person update(Person person) {
        try (Connection conn = Mysqlconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?")) {

            stmt.setString(1, person.getFirstname());
            stmt.setString(2, person.getLastname());
            stmt.setInt(3, person.getId());

            int rowsChanged = stmt.executeUpdate();
            if (rowsChanged != 1) {
                throw new RuntimeException("Could not update a person with the id " + person.getId());
            }

            return person;
        } catch (SQLException e) {
            System.err.println("Failed to update person");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        try (Connection conn = Mysqlconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM person WHERE person_id = ?")) {

            stmt.setInt(1, id);

            int rowsChanged = stmt.executeUpdate();
            return rowsChanged == 1;
        } catch (SQLException e) {
            System.err.println("Failed to delete by id");
            throw new RuntimeException(e);
        }
    }
}
