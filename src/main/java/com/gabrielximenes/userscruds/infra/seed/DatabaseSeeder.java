package com.gabrielximenes.userscruds.infra.seed;

import com.gabrielximenes.userscruds.infra.seed.data.DataSeed;
import com.gabrielximenes.userscruds.infra.seed.data.UserData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final List<DataSeed> dataSeeds;

    public DatabaseSeeder(
            UserData userData
    ) {
        this.dataSeeds = List.of(
                userData
        );
    }

    @Override
    public void run(String... args) {
        dataSeeds.forEach(DataSeed::create);
    }
}
