/**
 * Created by andrej on 07.07.15.
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Office;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        Office[] offices= readJson();;
        JPA.withTransaction(()->{
//            Office office = new Office();
//            office.id="testId";
//            office.name="testName";

            for (Office office : offices){
                JPA.em().persist(office);
            }

        });
        Logger.info("### Application has started and Offices inserted to DB");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("### Application shutdown...");
    }


    public List<Office> readOfficesFromJsonFile(){
        List<Office> offices = new ArrayList<>();



        return offices;
    }

    public Office[] readJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            URL url = new URL("https://service.bmf.gv.at/Finanzamtsliste.json");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
//            BufferedReader in = new BufferedReader(new FileReader("/home/andrej/temp/Finanzamtsliste.json"));
//            Office[] offices = mapper.readValue(url, Office[].class);
            Office[] offices = mapper.readValue(in, Office[].class);
            Logger.info("### size: "+ offices.length);
            return offices;
        }catch (Exception e){
            Logger.error("### error: ",e);
        }
        return null;
    }
}

