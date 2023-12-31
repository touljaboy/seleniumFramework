package utils.testing.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_RETRIES = 2;
    private Logger logger = LogManager.getLogger(RetryAnalyzer.class);
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()) {
            if (count < MAX_RETRIES) {
                count++;
                logger.info("Retrying test method {}!", iTestResult.getName());
                return true;
            }
        }
        logger.info("Test method {} will not be retried!", iTestResult.getName());
        return false;
    }
}
