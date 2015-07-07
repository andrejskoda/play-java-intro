/**
 * Created by andrej on 07.07.15.
 */
import models.Office;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        JPA.withTransaction(()->{
            Office office = new Office();
            office.name="testName";
            JPA.em().persist(office);
        });
        Logger.info("### Application has started and Offices inserted to DB");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("### Application shutdown...");
    }

}