package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Student student = Student.builder()
                    .dataUrodzenia(LocalDate.of(1990,1,3))
                    .kierunekNauczania("Informatyka")
                    .indeks("123123")
                    .imie("Paweł")
                    .build();

            session.persist(student);
            transaction.commit();

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }

}
