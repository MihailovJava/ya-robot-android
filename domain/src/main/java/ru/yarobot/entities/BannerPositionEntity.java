package ru.yarobot.entities;

/**
 * Created by Nixy on 15.05.2016.
 */
public class BannerPositionEntity {
    private int countInSearch;
    private int countNotInSearch;
    private int countConflict;

    public int getCountInSearch() {
        return countInSearch;
    }

    public void setCountInSearch(int countInSearch) {
        this.countInSearch = countInSearch;
    }

    public int getCountNotInSearch() {
        return countNotInSearch;
    }

    public void setCountNotInSearch(int countNotInSearch) {
        this.countNotInSearch = countNotInSearch;
    }

    public int getCountConflict() {
        return countConflict;
    }

    public void setCountConflict(int countConflict) {
        this.countConflict = countConflict;
    }

    @Override
    public String toString() {
        return "BannerPositionEntity{" +
                "countInSearch=" + countInSearch +
                ", countNotInSearch=" + countNotInSearch +
                ", countConflict=" + countConflict +
                '}';
    }

    public void incNotInSearch() {
        countNotInSearch++;
    }

    public void incInSearch() {
        countInSearch++;
    }
}
