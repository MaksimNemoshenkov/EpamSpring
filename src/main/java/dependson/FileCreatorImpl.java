package dependson;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileCreatorImpl implements FileCreator {
    @Override
    @Value("${file.location}")
    public void createFile( String fileLocation) {
       File file = new File(fileLocation);
        try {
            file.createNewFile();
            System.out.println("file: "+fileLocation+ " was created");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
