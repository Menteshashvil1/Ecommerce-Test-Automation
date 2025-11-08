package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataClass {
    Properties pro;
    public ConfigDataClass() throws FileNotFoundException {
        File src = new File("./configs/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getBrowser(){
        return pro.getProperty("browser");
    }

    public String getUrl(){
        return pro.getProperty("url");
    }
    public String getEmail(){
        return pro.getProperty("email");
    }
    public String getPassword(){
        return pro.getProperty("password");
    }
}
