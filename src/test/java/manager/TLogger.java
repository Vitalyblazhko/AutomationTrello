package manager;

import java.io.IOException;
import java.util.logging.*;

public class TLogger {

    static Logger logger;
    Handler fileHandler;
    Formatter plainText;

    public TLogger() throws IOException{
        //instance the logger
        logger = Logger.getLogger(TLogger.class.getName());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //instance the filehandler
        fileHandler = new FileHandler("myLog.txt",true);
        //instance formatter, set formatting, and handler
        plainText = new SimpleFormatter();
        fileHandler.setFormatter(plainText);
        logger.addHandler(fileHandler);

    }

    public static Logger getLogger(){
        if(logger == null){
            try {
                new TLogger();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logger;
    }
    public static void log(Level level, String msg){
        getLogger().log(level, msg);
    }
}
