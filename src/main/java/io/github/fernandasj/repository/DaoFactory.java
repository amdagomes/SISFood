package io.github.fernandasj.repository;

public class DaoFactory {

    public static DaoFactoryIF createFactory() {
        return new DaoFactoryBD();
    }
}
