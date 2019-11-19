package edu.fundamental.application;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import edu.fundamental.dao.EmployeeDao;
import edu.fundamental.dao.InviteDao;
import edu.fundamental.dao.MeetingDao;
import edu.fundamental.provider.InviteServiceProvider;
import edu.fundamental.provider.ManagementServiceProvider;
import edu.fundamental.provider.MeetingServiceProvider;
import edu.fundamental.service.MeetingService;
import edu.fundamental.store.EmployeeStore;
import edu.fundamental.store.MeetingStore;
import edu.fundamental.service.InviteService;
import edu.fundamental.service.ManagementService;
import edu.fundamental.store.InviteStore;

public class CalendarModule extends AbstractModule {

    private static CalendarConfig calendarConfig;
    private static Injector injector;

    public static synchronized Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(new CalendarModule(calendarConfig));
        }
        return injector;
    }

    public CalendarModule(CalendarConfig calendarConfig) {
        CalendarModule.calendarConfig = calendarConfig;
    }

    @Override
    protected void configure() {
        // config binding
//        bind(StartupConfig.class).toInstance(calendarConfig.getStartUpConfig());

        // dao bindings
        bind(MeetingDao.class).to(MeetingStore.class).in(Singleton.class);
        bind(InviteDao.class).to(InviteStore.class).in(Singleton.class);
        bind(EmployeeDao.class).to(EmployeeStore.class).in(Singleton.class);

        //service bindings
        bind(MeetingService.class).to(MeetingServiceProvider.class).in(Singleton.class);
        bind(ManagementService.class).to(ManagementServiceProvider.class).in(Singleton.class);
        bind(InviteService.class).to(InviteServiceProvider.class).in(Singleton.class);
    }
}