package controllers;

import models.Office;
import models.Person;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }

//    @Transactional
//    public Result addPerson() {
//        Person person = Form.form(Person.class).bindFromRequest().get();
//        JPA.em().persist(person);
//        return redirect(routes.Application.index());
//    }

    @Transactional(readOnly = true)
    public Result getPersons() {
        List<Person> persons = (List<Person>) JPA.em().createQuery("select p from Person p").getResultList();
        return ok(toJson(persons));
    }

//    @Transactional
//    public Result addOffices() {
//        Office office = new Office();
//        office.name="testName";
//        JPA.em().persist(office);
//        return redirect(routes.Application.index());
//    }

    @Transactional(readOnly = true)
    public Result getOffices() {
        List<Office> offices = (List<Office>) JPA.em().createQuery("select p from Office p").getResultList();
        response().setHeader(ACCESS_CONTROL_ALLOW_ORIGIN,"*");
        return ok(toJson(offices));
    }

    @Transactional(readOnly = true)
    public Result getOffice(String officeId) {
        Office office =JPA.em().find(Office.class,officeId);
//        Office office = (Office) JPA.em().createQuery("select p from Office p w").getSingleResult();
        response().setHeader(ACCESS_CONTROL_ALLOW_ORIGIN,"*");
        return ok(toJson(office));
    }
}
