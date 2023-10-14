package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private Logger logger = LogManager.getLogger(PropertiesLoader.class);

    //Reading properties function. In the context of this program, the file from which properties are being read is
    //configuration properties. The implementation may be visible in the class TestBase
    public Properties getPropertiesFromFile(String propertiesFileName) {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            logger.info("Trying to load file: " + propertiesFileName);
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            if(inputStream != null) {
                properties.load(inputStream);
                logger.info("Successfully loaded properties from file " + propertiesFileName);
            }
            else throw new FileNotFoundException("Property " +propertiesFileName +" not found in the classpath");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load properties due to IO exception!");
        } finally {
            closeResource(inputStream);
        }

        return properties;
    }

    private void closeResource(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
