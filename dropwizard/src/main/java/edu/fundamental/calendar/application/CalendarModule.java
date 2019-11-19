package edu.fundamental.calendar.application;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import edu.fundamental.calendar.dao.EmployeeDao;
import edu.fundamental.calendar.dao.InviteDao;
import edu.fundamental.calendar.dao.MeetingDao;
import edu.fundamental.calendar.provider.InviteServiceProvider;
import edu.fundamental.calendar.provider.ManagementServiceProvider;
import edu.fundamental.calendar.provider.MeetingServiceProvider;
import edu.fundamental.calendar.service.MeetingService;
import edu.fundamental.calendar.store.EmployeeStore;
import edu.fundamental.calendar.store.MeetingStore;
import edu.fundamental.calendar.service.InviteService;
import edu.fundamental.calendar.service.ManagementService;
import edu.fundamental.calendar.store.InviteStore;

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