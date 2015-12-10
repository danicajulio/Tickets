package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import play.Logger;

@Entity
public class Ticket extends Model {

  @Id
  public Long id;

  @Required
  public String title;
  public String desc;
  public String severity;

  public String owner;
  public String responsible;
  public String status;

  public String date;

  public String comment;



  public static Finder<Long,Ticket> find = new Finder(Long.class, Ticket.class);

  public static List<Ticket> all() {

    return find.all();
  }

  public static void create(Ticket ticket) {
  	ticket.save();
  }

  public static void delete(Long id) {
  	find.ref(id).delete();
  }

  public static void update(Ticket tic , Long id) {
    Ticket ticket = Ticket.show(id);
    ticket.title = tic.title;
    ticket.desc = tic.desc;
    ticket.severity = tic.severity;
    ticket.owner = tic.owner;
    ticket.responsible = tic.responsible;
    ticket.date = tic.date;
    ticket.comment = tic.comment;
    Logger.debug(tic.title);
    ticket.save();
  }

  public static void status (Long id){
    Ticket ticket = Ticket.show(id);
    ticket.status = "open";
    ticket.save();
  }

  public static Ticket show(Long id) {
    return find.byId(id);
  }
}
