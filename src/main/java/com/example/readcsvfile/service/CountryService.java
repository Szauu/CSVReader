package com.example.readcsvfile.service;


import com.example.readcsvfile.model.Country;
import com.example.readcsvfile.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    String line;

    public void saveCountryData() throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Szau\\Desktop\\JAVA\\readcsvfile\\happiness.csv"));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Country c = new Country();
                c.setRegion(data[0]);
                c.setLadder(Integer.parseInt(data[1]));
                c.setSdofLadder(Integer.parseInt(data[2]));
                c.setPositiveAffect(Integer.parseInt(data[3]));
                c.setNegativeAffect(Integer.parseInt(data[4]));
                c.setSocialSupport(Integer.parseInt(data[5]));
                c.setFreedom(Integer.parseInt(data[6]));
                c.setCorruption(Integer.parseInt(data[7]));
                c.setGenerosity(Integer.parseInt(data[8]));
                c.setLogOfGDP(Integer.parseInt(data[9]));
                c.setHealthy(Integer.parseInt(data[10]));
                countryRepository.save(c);
            }
        } catch (StringIndexOutOfBoundsException | IOException e) {
            e.printStackTrace();
        }


    }

    public Connection connect() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/readfromcsv";
        final String user = "postgres";
        final String password = "Postgre1992";
        //TODO zmienić hasło i usera na własnego


        return DriverManager.getConnection(url, user, password);
    }


    private void displayCountry(ResultSet rs) throws SQLException {


        int j = 5;

        System.out.println("5 Państw o największej wolnośći");

        for (int i = 1; i <= j; i++) {
            rs.next();
            System.out.println(rs.getString("region") + "\t"
                    + rs.getInt("freedom"));

        }
    }


    public void getFreedom() {
        String SQL = "SELECT region,freedom FROM country ORDER BY freedom";


        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            displayCountry(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }



    private void displayCorruption(ResultSet rs) throws SQLException {
        int j = 5;

        System.out.println("5 Państw o najmniejszej korupcji");

        for (int i = 1; i <= j; i++) {
            rs.next();
            System.out.println(rs.getString("region") + "\t"
                    + rs.getInt("corruption"));

        }
    }

    public void getCorruption() {
        String SQL = "SELECT region,corruption FROM country ORDER BY corruption ";


        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            displayCorruption(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private void displayHappierPeopleThanPolish(ResultSet rs) throws SQLException {


        System.out.println("Kraje, w których ludzie są szczęśliwsi niż w Polsce");

        while(rs.next()) {

            System.out.println(rs.getString("region") + "\t"
                    + rs.getInt("positive_affect"));

        }
    }

    public void getHappiness() {
        String SQL = "SELECT region, positive_affect FROM country WHERE positive_affect > ( SELECT positive_affect FROM country WHERE region LIKE '%Poland%' ) ORDER BY positive_affect";


        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            displayHappierPeopleThanPolish(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
