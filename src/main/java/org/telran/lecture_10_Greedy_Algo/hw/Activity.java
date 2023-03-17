package org.telran.lecture_10_Greedy_Algo.hw;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Activity {
    private String name;
    private int start;
    private int end;
    private int value;
}
