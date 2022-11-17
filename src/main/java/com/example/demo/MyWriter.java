package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.database.JpaItemWriter;

import java.util.List;

public class MyWriter extends JpaItemWriter<DemoEntity> {

    private static Logger LOGGER = LogManager.getLogger(MyWriter.class);

    private boolean didThrowOnce = false;

    @Override
    public void write(List<? extends DemoEntity> items) {

        LOGGER.info("About to write " + items);

        if (!didThrowOnce) {
            didThrowOnce = true;
            throw new RuntimeException();
        }

        super.write(items);
    }
}
