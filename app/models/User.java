package models;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
public class User extends Model{


    @Id
    public int id;

    @Constraints.Required
    public String name;

    public static Model.Finder<String, User> find = new Model.Finder<String, User>(String.class, User.class);

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public static  List<User> findAll(){
        return User.find.orderBy("id").findList();
    }
}