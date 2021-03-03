package com.company.entities.interfaces;

public interface INonprogrammer_member extends IMember{
    String manage();
    void setDoingDuration(int day);
    void setPenalty(int penalty);
    void setBonus(int bonus);
}
