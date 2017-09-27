

import java.util.*;


class UVaBase {

    public List<String> read() {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            lines.add(s);
        }
        return lines;
    }
}


