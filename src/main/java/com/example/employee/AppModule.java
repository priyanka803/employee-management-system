package com.example.employee;

import com.example.employee.services.LoginService;
import com.example.employee.services.LoginServiceImpl;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;

public class AppModule {

    public static void bind(ServiceBinder binder) {
        // binder.bind(MyServiceImpl.class).withId("MyService");
        //binder.bind(LoginService.class, LoginServiceImpl.class);

    }

    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
//        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "1 s");


    }

}
