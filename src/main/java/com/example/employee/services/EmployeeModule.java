package com.example.employee.services;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.dao.impl.EmployeeDaoImpl;
import com.example.employee.services.impl.EmployeeServiceImpl;
import com.example.employee.services.impl.LoginServiceImpl;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;

public class EmployeeModule {

    public static void bind(ServiceBinder binder) {
        // binder.bind(MyServiceImpl.class).withId("MyService");
      //  binder.bind(LoginService.class, LoginServiceImpl.class);
        binder.bind(EmployeeService.class, EmployeeServiceImpl.class);
        binder.bind(EmployeeDao.class, EmployeeDaoImpl.class);

    }

    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
//        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "1 s");


    }

}
