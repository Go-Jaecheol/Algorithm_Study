import java.util.ArrayList;
import java.util.Arrays;

class Number {
    String original;
    String changed;

    public Number(String original) {
        this.original = original;
    }

    public void setChanged() {
        StringBuilder builder = new StringBuilder();

        while (builder.toString().length() <= 4)
            builder.append(original);

        changed = builder.substring(0, 4);
    }
}

class Solution {
    public String solution(int[] numbers) {
        ArrayList<Number> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        if(Arrays.stream(numbers).sum() == 0)
            return "0";

        for (int number : numbers)
            list.add(new Number(Integer.toString(number)));

        for (Number number : list)
            number.setChanged();

        list.sort((o1, o2) -> {
            if (o1.changed.equals(o2.changed))
                return Integer.parseInt(o1.original) - Integer.parseInt(o2.original);
            return Integer.parseInt(o2.changed) - Integer.parseInt(o1.changed);
        });

        for(Number number : list)
            builder.append(number.original);

        return builder.toString();
    }
}