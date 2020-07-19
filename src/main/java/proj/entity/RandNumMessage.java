package proj.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class RandNumMessage {
    private final static Logger log = LoggerFactory.getLogger(RandNumMessage.class);

    static Random rand = new Random();
    private Integer randNumber;

    public RandNumMessage() {
        this.randNumber = rand.nextInt(32) + 3;
        log.info("RandNumMessage(): " + randNumber);
    }

    public Integer getRandNumber() {
        return randNumber;
    }
}