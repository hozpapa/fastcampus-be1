package me.day14.practice.practice01;

import java.util.Arrays;

public class ClassifiedElectronicsGroup {
    private ClassifiedElectronics[] classifiedElectronicsGroup;

    public ClassifiedElectronicsGroup() {
        classifiedElectronicsGroup = new ClassifiedElectronics[Electronic.Company.values().length];

        for (int i = 0; i < classifiedElectronicsGroup.length; i++) {
            classifiedElectronicsGroup[i] = new ClassifiedElectronics();
            classifiedElectronicsGroup[i].setCompany(Electronic.Company.values()[i]);
        }
    }


    public ClassifiedElectronics get(int i) {
        if (!(i >= 0 && i < classifiedElectronicsGroup.length)) return null;
        return classifiedElectronicsGroup[i];
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < classifiedElectronicsGroup.length; i++) {
            for (int j = 0; j < classifiedElectronicsGroup[i].size; j++) {
                str += classifiedElectronicsGroup[i].get(j) + "\n";
            }
        }
        return str;
    }
}
