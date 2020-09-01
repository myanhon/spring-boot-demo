package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();
   
    @Override
    public int insertPerson(final UUID id, final Person person) {
        // TODO Auto-generated method stub
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        // TODO Auto-generated method stub
        return DB;
    }
    
}
