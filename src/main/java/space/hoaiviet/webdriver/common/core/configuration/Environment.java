package space.hoaiviet.webdriver.common.core.configuration;

import lombok.Getter;

/**
 * Created by hoaiviet on 5/18/17.
 * Environment
 */
public enum Environment {

    UAT("uat-hq-frontend.seven-system.com", "uat"),
    TEST_1("qa-sc-1.seven-system.com", "test1"),
    TEST_2("qa-sc-2.seven-system.com", "test2"),
    MAPPING_1("mapping-sc-1.seven-system.com", "mapping1"),
    MAPPING_2("mapping-sc-2.seven-system.com", "mapping2"),
    DEVELOPMENT_1("dev-sc.seven-system.com", "dev1"),
    DEVELOPMENT_2("dev-sc-2.seven-system.com", "dev2");

    @Getter
    public final String scDomain;

    @Getter
    public final String type;

    Environment(String scDomain, String type) {
        this.scDomain = scDomain;
        this.type = type;
    }
}
