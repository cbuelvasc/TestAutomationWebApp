package com.company.annottation;

import com.company.util.Browser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Browser.CHROME)
public @interface ChromeConfig {
}
